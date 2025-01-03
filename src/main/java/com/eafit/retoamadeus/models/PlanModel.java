package com.eafit.retoamadeus.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanModel {
    private Long id;
    private String name;
    private String description;
    private String destinationName;
    private String imageUrl;
}