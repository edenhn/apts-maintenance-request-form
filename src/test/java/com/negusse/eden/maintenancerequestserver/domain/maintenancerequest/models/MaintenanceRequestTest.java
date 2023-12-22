package com.negusse.eden.maintenancerequestserver.domain.maintenancerequest.models;

import com.negusse.eden.maintenancerequestserver.domain.maintenanceRequest.models.MaintenanceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class MaintenanceRequestTest {

    @Test
    public void constructorTest01(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
        MaintenanceRequest maintenanceRequest = new MaintenanceRequest("Jane", "Doe", "jane@doe.com", "1", "Water leak", date);
        maintenanceRequest.setId(1L);

        String expected = "Water leak maintenance request for Jane Doe, email: jane@doe.com, apt 1. Created on: 2023-01-01.";
        String actual = maintenanceRequest.toString();

        Assertions.assertEquals(expected, actual);
    }
}
