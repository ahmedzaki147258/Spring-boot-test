package com.zaki.zaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaki.zaki.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    
}
