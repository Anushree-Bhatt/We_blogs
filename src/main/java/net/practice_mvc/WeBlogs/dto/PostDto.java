package net.practice_mvc.WeBlogs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String shortDescription;
    private String url;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
