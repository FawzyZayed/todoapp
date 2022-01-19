package com.tabadul.Carpooling.dto.stack;

import com.tabadul.Carpooling.dto.card.CardListResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StackListResponse {

    private String title;
    private List<CardListResponse> cardList;
}
