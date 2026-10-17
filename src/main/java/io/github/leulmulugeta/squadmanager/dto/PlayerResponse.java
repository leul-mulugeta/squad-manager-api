package io.github.leulmulugeta.squadmanager.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerPosition;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@JsonPropertyOrder({
        "playerId", "licenseNumber", "firstName", "lastName",
        "birthDate", "height", "weight", "playerStatus", "playerPosition"
})
public class PlayerResponse {

    private Integer playerId;
    private Integer licenseNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Integer height;
    private Float weight;
    private PlayerStatus playerStatus;
    private PlayerPosition playerPosition;
}
