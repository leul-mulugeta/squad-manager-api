package io.github.leulmulugeta.squadmanager.config;

import io.github.leulmulugeta.squadmanager.model.Player;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerPosition;
import io.github.leulmulugeta.squadmanager.model.enums.PlayerStatus;
import io.github.leulmulugeta.squadmanager.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PlayerSeeder {

    @Bean
    CommandLineRunner initDatabase(PlayerRepository playerRepository) {
        return args -> {
            if (playerRepository.count() == 0) {
                Player maignan = createPlayer(
                        1001, "Mike", "Maignan",
                        LocalDate.of(1995, 7, 3), 191, 89.0f,
                        PlayerPosition.GOALKEEPER, PlayerStatus.ACTIVE
                );

                Player konate = createPlayer(
                        1002, "Ibrahima", "Konaté",
                        LocalDate.of(1999, 5, 25), 194, 95.0f,
                        PlayerPosition.DEFENDER, PlayerStatus.INJURED
                );

                Player tchouameni = createPlayer(
                        1003, "Aurélien", "Tchouaméni",
                        LocalDate.of(2000, 1, 27), 187, 81.0f,
                        PlayerPosition.MIDFIELDER, PlayerStatus.SUSPENDED
                );

                Player mbappe = createPlayer(
                        1004, "Kylian", "Mbappé",
                        LocalDate.of(1998, 12, 20), 178, 75.0f,
                        PlayerPosition.FORWARD, PlayerStatus.ABSENT
                );

                playerRepository.saveAll(List.of(maignan, konate, tchouameni, mbappe));
            }
        };
    }

    private Player createPlayer(Integer licenseNumber, String firstName, String lastName,
                                LocalDate birthDate, Integer height, Float weight,
                                PlayerPosition position, PlayerStatus status) {
        Player player = new Player();
        player.setLicenseNumber(licenseNumber);
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setBirthDate(birthDate);
        player.setHeight(height);
        player.setWeight(weight);
        player.setPlayerPosition(position);
        player.setPlayerStatus(status);
        return player;
    }
}
