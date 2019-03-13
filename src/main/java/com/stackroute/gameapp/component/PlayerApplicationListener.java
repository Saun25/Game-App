package com.stackroute.gameapp.component;

import com.stackroute.gameapp.domain.Player;
import com.stackroute.gameapp.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PlayerApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private PlayerRepository playerRepository;
    @Value("${playerName}")
    private String playerName;
    @Value("${score}")
    private int score;

    @Autowired
    public PlayerApplicationListener(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * This method overrides the onApplicationEvent method of ApplicationListenener
     * and is used to insert seed data into the database when the application is run
     *
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        playerRepository.save(new Player(1, playerName, score));
    }
}
