package com.lab.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

@ExtendWith(SpringExtension.class)
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RouterTest extends AbstractIntegrationTest {

  // Spring Boot will create a `WebTestClient` for you,
  // already configure and ready to issue requests against "localhost:RANDOM_PORT"
  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void testPolls() {
    webTestClient
      // Create a GET request to test an endpoint
      .get().uri("/polls")
      .accept(MediaType.TEXT_PLAIN)
      .exchange()
      // and use the dedicated DSL to test assertions against the response
      .expectStatus().isOk()
      .expectBody(String.class).isEqualTo("Hello, Labs!");
  }
}