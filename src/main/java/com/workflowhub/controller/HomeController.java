package com.workflowhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/health")
    public String health() {
        return "WorkFlowHub is running";
    }

    @GetMapping("/version")
    public String version() {
        return "v0.0.1";
    }

    @GetMapping("/about")
    public String about() {
        return "Workflow Backend API";
    }
}