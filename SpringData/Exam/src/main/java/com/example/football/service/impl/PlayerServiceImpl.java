package com.example.football.service.impl;

import com.example.football.models.dto.PlayerSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYER_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final StatService statService;
    private final TownService townService;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, StatService statService, TownService townService, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.statService = statService;
        this.townService = townService;
        this.teamService = teamService;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(PLAYER_FILE_PATH, PlayerSeedRootDto.class).getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && townService.getTown(playerSeedDto.getTown().getName())
                            && teamService.getTown(playerSeedDto.getTeam().getName())
                            && statService.getStatById(playerSeedDto.getStat().getId());
                    sb.append(isValid
                            ? String.format("Successfully imported Stat %s %s - %s", playerSeedDto.getFirstName(), playerSeedDto.getLastName(), playerSeedDto.getPosition())
                            : "Invalid Player").append(System.lineSeparator());

                    return isValid;
                }).map(playerSeedDto -> {
            Player player = modelMapper.map(playerSeedDto, Player.class);
            player.setStat(statService.getStat(playerSeedDto.getStat().getId()));
            player.setTeam(teamService.getTeam(playerSeedDto.getTeam().getName()));
            player.setTown(townService.getTownByName(playerSeedDto.getTown().getName()));
            return player;
        })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestPlayers() {
        StringBuilder sb = new StringBuilder();
        List<Player> allByBirthDateBetween = playerRepository.getPlayers(LocalDate.parse("01-01-1995", DateTimeFormatter.ofPattern("dd-MM-yyyy")), LocalDate.parse("01-01-2003", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        allByBirthDateBetween
                .forEach(player -> {
                    sb.append(String.format("Player - %s %s%n" +
                            "\tPosition %s%n" +
                            "\tTeam %s%n" +
                            "\tStadium %s%n", player.getFirstName(), player.getLastName(), player.getPosition(), player.getTeam().getName(), player.getTeam().getStadiumName(), player.getBirthDate()));

                });
        return sb.toString();
    }
}
