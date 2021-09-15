package hiberspring.service.impl;

import hiberspring.domain.dtos.EmployeeSeedRootDto;
import hiberspring.domain.entities.Employee;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEES_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam5\\src\\main\\resources\\files\\employees.xml";

    private final EmployeeRepository employeeRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final EmployeeCardService employeeCardService;
    private final BranchService branchService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, EmployeeCardService employeeCardService, BranchService branchService) {
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.employeeCardService = employeeCardService;
        this.branchService = branchService;
    }

    @Override
    public Boolean employeesAreImported() {
        return employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files.readString(Path.of(EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromXml(EMPLOYEES_FILE_PATH, EmployeeSeedRootDto.class).getEmployees()
                .stream()
                .filter(employeeSeedDto -> {
                    boolean isValid = validationUtil.isValid(employeeSeedDto)
                            && branchService.getBranchByName(employeeSeedDto.getBranch()) != null;

                    sb.append(isValid
                            ? String.format("Successfully imported Employee %s %s.", employeeSeedDto.getFirstName(), employeeSeedDto.getLastName())
                            : "Error: invalid data").append(System.lineSeparator());

                    return isValid;
                }).map(employeeSeedDto -> {

            Employee employee = modelMapper.map(employeeSeedDto, Employee.class);

            employee.setBranch(branchService.getBranchByName(employeeSeedDto.getBranch()));
            employee.setCard(employeeCardService.getCardByName(employeeSeedDto.getCard()));

            return employee;
        }).forEach(employeeRepository::save);

        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        StringBuilder sb = new StringBuilder();

        List<Employee> employees = employeeRepository.getEmployeeWorkingInABranchAtLeastOneProduct();
        employees.stream()
                .forEach(employee -> {
                   sb.append( String.format("Name: %s %s\n" +
                            "Position: %s\n" +
                            "Card Number: %s\n" +
                            "-------------------------\n",employee.getFirstName(),employee.getLastName(),employee.getPosition()
                    , employee.getCard().getNumber()));
                });

        return sb.toString();
    }
}
