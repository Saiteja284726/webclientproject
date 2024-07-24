package com.example.District.service;

import com.example.District.model.District;
import com.example.District.repo.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    private final DistrictRepo districtRepo;

    @Autowired
    public DistrictService(DistrictRepo districtRepo) {
        this.districtRepo = districtRepo;
    }

    public District addDistrict(District district) {
        return districtRepo.save(district);
    }

    public List<District> saveDistricts(List<District> districts) {
        return districtRepo.saveAll(districts);
    }

    public District getDistrictById(Long id) {
        Optional<District> districtOptional = districtRepo.findById(id);
        return districtOptional.orElse(null); // Handle if district is not found
    }

    public List<District> getAllDistricts() {
        return districtRepo.findAll();
    }

    public List<District> getDistrictsByStateId(String stateId) {
        return districtRepo.findByStateId(stateId); // Replace with actual method from DistrictRepo
    }
}