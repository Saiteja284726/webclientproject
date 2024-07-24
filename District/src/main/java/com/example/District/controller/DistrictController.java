package com.example.District.controller;

import com.example.District.model.District;
import com.example.District.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Alldistricts") // Base mapping for the controller
public class DistrictController {

    private final DistrictService districtService;

    @Autowired
    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping("/savedistreit") // Using meaningful endpoint names
    public District saveDistrict(@RequestBody District district) {
        return districtService.addDistrict(district);
    }

    @PostMapping("/save-all")
    public List<District> saveAllDistricts(@RequestBody List<District> districts) {
        return districtService.saveDistricts(districts);
    }

    @GetMapping("/get-by-state/{stateId}") // Using hyphens for readability
    public List<District> getDistrictsByStateId(@PathVariable String stateId) {
        return districtService.getDistrictsByStateId(stateId);
    }

    @GetMapping("/get-all")
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }
}