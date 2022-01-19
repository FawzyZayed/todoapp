package com.tabadul.Carpooling.dto.card;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Create {

    @NotBlank
    private String title;

    @NotBlank
    private String description;
}
