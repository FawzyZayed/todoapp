package com.tabadul.todoapp.dto.project;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {

    private Long id;

    private String name;

    private Long createdBy;

    private Long updatedBy;

    private Instant createdAt;

    private Instant updatedAt;


}
