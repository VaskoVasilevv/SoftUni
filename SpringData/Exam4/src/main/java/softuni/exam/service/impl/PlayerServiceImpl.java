package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PlayerSeedDto;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.PlayerService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final String PLAYER_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam4\\src\\main\\resources\\files\\json\\players.json";

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;
    private final PictureService pictureService;
    private final TeamService teamService;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil, FileUtil fileUtil, PictureService pictureService, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
        this.pictureService = pictureService;
        this.teamService = teamService;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        String s = fileUtil.readFile(PLAYER_FILE_PATH);
        Arrays.stream(gson.fromJson(s, PlayerSeedDto[].class))
                .filter(playerSeedDto -> {

                    boolean isValid = validatorUtil.isValid(playerSeedDto)
                            && pictureService.getPicturesByUrl(playerSeedDto.getPicture().getUrl()) != null
                            && teamService.getTeamByName(playerSeedDto.getTeam().getName()) != null;
                    sb.append(isValid
                            ? String.format("Successfully imported player - %s %s", playerSeedDto.getFirstName(), playerSeedDto.getLastName())
                            : "Invalid player").append(System.lineSeparator());

                    return isValid;
                }).map(playerSeedDto -> {

            Player player = modelMapper.map(playerSeedDto, Player.class);
            player.setPicture(pictureService.getPicturesByUrl(playerSeedDto.getPicture().getUrl()));
            player.setTeam(teamService.getTeamByName(playerSeedDto.getTeam().getName()));

            return player;
        }).forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return fileUtil.readFile(PLAYER_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();

        List<Player> players = playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000));

        players.stream()
                .forEach(player -> {
                    sb.append(String.format(
                            "\tPlayer name: %s %s\n" +
                                    "\tNumber: %d\n" +
                                    "\tSalary: %.2f\n" +
                                    "\tTeam: %s\n"
                            , player.getFirstName(), player.getLastName()
                            , player.getNumber()
                            , player.getSalary()
                            , player.getTeam().getName()));
                });
        sb.append("\t...");


        return sb.toString();


    }

    @Override
    public String exportPlayersInATeam() {
        Team teamByName = teamService.getTeamByName("North Hub");
        StringBuilder sb = new StringBuilder("Team: " + teamByName.getName()).append(System.lineSeparator());

        teamByName.getPlayers().stream()
                .forEach(player -> {
                    sb.append(String.format(
                            "\tPlayer name: %s %s - %s\n" +
                                    "\tNumber: %d\n"
                            , player.getFirstName(), player.getLastName(), player.getPosition()
                            , player.getNumber()));
                });
        sb.append("\t...");

        return sb.toString();
    }
}
