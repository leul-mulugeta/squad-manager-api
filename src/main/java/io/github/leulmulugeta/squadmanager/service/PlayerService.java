package io.github.leulmulugeta.squadmanager.service;

import io.github.leulmulugeta.squadmanager.dto.PlayerResponse;
import io.github.leulmulugeta.squadmanager.model.Player;
import io.github.leulmulugeta.squadmanager.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    private static PlayerResponse toResponse(Player player) {
        return PlayerResponse.builder()
                .playerId(player.getPlayerId())
                .licenseNumber(player.getLicenseNumber())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .birthDate(player.getBirthDate())
                .height(player.getHeight())
                .weight(player.getWeight())
                .playerStatus(player.getPlayerStatus())
                .playerPosition(player.getPlayerPosition())
                .build();
    }

    @Transactional(readOnly = true)
    public List<PlayerResponse> getAllPlayers() {
        List<Player> players = playerRepository.findAll();

        return players.stream()
                .map(PlayerService::toResponse)
                .toList();
    }
}
