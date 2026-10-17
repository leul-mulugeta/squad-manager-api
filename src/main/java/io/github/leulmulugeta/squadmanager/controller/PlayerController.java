package io.github.leulmulugeta.squadmanager.controller;

import io.github.leulmulugeta.squadmanager.dto.PlayerResponse;
import io.github.leulmulugeta.squadmanager.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        List<PlayerResponse> response = playerService.getAllPlayers();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
