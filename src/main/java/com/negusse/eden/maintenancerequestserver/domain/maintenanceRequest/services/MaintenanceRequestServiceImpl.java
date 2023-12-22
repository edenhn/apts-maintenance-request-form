package com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.services;


import com.negusse.eden.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.negusse.eden.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.repos.MaintenanceRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
    private MaintenanceRequestRepo maintenanceRequestRepo;

    @Autowired
    public MaintenanceRequestServiceImpl(MaintenanceRequestRepo maintenanceRequestRepo) {
        this.maintenanceRequestRepo = maintenanceRequestRepo;
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException {
        Optional<MaintenanceRequest> optional = maintenanceRequestRepo.findByEmail(maintenanceRequest.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Maintenance Request with email exists:" + maintenanceRequest.getEmail());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getById(Long id) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No maintenance request with id:" + id));
        return maintenanceRequest;
    }

    @Override
    public MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = maintenanceRequestRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No maintenance request with email:" + email));
        return maintenanceRequest;
    }

    @Override
    public List<MaintenanceRequest> getAll() {
        return maintenanceRequestRepo.findAll();
    }

    @Override
    public MaintenanceRequest update(Long id, MaintenanceRequest requestDetail) throws ResourceNotFoundException {
        MaintenanceRequest maintenanceRequest = getById(id);
        maintenanceRequest.setFirstName(requestDetail.getFirstName());
        maintenanceRequest.setLastName(requestDetail.getLastName());
        maintenanceRequest.setEmail(requestDetail.getEmail());
        maintenanceRequest.setAptNumber(requestDetail.getAptNumber());
        maintenanceRequest.setDescription(requestDetail.getDescription());
        maintenanceRequest.setCreateAt(requestDetail.getCreateAt());
        maintenanceRequest = maintenanceRequestRepo.save(maintenanceRequest);
        return maintenanceRequest;
    }

    @Override
    public void delete(Long id) {
        //retrieve with specific id
        //check first if a mr with this specific {id} exists
        MaintenanceRequest maintenanceRequest = getById(id);
        //call getById() to check for existing mr
        //if mr with {id} exists execute delete()
        maintenanceRequestRepo.delete(maintenanceRequest);
    }
}
