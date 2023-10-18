package com.playdata.firstservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first-service")
@RequiredArgsConstructor
public class FirstServiceController {

    private final Environment env;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello First-Service!";
    }

    @GetMapping("/header-check")
    public String headerCheck(@RequestHeader("fsreqhyml") String headerMsg) {
        return headerMsg;
    }

    @GetMapping("/port-check")
    public String portCheck() {
        return env.getProperty("local.server.port");
    }
}
