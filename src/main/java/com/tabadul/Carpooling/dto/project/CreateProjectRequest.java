package com.tabadul.Carpooling.dto.project;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateProjectRequest {
    @NotBlank
    private String name;
}
