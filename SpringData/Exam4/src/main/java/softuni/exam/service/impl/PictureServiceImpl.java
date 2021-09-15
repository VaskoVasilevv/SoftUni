package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    private static final String PICTURE_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam4\\src\\main\\resources\\files\\xml\\pictures.xml";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final FileUtil fileUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidatorUtil validatorUtil, FileUtil fileUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public String importPictures() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PICTURE_FILE_PATH, PictureSeedRootDto.class)
        .getPictures()
        .stream()
        .filter(pictureSeedDto -> {

            boolean isValid = validatorUtil.isValid(pictureSeedDto);
            sb.append(isValid
                    ? String.format("Successfully imported picture - %s",pictureSeedDto.getUrl())
                    :"Invalid picture").append(System.lineSeparator());

            return isValid;
        }).map(pictureSeedDto -> modelMapper.map(pictureSeedDto, Picture.class))
        .forEach(pictureRepository::save);

        return sb.toString();
    }

    @Override
    public boolean areImported() {

        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {

        return fileUtil.readFile(PICTURE_FILE_PATH);
    }

    @Override
    public Picture getPicturesByUrl(String url) {

        return pictureRepository.getPictureByUrl(url);
    }

}
