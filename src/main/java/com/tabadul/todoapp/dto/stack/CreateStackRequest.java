package com.tabadul.todoapp.dto.stack;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateStackRequest {

    @NotBlank
    private String Title;
}
