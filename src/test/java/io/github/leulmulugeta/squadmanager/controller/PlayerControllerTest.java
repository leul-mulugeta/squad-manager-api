package io.github.leulmulugeta.squadmanager.controller;

import io.github.leulmulugeta.squadmanager.dto.PlayerResponse;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerPosition;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerStatus;
import io.github.leulmulugeta.squadmanager.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlayerService playerService;

    @Test
    void getAllPlayers_shouldReturnPlayerResponseJsonArray() throws Exception {
        PlayerResponse response1 = PlayerResponse.builder()
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

        PlayerResponse response2 = PlayerResponse.builder()
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

        when(playerService.getAllPlayers()).thenReturn(List.of(response1, response2));

        mockMvc.perform(get("/players"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].playerId").value(1))
                .andExpect(jsonPath("$[0].licenseNumber").value(1001))
                .andExpect(jsonPath("$[0].firstName").value("Mike"))
                .andExpect(jsonPath("$[0].lastName").value("Maignan"))
                .andExpect(jsonPath("$[0].birthDate").value(LocalDate.of(1995, 7, 3).toString()))
                .andExpect(jsonPath("$[0].height").value(191))
                .andExpect(jsonPath("$[0].weight").value(89.0f))
                .andExpect(jsonPath("$[0].playerStatus").value("ACTIVE"))
                .andExpect(jsonPath("$[0].playerPosition").value("GOALKEEPER"))
                .andExpect(jsonPath("$[1].playerId").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Ibrahima"));

    }

    @Test
    void getAllPlayers_shouldReturnEmptyJsonArray() throws Exception {
        when(playerService.getAllPlayers()).thenReturn(List.of());

        mockMvc.perform(get("/players"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));
    }
}
