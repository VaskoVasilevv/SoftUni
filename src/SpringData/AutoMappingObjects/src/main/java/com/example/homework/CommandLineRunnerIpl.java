package com.example.homework;

import com.example.homework.model.dto.AddGameDto;
import com.example.homework.model.dto.EditGameDto;
import com.example.homework.model.dto.UserLoginDto;
import com.example.homework.model.dto.UserRegisterDto;
import com.example.homework.service.GameService;
import com.example.homework.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class CommandLineRunnerIpl implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerIpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("For input you can chose from:" +
                "%n     RegisterUser|ivan@ivan.com|Ivan12|Ivan12|Ivan" +
                "%n     LoginUser|ivan@ivan.com|Ivan12%n     Logout" +
                "%n     RegisterUser|ivangmail.com|Ivan12|Ivan12|Ivan" +
                "%n     LoginUser|ivan@ivan.com|Ivan" +
                "%n     Logout" +
                "%n     AddGame|Overwatch|100.00|15.5|FqnKB22pOC0|https://us.battle.net/forums/static/images/social-thumbs/overwatch.png|Overwatch is a team-based multiplayer online first-person shooter video game developed and published by Blizzard Entertainment.|24-05-2016" +
                "%n     EditGame|1|price=80.00|size=12.0" +
                "%n     AllGames" +
                "%n     DetailGame" +
                "%n     OwnedGames%n");
        while (true) {


            System.out.println("Enter commands: \n\r" +
                    "I give you valid inputs in the few lines upper.");
            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0].trim()) {
                case "RegisterUser" -> userService.registerUser(new UserRegisterDto(commands[1], commands[2], commands[3], commands[4]));
                case "LoginUser" -> userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                case "Logout" -> userService.logout();
                case "AddGame" -> gameService.addGame(new AddGameDto(commands[1], new BigDecimal(commands[2]), Double.parseDouble(commands[3]), commands[4],
                        commands[5], commands[6], commands[7]));
                case "EditGame" -> gameService.editGame(Long.parseLong(commands[1]), commands);
                case "DeleteGame" -> gameService.deleteGame(Integer.parseInt(commands[1]));
                case "AllGames" -> gameService.allGames();
                case "DetailGame" -> gameService.detailGame(commands[1]);
                case "OwnedGames" -> gameService.ownedGames();
                default -> System.out.println("Invalid input");
            }
        }
    }
}
