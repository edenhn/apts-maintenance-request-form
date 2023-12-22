package com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.services;

import com.negusse.eden.maintenancerequestserver.domain.core.exceptions.ResourceCreationException;
import com.negusse.eden.maintenancerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.sun.tools.javac.Main;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MaintenanceRequestService {

    MaintenanceRequest create(MaintenanceRequest maintenanceRequest) throws ResourceCreationException;
    MaintenanceRequest getById(Long id) throws ResourceNotFoundException;
    MaintenanceRequest getByEmail(String email) throws ResourceNotFoundException;
    List<MaintenanceRequest> getAll();
    MaintenanceRequest update(Long id, MaintenanceRequest requestDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
