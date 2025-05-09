package com.example.repository_details.controller;

import com.example.repository_details.exception.RepositoryAlreadyExistsException;
import com.example.repository_details.exception.RepositoryNotFoundException;
import com.example.repository_details.model.RepositoryDTO;
import com.example.repository_details.service.RepositoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static com.example.repository_details.TestDataBuilder.buildRepositoryDTO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RepositoryControllerTest {
    @MockitoBean
    private RepositoryService repositoryService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRepositoryDetails_returnRepositoryDTO() throws Exception {
        String owner = "barchart";
        String repositoryName = "marketdata-api-js";
        RepositoryDTO repositoryDTO = buildRepositoryDTO();
        when(repositoryService.getRepositoryDetails(owner, repositoryName)).thenReturn(repositoryDTO);
        mockMvc.perform(get("/repositories/{owner}/{repository-name}", owner, repositoryName)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("barchart/marketdata-api-js"))
                .andExpect(jsonPath("$.description").value("JavaScript SDK for accessing streaming market data via WebSockets"))
                .andExpect(jsonPath("$.cloneUrl").value("https://github.com/barchart/marketdata-api-js.git"))
                .andExpect(jsonPath("$.watchersNumber").value("25"))
                .andExpect(jsonPath("$.createdAt").value("2015-02-24T20:37:32"));
    }

    @Test
    void saveRepositoryDetailsToDB_returnRepositoryDTO() throws Exception {
        String owner = "barchart";
        String repositoryName = "marketdata-api-js";
        RepositoryDTO repositoryDTO = buildRepositoryDTO();
        when(repositoryService.saveRepositoryDetailsToDB(owner, repositoryName)).thenReturn(repositoryDTO);
        mockMvc.perform(post("/repositories/{owner}/{repository-name}", owner, repositoryName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("barchart/marketdata-api-js"))
                .andExpect(jsonPath("$.description").value("JavaScript SDK for accessing streaming market data via WebSockets"))
                .andExpect(jsonPath("$.cloneUrl").value("https://github.com/barchart/marketdata-api-js.git"))
                .andExpect(jsonPath("$.watchersNumber").value("25"))
                .andExpect(jsonPath("$.createdAt").value("2015-02-24T20:37:32"));
    }

    @Test
    void saveRepositoryDetailsToDB_returnErrorMessage() throws Exception {
        String owner = "barchart";
        String repositoryName = "marketdata-api-js";
        when(repositoryService.getRepositoryDetails(owner, repositoryName)).thenThrow(new RepositoryAlreadyExistsException("Repository already exists"));
        mockMvc.perform(get("/repositories/{owner}/{repository-name}", owner, repositoryName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad request"))
                .andExpect(jsonPath("$.message").value("Repository already exists"));
    }

    @Test
    void getLocalRepositoryDetails_returnRepositoryDTO() throws Exception {
        String owner = "barchart";
        String repositoryName = "marketdata-api-js";
        RepositoryDTO repositoryDTO = buildRepositoryDTO();
        when(repositoryService.getLocalRepositoryDetails(owner, repositoryName)).thenReturn(repositoryDTO);
        mockMvc.perform(get("/local/repositories/{owner}/{repository-name}", owner, repositoryName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("barchart/marketdata-api-js"))
                .andExpect(jsonPath("$.description").value("JavaScript SDK for accessing streaming market data via WebSockets"))
                .andExpect(jsonPath("$.cloneUrl").value("https://github.com/barchart/marketdata-api-js.git"))
                .andExpect(jsonPath("$.watchersNumber").value("25"))
                .andExpect(jsonPath("$.createdAt").value("2015-02-24T20:37:32"));
    }

    @Test
    void getLocalRepositoryDetails_returnErrorMessage() throws Exception {
        String owner = "barchart";
        String repositoryName = "marketdata-api-js";
        when(repositoryService.getLocalRepositoryDetails(owner, repositoryName)).thenThrow(new RepositoryNotFoundException("Repository not found"));
        mockMvc.perform(get("/local/repositories/{owner}/{repository-name}", owner, repositoryName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not found"))
                .andExpect(jsonPath("$.message").value("Repository not found"));
    }
}