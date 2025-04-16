package com.example.repository_details.repository;

import com.example.repository_details.model.RepositoryEntity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryRepository extends JpaRepository<RepositoryEntity, Id> {

    Optional<RepositoryEntity> findByFullName(String fullName);

    boolean existsByFullName(String fullName);
}