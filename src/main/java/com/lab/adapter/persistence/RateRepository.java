package com.lab.adapter.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.lab.domain.model.Rate;

public interface RateRepository extends ReactiveCrudRepository<Rate, Integer> {

}
