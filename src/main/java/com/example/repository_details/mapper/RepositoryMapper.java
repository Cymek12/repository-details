package com.example.repository_details.mapper;

import com.example.repository_details.model.Repository;
import com.example.repository_details.model.RepositoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {

    @Mapping(source = "full_name", target = "fullName")
    @Mapping(source = "clone_url", target = "cloneUrl")
    @Mapping(source = "watchers_count", target = "watchersNumber")
    @Mapping(source = "created_at", target = "createdAt")
    RepositoryDTO toDTO(Repository repository);
}
