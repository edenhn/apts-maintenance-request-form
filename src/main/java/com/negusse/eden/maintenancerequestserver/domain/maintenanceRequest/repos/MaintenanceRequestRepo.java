package com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.repos;

import com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import com.sun.tools.javac.Main;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MaintenanceRequestRepo extends JpaRepository<MaintenanceRequest, Long> {
    Optional<MaintenanceRequest> findByEmail(String email);
}
