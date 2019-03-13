package com.stackroute.gameapp.repository;

import com.stackroute.gameapp.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query("Select p from Player p")
    List<Player> getAllPlayers();

    @Query("Select count(p) from Player p where p.name = ?1")
    int findCountName(String name);

    @Query("Select p from Player p where p.name = ?1")
    List<Player> findByName(String name);


}
