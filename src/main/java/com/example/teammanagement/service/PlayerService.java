package com.example.teammanagement.service;

import com.example.teammanagement.model.Player;
import com.example.teammanagement.model.Team;
import com.example.teammanagement.repository.PlayerRepository;
import com.example.teammanagement.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id){
        return playerRepository.findById(id).orElseThrow(()->new RuntimeException("Player not found with given id"));
    }

    public Player createPlayer(Player player, Long teamId){
        Team team = teamRepository.findById(teamId).orElseThrow(()-> new RuntimeException("Team not found"));
        player.setTeam(team);
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer){

        Player existingPlayer = getPlayerById(id);
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }

}
