package com.stackroute.gameapp.service;

import com.stackroute.gameapp.domain.Player;
import com.stackroute.gameapp.exception.UserNotFoundException;
import com.stackroute.gameapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers(){
        return playerRepository.getAllPlayers();
    }

    @Override
    public void removePlayer(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> findPlayer(String name)throws UserNotFoundException {
        if(playerRepository.findCountName(name)==0)
            throw new UserNotFoundException("User doesn't exist");
        else
            return playerRepository.findByName(name);
    }
}
