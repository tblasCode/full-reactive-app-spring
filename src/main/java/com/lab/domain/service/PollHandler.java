package com.lab.domain.service;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.lab.domain.model.Poll;

import reactor.core.publisher.Mono;

@Component
public class PollHandler {

  private final PollService pollService;
  public PollHandler(PollService aPollService) {
    this.pollService = aPollService;
  }
  
  public Mono<ServerResponse> getAllPolls(ServerRequest request) {
    
    return ServerResponse.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(pollService.getAll(), Poll.class).log("GET pollls");
  }
}