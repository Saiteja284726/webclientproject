package com.example.State.Service;

import com.example.State.Repository.StateRepository;
import com.example.State.dto.StateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class StateService {

    private static WebClient webClient = null;

    @Autowired
    public StateService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/api/districts").build();
    }

    public Object StateDto(StateDto stateDTO) {
        return webClient.post()
                .uri("/add")
                .bodyValue(stateDTO)
                .retrieve()
                .bodyToMono(StateDto.class)
                .block();
    }

    public static List<StateDto> getAllStates() {
        return webClient.get()
                .uri("/all")
                .retrieve()
                .bodyToFlux(StateDto.class)
                .collectList()
                .block();
    }

    public static StateDto getStateById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(StateDto.class)
                .block();
    }

    public static StateDto getStateByName(String name) {
        return webClient.get()
                .uri("/name/{name}", name)
                .retrieve()
                .bodyToMono(StateDto.class)
                .block();
    }

    public static void deleteStateById(Long id) {
        webClient.delete()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public StateDto addstate(StateDto stateDTO) {
        return null;
    }
}