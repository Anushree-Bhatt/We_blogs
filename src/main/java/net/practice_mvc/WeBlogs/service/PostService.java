package net.practice_mvc.WeBlogs.service;

import net.practice_mvc.WeBlogs.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> retrieveAllPosts();
    Long addPost(PostDto postDto);
}
