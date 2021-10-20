package com.tabadul.todoapp.service;

import com.tabadul.todoapp.dto.card.CardListResponse;
import com.tabadul.todoapp.dto.project.AllProjectsResponse;
import com.tabadul.todoapp.dto.project.CreateProjectRequest;
import com.tabadul.todoapp.dto.project.ProjectByIdResponse;
import com.tabadul.todoapp.dto.project.ProjectDto;
import com.tabadul.todoapp.dto.stack.StackListResponse;
import com.tabadul.todoapp.entity.Project;
import com.tabadul.todoapp.entity.Stack;
import com.tabadul.todoapp.entity.User;
import com.tabadul.todoapp.repository.ProjectRepository;
import com.tabadul.todoapp.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository ;

    public Page<AllProjectsResponse> findAllByUserOrEditor(UserPrincipal userPrincipal, Pageable pageable){
        User user = new User();
        user.setId(userPrincipal.getId());

        Page<Project> page = projectRepository.findAllByCreatedByOrEditors(userPrincipal.getId(), user, pageable);
        List<AllProjectsResponse> allProjectsResponses = page.getContent().stream()
                .map(p ->
                    AllProjectsResponse.builder()
                                    .id(p.getId())
                                    .name(p.getName())
                                    .createdBy(p.getCreatedBy())
                                    .build()
                )
                .toList();

        return new PageImpl<>(
                allProjectsResponses,
                pageable,
                page.getTotalElements()
        );
    }

    public Project createProject(CreateProjectRequest createProjectRequest){
        Project project = new Project();
        project.setName(createProjectRequest.getName());
        return projectRepository.save(project);
    }

//    public ProjectDto getProjectById(Long Id){
//        Project project = projectRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("No Project Found"));
//        return ProjectDto.builder()
//                .id(project.getId())
//                .name(project.getName())
//                .createdBy(project.getCreatedBy())
//                .updatedBy(project.getUpdatedBy())
//                .createdAt(project.getCreatedAt())
//                .updatedAt(project.getUpdatedAt())
//                .build();
//            }

    // Show All List
    public ProjectByIdResponse getProjectById(Long id) {
        //get project by id
        Project project = projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Project was not found"));

        List<StackListResponse> stackListResponse = project.getStacks().stream()
                .map(s -> {
                    List<CardListResponse> cardListResponse = s.getCards().stream()
                            .map(c ->
                                    CardListResponse.builder()
                                            .id(c.getId())
                                            .title(c.getTitle()).build()

                            )
                            .collect(Collectors.toList());

                    return StackListResponse.builder()
                            .title(s.getText())
                            .cardList(cardListResponse)
                            .build();
                }).collect(Collectors.toList());

        return ProjectByIdResponse.builder().id(project.getId()).title(project.getName()).stackList(stackListResponse).build();
        //
//        Stack stack = new Stack();
//        return StackListResponse.builder()
//                .title(stack.getText())
//                .cardList(stack.getCards())
//                .build();
    }
//    ProjectDto formProjectDtoObject(Project project){
//        ProjectDto projectDto = new ProjectDto();
//        projectDto.setId(project.getId());
//        projectDto.setName(project.getName());
//        projectDto.setCreatedBy(project.getCreatedBy());
//        projectDto.setUpdatedBy(project.getUpdatedBy());
//        projectDto.setCreatedAt(project.getCreatedAt());
//        projectDto.setUpdatedAt(project.getUpdatedAt());
//        return projectDto;
//    }
}
