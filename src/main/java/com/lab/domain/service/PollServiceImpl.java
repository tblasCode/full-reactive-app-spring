package com.lab.domain.service;

import org.springframework.stereotype.Service;

import com.lab.adapter.persistence.PollRepository;
import com.lab.domain.model.Poll;

import reactor.core.publisher.Flux;

@Service
public class PollServiceImpl implements PollService{

  private final PollRepository pollRepository;
  public PollServiceImpl(PollRepository pollRepository) {
    this.pollRepository = pollRepository;
  }
  @Override
  public Flux<Poll> getAll() {
    return pollRepository.findAll();
  }

}
