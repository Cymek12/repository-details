package com.example.repository_details.client;

import com.example.repository_details.model.Repository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "GitHub", url = "https://api.github.com/repos")
public interface GithubClient {

    @GetMapping("/{owner}/{repo}")
    Repository getRepositoryDetails(@PathVariable("owner") String repoOwner, @PathVariable("repo") String repository);
}
