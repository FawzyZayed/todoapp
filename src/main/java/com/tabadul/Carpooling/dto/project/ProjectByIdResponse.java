package com.tabadul.Carpooling.dto.project;

import com.tabadul.Carpooling.dto.stack.StackListResponse;
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
