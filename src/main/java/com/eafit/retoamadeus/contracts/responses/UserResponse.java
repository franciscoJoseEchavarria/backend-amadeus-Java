package com.eafit.retoamadeus.contracts.responses;
import com.eafit.retoamadeus.models.RoleUser;
import com.eafit.retoamadeus.models.UserQuerysModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private RoleUser role;

}