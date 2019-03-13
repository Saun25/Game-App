package com.stackroute.gameapp.component;

import com.stackroute.gameapp.domain.Player;
import com.stackroute.gameapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlayerCommandLineRunner implements CommandLineRunner {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerCommandLineRunner(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * This method overrides the run method of CommandLineRunner
     * and is used to insert seed data into the database when the application is run
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        playerRepository.save(new Player(2, "Ajay", 200));
    }
}
