package io.github.leulmulugeta.squadmanager.repository;

import io.github.leulmulugeta.squadmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
