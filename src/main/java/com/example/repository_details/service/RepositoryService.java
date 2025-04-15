package com.example.repository_details.service;

import com.example.repository_details.client.GithubClient;
import com.example.repository_details.mapper.RepositoryMapper;
import com.example.repository_details.model.Repository;
import com.example.repository_details.model.RepositoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepositoryService {
    private final GithubClient githubClient;
    private final RepositoryMapper repositoryMapper;

    public RepositoryDTO getRepositoryDetails(String owner, String repositoryName) {
        Repository repositoryDetails = githubClient.getRepositoryDetails(owner, repositoryName);
        return repositoryMapper.toDTO(repositoryDetails);
    }
}
