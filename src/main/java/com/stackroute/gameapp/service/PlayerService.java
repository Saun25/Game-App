package com.stackroute.gameapp.service;

import com.stackroute.gameapp.domain.Player;
import com.stackroute.gameapp.exception.UserNotFoundException;

import java.util.List;

public interface PlayerService {
    public Player savePlayer(Player player);

    public List<Player> getAllPlayers();

    public void removePlayer(int id);

    public List findPlayer(String name) throws UserNotFoundException;
}

