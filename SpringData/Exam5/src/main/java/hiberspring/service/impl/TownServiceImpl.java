package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.TownSeedDto;
import hiberspring.domain.entities.Town;
import hiberspring.repository.TownRepository;
import hiberspring.service.TownService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam5\\src\\main\\resources\\files\\towns.json";

    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;

    public TownServiceImpl(TownRepository townRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, FileUtil fileUtil) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean townsAreImported() {
        return townRepository.count()>0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {

        return Files.readString(Path.of(TOWN_FILE_PATH));


    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(gson.fromJson(readTownsJsonFile(), TownSeedDto[].class))
        .filter(townSeedDto -> {
            boolean isValid = validationUtil.isValid(townSeedDto);
            sb.append(isValid
                    ? String.format("Successfully imported Town %s.",townSeedDto.getName())
                    : "Error: Invalid data.").append(System.lineSeparator());

            return isValid;
        }).map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
        .forEach(townRepository::save);
        return sb.toString();
    }

    @Override
    public Town getTownByNamde(String name) {

        return townRepository.findByName(name);
    }
}
