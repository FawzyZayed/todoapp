package com.tabadul.Carpooling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ApiResponse {
    private Boolean success;
    private String message;
}
