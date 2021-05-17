package com.lab.domain.service;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.lab.adapter.persistence.RateRepository;
import com.lab.domain.model.Rate;

import reactor.core.publisher.Mono;

@Component
public class RateHandler {

  private final RateRepository rateRepository;

  public RateHandler(RateRepository rateRepository) {
    this.rateRepository = rateRepository;
  }
  
  public Mono<ServerResponse> rate(ServerRequest request) {
    String pollId = request.pathVariable("pollId");
    request.bodyToMono(Rate.class).doOnNext(rateRepository::save);
    return ServerResponse.noContent().build();
  }
}