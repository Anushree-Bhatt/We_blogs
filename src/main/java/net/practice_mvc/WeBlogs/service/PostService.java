package net.practice_mvc.WeBlogs.service;

import jakarta.validation.Valid;
import net.practice_mvc.WeBlogs.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> retrieveAllPosts();
    Long addPost(PostDto postDto);
    PostDto retrievePost(Long id);
    void updatePost(PostDto postDto);
    void deletePost(Long id);
    PostDto retrievePostByUrl(String url);
}
