package com.example.State.Controller;


import com.example.State.Service.StateService;
import com.example.State.dto.StateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/states")
    public class StateController {

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @PostMapping("/add")
    public StateDto addState(@RequestBody StateDto stateDTO) {
        return stateService.addstate(stateDTO);
    }

    @GetMapping("/all")
    public List<StateDto> getAllStates() {
        return StateService.getAllStates();
    }

    @GetMapping("/{id}")
    public StateDto getStateById(@PathVariable Long id) {
        return StateService.getStateById(id);
    }

    @GetMapping("/name/{name}")
    public StateDto getStateByName(@PathVariable String name) {
        return StateService.getStateByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteStateById(@PathVariable Long id) {
        StateService.deleteStateById(id);
    }
}

