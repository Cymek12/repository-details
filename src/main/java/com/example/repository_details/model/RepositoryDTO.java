package com.example.repository_details.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class RepositoryDTO {
    private String fullName;
    private String description;
    private String cloneUrl;
    private String watchersNumber;
    private LocalDateTime createdAt;
}
