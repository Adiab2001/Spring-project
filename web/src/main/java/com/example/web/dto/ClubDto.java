package com.example.web.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotBlank(message = "Photo link should not be empty")
    private String photoUrl;
    @NotBlank(message = "Content should not be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
