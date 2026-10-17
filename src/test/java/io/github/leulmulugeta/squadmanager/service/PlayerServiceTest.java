package io.github.leulmulugeta.squadmanager.service;

import io.github.leulmulugeta.squadmanager.dto.PlayerResponse;
import io.github.leulmulugeta.squadmanager.model.Player;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerPosition;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerStatus;
import io.github.leulmulugeta.squadmanager.repository.PlayerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void getAllPlayers_shouldReturnPlayerResponses() {
        Player player1 = Player.builder()
                .playerId(1)
                .licenseNumber(1001)
                .firstName("Mike")
                .lastName("Maignan")
                .birthDate(LocalDate.of(1995, 7, 3))
                .height(191)
                .weight(89.0f)
                .playerStatus(PlayerStatus.ACTIVE)
                .playerPosition(PlayerPosition.GOALKEEPER)
                .build();

        Player player2 = Player.builder()
                .playerId(2)
                .licenseNumber(1002)
                .firstName("Ibrahima")
                .lastName("Konaté")
                .birthDate(LocalDate.of(1999, 5, 25))
                .height(194)
                .weight(95.0f)
                .playerStatus(PlayerStatus.INJURED)
                .playerPosition(PlayerPosition.DEFENDER)
                .build();

        when(playerRepository.findAll()).thenReturn(List.of(player1, player2));

        List<PlayerResponse> responses = playerService.getAllPlayers();

        Assertions.assertThat(responses).hasSize(2);

        Assertions.assertThat(responses.getFirst().getPlayerId()).isEqualTo(1);
        Assertions.assertThat(responses.getFirst().getLicenseNumber()).isEqualTo(1001);
        Assertions.assertThat(responses.getFirst().getFirstName()).isEqualTo("Mike");
        Assertions.assertThat(responses.getFirst().getLastName()).isEqualTo("Maignan");
        Assertions.assertThat(responses.getFirst().getBirthDate()).isEqualTo(LocalDate.of(1995, 7, 3));
        Assertions.assertThat(responses.getFirst().getHeight()).isEqualTo(191);
        Assertions.assertThat(responses.getFirst().getWeight()).isEqualTo(89.0f);
        Assertions.assertThat(responses.getFirst().getPlayerStatus()).isEqualTo(PlayerStatus.ACTIVE);
        Assertions.assertThat(responses.getFirst().getPlayerPosition()).isEqualTo(PlayerPosition.GOALKEEPER);

        Assertions.assertThat(responses.getLast().getPlayerId()).isEqualTo(2);
        Assertions.assertThat(responses.getLast().getFirstName()).isEqualTo("Ibrahima");
    }

    @Test
    public void getAllPlayers_shouldReturnEmptyList() {
        when(playerRepository.findAll()).thenReturn(List.of());

        List<PlayerResponse> responses = playerService.getAllPlayers();

        Assertions.assertThat(responses).isEmpty();
    }
}
