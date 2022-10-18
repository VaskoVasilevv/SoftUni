package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.BranchesSeedDto;
import hiberspring.domain.entities.Branch;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
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
public class BranchServiceImpl implements BranchService {

    private static final String BRANCH_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam5\\src\\main\\resources\\files\\branches.json";

    private final BranchRepository branchRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final FileUtil fileUtil;
    private final TownService townService;

    public BranchServiceImpl(BranchRepository branchRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, FileUtil fileUtil, TownService townService) {
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.fileUtil = fileUtil;
        this.townService = townService;
    }


    @Override
    public Boolean branchesAreImported() {
        return branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(BRANCH_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();


        Arrays.stream(gson.fromJson(readBranchesJsonFile(), BranchesSeedDto[].class))
                .filter(branchesSeedDto -> {
                    boolean isValid = validationUtil.isValid(branchesSeedDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Branch %s.",branchesSeedDto.getName())
                            : "Error: Invalid data.").append(System.lineSeparator());

                    return isValid;
                }).map(branchesSeedDto ->{
            Branch branch = modelMapper.map(branchesSeedDto, Branch.class);
            branch.setTown(townService.getTownByNamde(branchesSeedDto.getTown()));

            return branch;

        })
                .forEach(branchRepository::save);

        return sb.toString();
    }

    @Override
    public Branch getBranchByName(String branch) {

        return branchRepository.findByName(branch);
    }
}
