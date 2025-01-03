package com.eafit.retoamadeus.contracts.request;

import com.eafit.retoamadeus.models.RoleUser;
import com.eafit.retoamadeus.models.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class UserQueryRequest {
    // no se nceesita -  private Long id;
    private String query;
    private String queryTime;
    private String environmentType1;
    private String climateType2;
    private String accommodationType3;
    private String activityType4;
    private String stayDuration;
    private String ageRange;
    private User user;

}



