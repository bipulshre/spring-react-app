package com.example.teammanagement.service;

import com.example.teammanagement.model.Team;
import com.example.teammanagement.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id){
        return teamRepository.findById(id).orElseThrow(()->new RuntimeException("No team found with the given it"));
    }

    public Team createTeam(Team team){
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team updatedTeam){
        Team existingTeam = getTeamById(id);
        existingTeam.setName(updatedTeam.getName());
        existingTeam.setPlayers(updatedTeam.getPlayers());
        return teamRepository.save(existingTeam);
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }
}
