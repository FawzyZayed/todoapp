package com.tabadul.todoapp.dto.project;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Builder
@Data
public class AllProjectsResponse {

    private Long id;

    private String name;

    private Long createdBy;
}
