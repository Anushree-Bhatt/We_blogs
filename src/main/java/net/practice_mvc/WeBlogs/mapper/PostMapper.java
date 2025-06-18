package net.practice_mvc.WeBlogs.mapper;

import net.practice_mvc.WeBlogs.dto.PostDto;
import net.practice_mvc.WeBlogs.entity.Post;

public class PostMapper {

    public static PostDto mapToPostDto(Post post){
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .url(post.getUrl())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();
        return postDto;
    }

    public static Post mapToPost(PostDto postDto){
        Post post = Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .shortDescription(postDto.getShortDescription())
                .url(postDto.getUrl())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();
        return post;
    }
}
