package com.example.homework.service;


import com.example.homework.model.dto.AddGameDto;

public interface GameService {
    void addGame(AddGameDto addGameDto);

    void ownedGames();

    void detailGame(String game);

    void allGames();

    void deleteGame(int gameId);

    void editGame(long parseLong, String[] commands);
}
