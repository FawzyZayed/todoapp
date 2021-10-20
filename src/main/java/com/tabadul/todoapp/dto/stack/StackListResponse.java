package com.tabadul.todoapp.dto.stack;

import com.tabadul.todoapp.dto.card.CardListResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StackListResponse {

    private String title;
    private List<CardListResponse> cardList;
}
