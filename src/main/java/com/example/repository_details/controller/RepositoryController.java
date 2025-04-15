package com.example.repository_details.controller;

import com.example.repository_details.model.Repository;
import com.example.repository_details.model.RepositoryDTO;
import com.example.repository_details.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class RepositoryController {
    private final RepositoryService repositoryService;

    @GetMapping("/{owner}/{repository-name}")
    public RepositoryDTO getRepositoryDetails(@PathVariable("owner") String owner, @PathVariable("repository-name") String repositoryName) {
        return repositoryService.getRepositoryDetails(owner, repositoryName);
    }
}
