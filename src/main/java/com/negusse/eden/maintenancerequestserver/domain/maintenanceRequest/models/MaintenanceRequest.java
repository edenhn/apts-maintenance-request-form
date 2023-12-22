package com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String aptNumber;

    @NonNull
    private String description;

    @NonNull
    private Date createAt;

    public String toString() {
        return String.format("%s maintenance request for %s %s, email: %s, apt %s. Created on: %tF.", description, firstName, lastName, email, aptNumber, createAt);
    }

}
