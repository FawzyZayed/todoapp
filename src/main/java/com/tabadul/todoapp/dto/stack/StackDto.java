package com.tabadul.todoapp.dto.stack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StackDto {

    private Long id;

    private String title;

    private Long createdBy;

    private Long updatedBy;

    private Instant createdAt;

    private Instant updatedAt;

    private Long projectId;
}
