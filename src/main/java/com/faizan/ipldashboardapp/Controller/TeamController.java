package com.faizan.ipldashboardapp.Controller;

import com.faizan.ipldashboardapp.model.Team;
import com.faizan.ipldashboardapp.repository.MatchRepository;
import com.faizan.ipldashboardapp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MatchRepository matchRepository;

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team=teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository. findLatestMatchByTeam(teamName,4));
        return team;
    }
}
