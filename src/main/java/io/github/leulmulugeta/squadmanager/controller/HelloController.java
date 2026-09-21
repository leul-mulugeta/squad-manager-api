package io.github.leulmulugeta.squadmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/bonjour")
    public String sayHello() {
        return "Bonjour le monde !";
    }
}
