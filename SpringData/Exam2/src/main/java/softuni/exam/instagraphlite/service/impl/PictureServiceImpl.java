package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURE_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\exam2\\src\\main\\resources\\files\\pictures.json";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public Boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(pictureSeedDto -> {
                    boolean isValid = validatorUtil.isValid(pictureSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Picture, with size %.2f", pictureSeedDto.getSize())
                            : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(pictureSeedDto -> modelMapper.map(pictureSeedDto, Picture.class))
                .forEach(picture -> {
                    try {
                        pictureRepository.save(picture);
                    } catch (Throwable e) {
                        sb.append("Invalid picture").append(System.lineSeparator());
                    }
                });


        return sb.toString();
    }

    @Override
    public String exportPictures() {

        StringBuilder sb = new StringBuilder();
        List<Picture> pictures = pictureRepository.findAllBySizeGreaterThanOrderBySize(BigDecimal.valueOf(30000));

        pictures.forEach(picture -> {
            sb.append(String.format("%.2f - %s",picture.getSize(),picture.getPath())).append(System.lineSeparator());
        });

        return sb.toString();
    }

    @Override
    public boolean findPictureByFilePath(String profilePicture) {

        return pictureRepository.existsByPath(profilePicture);
    }

    @Override
    public Picture getPictureByFilePath(String profilePicture) {
        return pictureRepository.findByPath(profilePicture).orElse(null);
    }

    @Override
    public boolean existPictureByPath(String path) {

        return pictureRepository.existsByPath(path);
    }
}
