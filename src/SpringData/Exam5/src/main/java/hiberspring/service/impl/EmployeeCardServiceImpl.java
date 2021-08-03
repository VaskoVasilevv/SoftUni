package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.EmployeeCardSeedDto;
import hiberspring.domain.entities.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private static final String EMPLOYEE_CARD_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam5\\src\\main\\resources\\files\\employee-cards.json";

    private final EmployeeCardRepository  employeeCardRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.employeeCardRepository = employeeCardRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public Boolean employeeCardsAreImported() {
        return employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEE_CARD_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readEmployeeCardsJsonFile(), EmployeeCardSeedDto[].class))
        .filter(employeeCardSeedDto -> {
            boolean isValid = validationUtil.isValid(employeeCardSeedDto)
                    && !employeeCardRepository.existsByNumber(employeeCardSeedDto.getNumber()) ;

            sb.append(isValid ? String.format("Successfully imported Employee Card %s.",employeeCardSeedDto.getNumber())
                    : "Invalid card").append(System.lineSeparator());

            return  isValid;
        }).map(employeeCardSeedDto -> modelMapper.map(employeeCardSeedDto, EmployeeCard.class))
        .forEach(employeeCardRepository::save);


        return sb.toString();
    }

    @Override
    public EmployeeCard getCardByName(String card) {

        return employeeCardRepository.getEmployeeCardByNumber(card);
    }
}
