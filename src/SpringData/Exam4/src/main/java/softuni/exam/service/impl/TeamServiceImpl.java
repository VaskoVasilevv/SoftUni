package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.TeamSeedRootDto;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.service.PictureService;
import softuni.exam.service.TeamService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class TeamServiceImpl implements TeamService {
    private static final String TEAM_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam4\\src\\main\\resources\\files\\xml\\teams.xml";

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;
    private final PictureService pictureService;

    public TeamServiceImpl(TeamRepository teamRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidatorUtil validatorUtil, FileUtil fileUtil, PictureService pictureService) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
        this.pictureService = pictureService;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(TEAM_FILE_PATH, TeamSeedRootDto.class).getTeams()
                .stream()
                .filter(teamSeedDto -> {
                    boolean isValid = validatorUtil.isValid(teamSeedDto)
                            && pictureService.getPicturesByUrl(teamSeedDto.getPicture().getUrl()) != null
                            && ! teamRepository.existsTeamByName(teamSeedDto.getName());
                    sb.append(isValid ? String.format("Successfully imported - %s",teamSeedDto.getName())
                            : "Invalid team").append(System.lineSeparator());

                    return isValid;
                }).map(teamSeedDto -> {
            Team team = modelMapper.map(teamSeedDto, Team.class);
            team.setPicture(pictureService.getPicturesByUrl(teamSeedDto.getPicture().getUrl()));
            return team;
        }).forEach(teamRepository::save);

        return sb.toString();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {

        return fileUtil.readFile(TEAM_FILE_PATH);
    }

    @Override
    public Team getTeamByNameAndPicture(String teamName, String url) {

       return teamRepository.getTeamByNameAndPicture_Url(teamName,url).orElse(null);
    }

    @Override
    public Team getTeamByName(String name) {
        return teamRepository.getTeamByName(name).orElse(null);
    }
}
