package com.tabadul.Carpooling.dto.card;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDto {
    private Long id;

    private String title;

    private String description;

    private Long createdBy;

    private Long updatedBy;

    private Instant createdAt;

    private Instant updatedAt;

    private Long stackId;
}
