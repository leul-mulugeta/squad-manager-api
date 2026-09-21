package io.github.leulmulugeta.squadmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SquadManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SquadManagerApiApplication.class, args);
    }
}
