package com.lab.domain.service;

import com.lab.domain.model.Poll;

import reactor.core.publisher.Flux;

public interface PollService {
  public Flux<Poll> getAll();
}
