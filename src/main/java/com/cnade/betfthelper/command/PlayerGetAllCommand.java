package com.cnade.betfthelper.command;

import com.cnade.betfthelper.entity.model.Comp;
import com.cnade.betfthelper.entity.model.Player;
import com.cnade.betfthelper.entity.resource.PlayerAllResource;
import com.cnade.betfthelper.service.CompService;
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
    @Autowired
    private CompService compService;

    public List<PlayerAllResource> doExecute() {
        List<Player> players =  playerService.getAll();
        List<PlayerAllResource> playerAll = new ArrayList<>();
        players.forEach(p -> {
            PlayerAllResource playerAllResource = new PlayerAllResource();
            playerAllResource.setPlayerName(p.getPlayerName());
            playerAllResource.setMatchCounter(p.getMatchCounter());
            playerAllResource.setComps(p.getComps().size());
            List<Comp> comps = compService.getAll(p.getPlayerName());
            int wins = comps.stream().mapToInt(Comp::getWins).sum();
            playerAllResource.setWins(wins);
            int losses = p.getMatchCounter() - wins;
            playerAllResource.setLosses(losses);
            playerAll.add(playerAllResource);
        });
        return playerAll;
    }

}
