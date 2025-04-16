package com.example.repository_details.controller;

import com.example.repository_details.model.RepositoryDTO;
import com.example.repository_details.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RepositoryController {
    private final RepositoryService repositoryService;

    @GetMapping("/repositories/{owner}/{repository-name}")
    public RepositoryDTO getRepositoryDetails(@PathVariable("owner") String owner, @PathVariable("repository-name") String repositoryName) {
        return repositoryService.getRepositoryDetails(owner, repositoryName);
    }

    @PostMapping("/repositories/{owner}/{repository-name}")
    public RepositoryDTO saveRepositoryDetailsToDB(@PathVariable("owner") String owner, @PathVariable("repository-name") String repositoryName) {
        return repositoryService.saveRepositoryDetailsToDB(owner, repositoryName);
    }

    @GetMapping("/local/repositories/{owner}/{repository-name}")
    public RepositoryDTO getLocalRepositoryDetails(@PathVariable("owner") String owner, @PathVariable("repository-name") String repositoryName) {
        return repositoryService.getLocalRepositoryDetails(owner, repositoryName);
    }
}