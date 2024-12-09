package com.example.teammanagement.controller;

import com.example.teammanagement.model.Player;
import com.example.teammanagement.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id){
        return playerService.getPlayerById(id);
    }

    @PostMapping("/{teamId}")
    public Player createPlayer(@RequestBody Player player, @PathVariable Long teamId) {
        return playerService.createPlayer(player, teamId);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }





}
