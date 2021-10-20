package com.tabadul.todoapp.controller;

import com.tabadul.todoapp.dto.project.AllProjectsResponse;
import com.tabadul.todoapp.dto.project.CreateProjectRequest;
import com.tabadul.todoapp.dto.project.ProjectByIdResponse;
import com.tabadul.todoapp.dto.project.ProjectDto;
import com.tabadul.todoapp.entity.Project;
import com.tabadul.todoapp.security.CurrentUser;
import com.tabadul.todoapp.security.UserPrincipal;
import com.tabadul.todoapp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/all")
    public Page<AllProjectsResponse> getAllProjectByUserOrEditor(@CurrentUser UserPrincipal userPrincipal, Pageable pageable){
        return projectService.findAllByUserOrEditor(userPrincipal, pageable);
    }

    @PostMapping("/create")
    public Project createProject(@Valid @RequestBody CreateProjectRequest createProjectRequest){
        return projectService.createProject(createProjectRequest);
    }
    @GetMapping("/{id}")
    public ProjectByIdResponse getProjectById(@PathVariable Long id ){
        return projectService.getProjectById(id);
    }
}
