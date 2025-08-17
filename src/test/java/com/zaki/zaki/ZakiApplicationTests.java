package com.zaki.zaki;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zaki.zaki.model.Player;
import com.zaki.zaki.repository.PlayerRepository;

@SpringBootTest
class ZakiApplicationTests {
	@Autowired
	private PlayerRepository playerRepository;

	@Test
	public void testSavePlayer() {
		Player player = new Player();
		// player.setId(1);
		player.setName("Zaki");
		player.setScore(100);
		playerRepository.save(player);
		Player savPlayer = playerRepository.findById(1L).get();
		System.out.println(savPlayer);
		assertNotNull(savPlayer);
	}

}
