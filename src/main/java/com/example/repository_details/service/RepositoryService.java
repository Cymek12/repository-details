package com.example.repository_details.service;

import com.example.repository_details.client.GithubClient;
import com.example.repository_details.exception.RepositoryAlreadyExistsException;
import com.example.repository_details.exception.RepositoryNotFoundException;
import com.example.repository_details.mapper.RepositoryMapper;
import com.example.repository_details.model.Repository;
import com.example.repository_details.model.RepositoryDTO;
import com.example.repository_details.model.RepositoryEntity;
import com.example.repository_details.repository.RepositoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepositoryService {
    private final GithubClient githubClient;
    private final RepositoryMapper repositoryMapper;
    private final RepositoryRepository repositoryRepository;

    public RepositoryDTO getRepositoryDetails(String owner, String repositoryName) {
        Repository repositoryDetails = githubClient.getRepositoryDetails(owner, repositoryName);
        return repositoryMapper.toDTO(repositoryDetails);
    }

    public RepositoryDTO saveRepositoryDetailsToDB(String owner, String repositoryName) {
        String fullName = createFullName(owner, repositoryName);
        if (repositoryRepository.existsByFullName(fullName)) {
            throw new RepositoryAlreadyExistsException("Repository named: " + fullName + " already exists");
        }
        Repository repositoryDetails = githubClient.getRepositoryDetails(owner, repositoryName);
        RepositoryEntity savedRepository = repositoryRepository.save(repositoryMapper.toEntity(repositoryDetails));
        return repositoryMapper.toDTO(savedRepository);
    }

    public RepositoryDTO getLocalRepositoryDetails(String owner, String repositoryName) {
        String fullName = createFullName(owner, repositoryName);
        return repositoryMapper.toDTO(repositoryRepository.findByFullName(fullName)
                .orElseThrow(() -> new RepositoryNotFoundException("Repository named: " + fullName + " does not exists")));
    }

    private String createFullName(String owner, String repositoryName) {
        return owner + "/" + repositoryName;
    }
}