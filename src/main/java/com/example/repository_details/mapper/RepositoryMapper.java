package com.example.repository_details.mapper;

import com.example.repository_details.model.Repository;
import com.example.repository_details.model.RepositoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {

    RepositoryDTO toDTO(Repository repository);
}
