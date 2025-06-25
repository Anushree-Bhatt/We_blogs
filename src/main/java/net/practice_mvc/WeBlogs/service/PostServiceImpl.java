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

    @Override
    public PostDto retrievePost(Long id) {
        Post post = postRepository.findById(id).orElseGet(() -> {throw new RuntimeException("id not found!");});
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public void updatePost(PostDto postDto) {
        Post post = postRepository.findById(postDto.getId()).orElseGet(() -> {throw new RuntimeException("id not found!");});
        postRepository.save(PostMapper.mapToPost(postDto));
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseGet(() -> {throw new RuntimeException("id not found!");});
        postRepository.deleteById(id);
    }

    @Override
    public PostDto retrievePostByUrl(String url) {
        Post post = postRepository.findByUrl(url).orElseGet(() -> {throw new RuntimeException("id not found!");});
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public List<PostDto> searchPosts(String searchExp) {
        List<Post> posts = postRepository.searchPosts(searchExp).orElseGet(() -> {throw new RuntimeException("id not found!");});
        List<PostDto> postDtos = posts.stream().map(post -> PostMapper.mapToPostDto(post)).collect(Collectors.toList());
        return postDtos;
    }
}
