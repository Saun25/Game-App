package com.stackroute.gameapp.controller;

import com.stackroute.gameapp.domain.Player;
import com.stackroute.gameapp.exception.UserNotFoundException;
import com.stackroute.gameapp.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PlayerController {
    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService) {
        this.playerServiceImpl = playerService;
    }

    /**
     * This method is used to save Player data into the database
     * @param player
     * @return ResponseEntity<Player>
     */
    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        Player playerAdded = playerServiceImpl.savePlayer(player);
        return new ResponseEntity<Player>(playerAdded, HttpStatus.CREATED);
    }

    /**
     * This method is used to get all the Player details from the database
     * @return ResposnseEntity<List>
     */
    @GetMapping("/players")
    public ResponseEntity<List> getAllPlayers() {
        List<Player> playerAdded = playerServiceImpl.getAllPlayers();
        return new ResponseEntity<List>(playerAdded, HttpStatus.OK);
    }

    /**
     * This method is used to delete specific Player detail from the database using id
     * @param id
     * @return ResposnseEntity<List>
     */
    @DeleteMapping("/players/{id}")
    public ResponseEntity<List> removePlayers(@PathVariable int id) {
        playerServiceImpl.removePlayer(id);
        return new ResponseEntity<List>(playerServiceImpl.getAllPlayers(), HttpStatus.OK);
    }

    /**
     * This method is used to find specific Player detail from the database using Player name
     * @param name
     * @return ResposnseEntity<?>
     * @throws UserNotFoundException
     */
    @GetMapping("/players/{name}")
    public ResponseEntity<?> findPlayers(@PathVariable String name) throws UserNotFoundException {
        ResponseEntity responseEntity;

        List<Player> listOfPlayers = playerServiceImpl.findPlayer(name);
        responseEntity = new ResponseEntity<List>(listOfPlayers, HttpStatus.OK);
        return responseEntity;
    }
}
