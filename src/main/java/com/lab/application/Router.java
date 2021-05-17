package com.lab.application;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.lab.domain.service.PollHandler;
import com.lab.domain.service.RateHandler;

@Configuration
public class Router {

  @Bean
  public RouterFunction<ServerResponse> route(PollHandler pollHandler, RateHandler rateHandler) {

    return RouterFunctions
      .route(GET("/polls").and(RequestPredicates.accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), pollHandler::getAllPolls)
      .andRoute(POST("/polls/{pollId}/polling").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), rateHandler::rate);
  }
}