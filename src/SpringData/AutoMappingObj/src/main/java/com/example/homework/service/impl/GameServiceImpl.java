package com.example.homework.service.impl;

import com.example.homework.model.dto.AddGameDto;
import com.example.homework.model.entity.Game;
import com.example.homework.repository.GameRepository;
import com.example.homework.service.GameService;
import com.example.homework.service.UserService;
import com.example.homework.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(AddGameDto addGameDto) {
        if (userService.hasLoggedInUser()) {
            return;
        }
        Set<ConstraintViolation<AddGameDto>> violations = validationUtil.violation(addGameDto);

        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(addGameDto, Game.class);

        gameRepository.save(game);

        System.out.println("Added " + game.getTitle());

    }

    @Override
    public void ownedGames() {
        gameRepository.findAll().stream()
                .forEach(game -> System.out.println(game.getTitle()));
    }

    @Override
    public void detailGame(String title) {
        Game game = gameRepository.findByTitle(title);

        System.out.println("Title: " + game.getTitle());
        System.out.println("Price: " + game.getPrice());
        System.out.println("Description: " + game.getDescription());
        System.out.println("Release date: " + game.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));


    }

    @Override
    public void allGames() {
        gameRepository.findAll().stream()
                .map(game -> game.getTitle() + " " + game.getPrice())
                .forEach(System.out::println);
    }

    @Override
    public void editGame(long parseLong, String[] commands) {
        if (!userService.hasLoggedInUser()){
            return;
        }
        Game game = gameRepository.findById(parseLong).orElse(null);
        String[] tokens = Arrays.stream(commands).skip(1).toArray(String[]::new);

        if (game == null) {
            System.out.println("There is no such game");
            return;
        }

        for (String token : tokens) {
            String[] fields = token.split("=");

            switch (fields[0]) {
                case "title" -> game.setTitle(fields[1]);
                case "price" -> game.setPrice(new BigDecimal(fields[1]));
                case "size" -> game.setSize(Double.parseDouble(fields[1]));
                case "trailer" -> game.setTrailer(fields[1]);
                case "thumbnailURL" -> game.setImageThumbnail(fields[1]);
                case "description" -> game.setDescription(fields[1]);
            }
            AddGameDto addGameDto = new AddGameDto(game.getTitle(), game.getPrice(), game.getSize(), game.getTrailer(), game.getImageThumbnail(), game.getDescription(), game.getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            Set<ConstraintViolation<AddGameDto>> violation = validationUtil.violation(addGameDto);

            if (!violation.isEmpty()) {
                violation.stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                return;
            }

            gameRepository.save(game);
            System.out.println("Successfully edit game with id " + parseLong);
        }
    }

    @Override
    public void deleteGame(int gameId) {
        Game game = gameRepository.findById((long) gameId).orElse(null);

        if (game != null) {
            gameRepository.delete(game);
            System.out.println("Deleted " + game.getTitle());
        }else {
            System.out.println("There is no such a game id.");
        }


    }
}
