package com.tabadul.Carpooling.dto.project;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AllProjectsResponse {

    private Long id;

    private String name;

    private Long createdBy;
}
