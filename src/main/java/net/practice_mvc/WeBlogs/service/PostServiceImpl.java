package net.practice_mvc.WeBlogs.service;

import net.practice_mvc.WeBlogs.dto.PostDto;
import net.practice_mvc.WeBlogs.entity.Post;
import net.practice_mvc.WeBlogs.mapper.PostMapper;
import net.practice_mvc.WeBlogs.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDto> retrieveAllPosts() {
        List<PostDto> postDtos = postRepository.findAll().stream().map(post -> PostMapper.mapToPostDto(post)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public Long addPost(PostDto postDto) {
        Post post = PostMapper.mapToPost(postDto);
        Post res = postRepository.save(post);
        return res.getId();
    }
}
