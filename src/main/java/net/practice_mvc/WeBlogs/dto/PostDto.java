package net.practice_mvc.WeBlogs.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;
    @NotEmpty(message = "Title should not be empty")
    private String title;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    @NotEmpty(message = "Short-description should not be empty")
    private String shortDescription;
    private String url;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
