package com.tabadul.todoapp.service;

import com.tabadul.todoapp.dto.card.CardDto;
import com.tabadul.todoapp.dto.card.Create;
import com.tabadul.todoapp.entity.Card;
import com.tabadul.todoapp.entity.Project;
import com.tabadul.todoapp.entity.Stack;
import com.tabadul.todoapp.entity.User;
import com.tabadul.todoapp.repository.CardRepository;
import com.tabadul.todoapp.repository.ProjectRepository;
import com.tabadul.todoapp.repository.StackRepository;
import com.tabadul.todoapp.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final StackRepository stackRepository;

    public CardDto createCard(UserPrincipal userPrincipal, Create create,Long stackId){
        User user = new User(userPrincipal.getId(), userPrincipal.getName(), userPrincipal.getUsername(), userPrincipal.getEmail());

        Stack stack = stackRepository.getById(stackId);

        Card card = new Card();
        card.setTitle(create.getTitle());
        card.setDescription(create.getDescription());
        card.setStack(stack);

        cardRepository.save(card);

        return CardDto.builder()
                .id(card.getId())
                .title(card.getTitle())
                .createdBy(card.getCreatedBy())
                .updatedBy(card.getUpdatedBy())
                .createdAt(card.getCreatedAt())
                .updatedAt(card.getUpdatedAt())
                .stackId(card.getStack().getId())
                .build();
    }
}
