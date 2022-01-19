package com.tabadul.Carpooling.dto.auth;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 20)
    private String password;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    private String mobileNumber;
}