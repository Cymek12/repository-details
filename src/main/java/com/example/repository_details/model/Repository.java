package com.example.repository_details.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Repository {
    private String full_name;
    private String description;
    private String clone_url;
    private String watchers_count;
    private LocalDateTime created_at;
}
