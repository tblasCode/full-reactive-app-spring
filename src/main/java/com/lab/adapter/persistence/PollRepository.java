package com.lab.adapter.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.lab.domain.model.Poll;

public interface PollRepository extends ReactiveCrudRepository<Poll, Integer> {

}
