package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SeedTownDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam3\\src\\main\\resources\\files\\json\\towns.json";

    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), SeedTownDto[].class))
                .filter(seedTownDto -> {
                    boolean isValid = validatorUtil.isValid(seedTownDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Town %s - %d", seedTownDto.getName(), seedTownDto.getPopulation())
                            : "Invalid Town")
                    .append(System.lineSeparator());

                    return isValid;

                }).map(seedTownDto -> modelMapper.map(seedTownDto, Town.class))
        .forEach(townRepository::save);


        return sb.toString();
    }

    @Override
    public Town getTownByName(String town) {
        return townRepository.findByName(town).orElse(null);
    }
}
