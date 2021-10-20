package com.tabadul.todoapp.controller;

import com.tabadul.todoapp.dto.card.CardDto;
import com.tabadul.todoapp.dto.card.Create;
import com.tabadul.todoapp.dto.stack.CreateStackRequest;
import com.tabadul.todoapp.dto.stack.StackDto;
import com.tabadul.todoapp.security.CurrentUser;
import com.tabadul.todoapp.security.UserPrincipal;
import com.tabadul.todoapp.service.CardService;
import com.tabadul.todoapp.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/create/{stackId}")
    public CardDto createStack(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody Create create, @PathVariable Long stackId){
        return cardService.createCard(userPrincipal, create,stackId);
    }
}



