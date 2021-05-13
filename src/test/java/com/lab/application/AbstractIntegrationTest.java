package com.lab.application;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class AbstractIntegrationTest {

    @Container
    public static GenericContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
            .withUsername("postgres")
            .withPassword("postgres");

    @DynamicPropertySource
    static void containersProperties(DynamicPropertyRegistry registry) {
        /* postgre */
        registry.add("spring.datasource.url", () -> ((PostgreSQLContainer) postgreSQLContainer).getJdbcUrl());
        registry.add("spring.datasource.password", () -> ((PostgreSQLContainer) postgreSQLContainer).getPassword());
        registry.add("spring.datasource.username", () -> ((PostgreSQLContainer) postgreSQLContainer).getUsername());
    }
}
