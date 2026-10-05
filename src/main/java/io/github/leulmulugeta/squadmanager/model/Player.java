package io.github.leulmulugeta.squadmanager.model;

import io.github.leulmulugeta.squadmanager.model.enums.PlayerPosition;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer playerId;

    private Integer licenseNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Integer height;
    private Float weight;

    @Enumerated(EnumType.STRING)
    private PlayerStatus playerStatus;

    @Enumerated(EnumType.STRING)
    private PlayerPosition playerPosition;
}
