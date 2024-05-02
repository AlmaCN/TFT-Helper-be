package com.cnade.betfthelper.repository;

import com.cnade.betfthelper.entity.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByPlayer_PlayerName(String playerName);

}
