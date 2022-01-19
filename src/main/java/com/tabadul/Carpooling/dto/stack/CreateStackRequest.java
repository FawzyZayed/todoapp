package com.tabadul.Carpooling.dto.stack;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateStackRequest {

    @NotBlank
    private String Title;
}
