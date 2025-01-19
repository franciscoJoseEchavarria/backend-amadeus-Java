package com.eafit.retoamadeus.models;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class DestinosModel {

    private Long id;
    private String destinoAmerica;
    private String destinoEuropa;
    private User user;
    private UserQuerysModel userQuerysModel;

}
