package com.zaki.zaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.zaki.zaki.model.Player;
import com.zaki.zaki.repository.PlayerRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getOnePlayer(@PathVariable("id") long id) {
        return playerRepository.findById(id).get();
    }

    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PatchMapping("/players/{id}")
    public Player updatePlayer(@PathVariable("id") long id, @RequestBody Player player) {
        Player playerToUpdate = playerRepository.findById(id).get();
        playerToUpdate.setName(player.getName());
        playerToUpdate.setScore(player.getScore());
        return playerRepository.save(playerToUpdate);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable("id") long id) {
        playerRepository.deleteById(id);
    }
}
