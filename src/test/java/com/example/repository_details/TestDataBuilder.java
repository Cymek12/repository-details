package com.example.repository_details;

import com.example.repository_details.model.RepositoryDTO;

import java.time.LocalDateTime;

public class TestDataBuilder {

    public static RepositoryDTO buildRepositoryDTO() {
        return RepositoryDTO.builder()
                .fullName("barchart/marketdata-api-js")
                .description("JavaScript SDK for accessing streaming market data via WebSockets")
                .cloneUrl("https://github.com/barchart/marketdata-api-js.git")
                .watchersNumber("25")
                .createdAt(LocalDateTime.of(2015, 2, 24, 20, 37, 32))
                .build();
    }
}