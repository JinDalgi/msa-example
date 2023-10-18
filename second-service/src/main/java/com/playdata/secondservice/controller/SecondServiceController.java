package com.playdata.secondservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@RequiredArgsConstructor
public class SecondServiceController {

    private final Environment env;

    @GetMapping("/hello")
    public String hello() {
        return "Hello Second-Service!";
    }

    @GetMapping("/header-check")
    public String headerCheck(@RequestHeader("sshyml") String headerMsg) {
        return headerMsg;
    }

    @GetMapping("/port-check")
    public String portCheck() {
        return env.getProperty("local.server.port");
    }

}
