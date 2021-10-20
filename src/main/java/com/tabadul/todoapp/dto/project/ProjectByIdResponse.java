package com.tabadul.todoapp.dto.project;

import com.tabadul.todoapp.dto.stack.StackDto;
import com.tabadul.todoapp.dto.stack.StackListResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProjectByIdResponse {

    private Long id;
    private String title;
    List<StackListResponse> stackList;
}
