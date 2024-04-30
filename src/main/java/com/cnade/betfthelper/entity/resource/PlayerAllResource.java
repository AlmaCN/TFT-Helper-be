package com.cnade.betfthelper.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerAllResource {
    private Integer playerId;
    private String playerName;
    private String league;
    private int leagueTier;
    private int lpPlayer;
    private int matchCounter;
}
