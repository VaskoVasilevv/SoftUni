package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostSeedRootDto;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {
    private static final String POST_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\exam2\\src\\main\\resources\\files\\posts.xml";

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final UserService userService;
    private final PictureService pictureService;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, UserService userService, PictureService pictureService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @Override
    public Boolean аreImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.FromFile(POST_FILE_PATH, PostSeedRootDto.class).getPosts()
                .stream()
                .filter(postSeedDto -> {
                    boolean isValid = validatorUtil.isValid(postSeedDto)
                            && pictureService.getPictureByFilePath(postSeedDto.getPicture().getPath()) != null
                            && userService.getUserByUsername(postSeedDto.getUser().getUsername()) != null;
                    sb.append(isValid
                            ? String.format("Successfully imported Post, made by %s", postSeedDto.getUser().getUsername())
                            : "Invalid Post").append(System.lineSeparator());

                    return isValid;

                }).map(postSeedDto -> {

            Post post = modelMapper.map(postSeedDto, Post.class);
            post.setUser(userService.getUserByUsername(postSeedDto.getUser().getUsername()));
            post.setPicture(pictureService.getPictureByFilePath(postSeedDto.getPicture().getPath()));

            return post;
        }).forEach(post -> {
            try {
                postRepository.save(post);
            } catch (Throwable e) {
                sb.append("Invalid Post!!!").append(System.lineSeparator());
            }
        });


        return sb.toString();
    }
}
