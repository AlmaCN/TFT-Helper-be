package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.entity.resource.PlayerAllResource;
import com.cnade.betfthelper.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PlayerGetAllCommand {

    @Autowired
    private PlayerService playerService;

    public List<PlayerAllResource> doExecute() {
        List<Player> players =  playerService.getAll();
        List<PlayerAllResource> playerAll = new ArrayList<>();
        players.forEach(p -> {
            PlayerAllResource playerAllResource = new PlayerAllResource();
            playerAllResource.setPlayerId(p.getPlayerId());
            playerAllResource.setPlayerName(p.getPlayerName());
            playerAllResource.setLeague(p.getLeague());
            playerAllResource.setLeagueTier(p.getLeagueTier());
            playerAllResource.setLpPlayer(p.getLpPlayer());
            playerAllResource.setMatchCounter(p.getMatchCounter());
            playerAll.add(playerAllResource);
        });
        return playerAll;
    }

}
