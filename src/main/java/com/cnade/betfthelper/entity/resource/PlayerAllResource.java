package com.cnade.betfthelper.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerAllResource {
    private String playerName;
    private int matchCounter;
    private int comps;
    private int wins;
    private int losses;
}
