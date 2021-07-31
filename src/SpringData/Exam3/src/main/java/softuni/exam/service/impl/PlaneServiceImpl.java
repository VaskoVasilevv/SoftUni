package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneSeedRootDto;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlaneServiceImpl implements PlaneService {

    private static final String PLANE_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam3\\src\\main\\resources\\files\\xml\\planes.xml";

    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PLANE_FILE_PATH, PlaneSeedRootDto.class).getPlanes()
                .stream()
                .filter(planeSeedDto -> {
                    boolean isValid = validatorUtil.isValid(planeSeedDto);
                    sb.append(isValid
                            ? String.format("Successfully imported Plane %s", planeSeedDto.getRegisterNumber())
                            : "Invalid Plane").append(System.lineSeparator());

                    return isValid;

                }).map(planeSeedDto -> {
            Plane plane = modelMapper.map(planeSeedDto, Plane.class);
            return plane;
        }).forEach(planeRepository::save);

        return sb.toString();
    }

    @Override
    public Plane getPlaneByRegisterNumber(String registerNumber) {
        return planeRepository.findByRegisterNumber(registerNumber).orElse(null);

    }
}
