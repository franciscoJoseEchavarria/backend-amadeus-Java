package com.eafit.retoamadeus.contracts.responses;

import com.eafit.retoamadeus.models.User;
import com.eafit.retoamadeus.models.UserQuerysModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DestinosResponse {

    private Long id;
    private String destinoAmerica ;
    private String destinoEuropa ;


}
