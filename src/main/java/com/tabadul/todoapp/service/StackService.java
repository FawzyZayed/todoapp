package com.tabadul.todoapp.service;

import com.tabadul.todoapp.dto.project.ProjectByIdResponse;
import com.tabadul.todoapp.dto.project.ProjectDto;
import com.tabadul.todoapp.dto.stack.CreateStackRequest;
import com.tabadul.todoapp.dto.stack.StackDto;
import com.tabadul.todoapp.dto.stack.StackListResponse;
import com.tabadul.todoapp.entity.Project;
import com.tabadul.todoapp.entity.Stack;
import com.tabadul.todoapp.entity.User;
import com.tabadul.todoapp.repository.ProjectRepository;
import com.tabadul.todoapp.repository.StackRepository;
import com.tabadul.todoapp.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StackService {


    private final StackRepository stackRepository;
    private final ProjectRepository projectRepository;

    public StackDto createStack(UserPrincipal userPrincipal, CreateStackRequest createStackRequest, Long projectId){
        User user = new User(userPrincipal.getId(), userPrincipal.getName(), userPrincipal.getUsername(), userPrincipal.getEmail());

        Project project = projectRepository.findByIdAndCreatedByOrEditors(projectId, user.getId(), user)
                .orElseThrow(() -> new RuntimeException("You don't have permission"));

        Stack stack = new Stack();
        stack.setText(createStackRequest.getTitle());
        stack.setProject(project);

        stackRepository.save(stack);

        return StackDto.builder()
                .id(stack.getId())
                .title(stack.getText())
                .createdBy(stack.getCreatedBy())
                .updatedBy(stack.getUpdatedBy())
                .createdAt(stack.getCreatedAt())
                .updatedAt(stack.getUpdatedAt())
                .projectId(stack.getProject().getId())
                .build();
    }

}