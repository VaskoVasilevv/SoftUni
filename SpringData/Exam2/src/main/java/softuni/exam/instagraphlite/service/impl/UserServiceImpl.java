package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\exam2\\src\\main\\resources\\files\\users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, PictureService pictureService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.pictureService = pictureService;
    }

    @Override
    public Boolean аreImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        UserSeedDto[] userSeedDtos = gson.fromJson(readFromFileContent(), UserSeedDto[].class);

        StringBuilder sb = new StringBuilder();

        Arrays.stream(userSeedDtos)
                .filter(userSeedDto -> {
                    boolean isValid =
                            validatorUtil.isValid(userSeedDto);

                    sb.append(isValid ? String.format("Successfully imported User: %s", userSeedDto.getUsername())
                            : "Invalid username").append(System.lineSeparator());

                    return isValid;
                }).map(userSeedDto -> {
            User user = modelMapper.map(userSeedDto, User.class);
            Picture pictureByFilePath = pictureService.getPictureByFilePath(userSeedDto.getProfilePicture());
            user.setProfilePicture(pictureByFilePath);

            return user;

        })
                .forEach(user -> {
                    try {
                        userRepository.save(user);
                    } catch (Throwable e) {
                        sb.append("Invalid username").append(System.lineSeparator());
                    }
                });


        return sb.toString();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();
        List<User> allUsersOrderedByCountOfPost = userRepository.findAllUsersOrderedByCountOfPost();
        allUsersOrderedByCountOfPost
                .stream()
                .forEach(user -> {
                    sb.append(String.format("User: %s\n" +
                                    "Post count: %d\n"

                            , user.getUsername()
                            , user.getPosts().size()));

                    user.getPosts().forEach(post -> {
                        sb.append(String.format("==Post Details:\n " +
                                        "----Caption: %s\n" +
                                        "----Picture Size: %.2f\n"
                                , post.getCaption()
                                , post.getPicture().getSize()));
                    });

                });
        return sb.toString();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username).orElse(null);
    }

    @Override
    public boolean existByusername(String username) {
        return userRepository.existsByUsername(username);
    }
}
