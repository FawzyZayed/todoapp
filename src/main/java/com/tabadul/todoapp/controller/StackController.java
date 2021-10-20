package com.tabadul.todoapp.controller;

import com.tabadul.todoapp.dto.stack.CreateStackRequest;
import com.tabadul.todoapp.dto.stack.StackDto;
import com.tabadul.todoapp.entity.Stack;
import com.tabadul.todoapp.security.CurrentUser;
import com.tabadul.todoapp.security.UserPrincipal;
import com.tabadul.todoapp.service.StackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/stacks")
@RequiredArgsConstructor
public class StackController {
    private final StackService stackService;

    @PostMapping("/create/{projectId}")
    public StackDto createStack(@CurrentUser UserPrincipal userPrincipal, @Valid @RequestBody CreateStackRequest createStackRequest, @PathVariable Long projectId){
        return stackService.createStack(userPrincipal, createStackRequest,projectId);
    }

}


