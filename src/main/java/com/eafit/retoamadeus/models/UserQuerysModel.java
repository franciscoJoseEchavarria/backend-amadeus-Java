package com.eafit.retoamadeus.models;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class UserQuerysModel {

    private Long id;
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


