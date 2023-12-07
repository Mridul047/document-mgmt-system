package com.mycodethesaurus.documentmgmtsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class HelperController {

  @GetMapping("/status")
  public String checkAppStatus() {
    return "Hello App is running! " + LocalDateTime.now(Clock.systemDefaultZone()).toString();
  }
}
