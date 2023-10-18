package com.playdata.itemservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item-service")
public class ItemController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "server is available!";
    }
}
