package com.tabadul.Carpooling.dto.card;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CardListResponse {

    private Long id;
    private String title;
}
