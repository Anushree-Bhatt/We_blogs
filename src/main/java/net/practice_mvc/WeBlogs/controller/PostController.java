package net.practice_mvc.WeBlogs.controller;

import net.practice_mvc.WeBlogs.dto.PostDto;
import net.practice_mvc.WeBlogs.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private PostService postService;
    Logger logger = LoggerFactory.getLogger(PostController.class);

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/admin/posts")
    public String getAllPosts(Model model){
        model.addAttribute("posts",postService.retrieveAllPosts());
        return "/admin/list_posts";
    }

    @GetMapping("/admin/posts/new")
    public String getPostForm(Model model){
        PostDto postDto = new PostDto();
        model.addAttribute("postDto",postDto);
        return "/admin/new_post";
    }

    @PostMapping("/admin/posts")
    public String createPost(@ModelAttribute PostDto postDto){
        postDto.setUrl(createUrl(postDto.getTitle()));
        Long id = postService.addPost(postDto);
        return "redirect:/admin/posts";
    }

    public String createUrl(String title){
        String res = title.toLowerCase();
        res = res.replaceAll("\\s+","-");
        res.replaceAll("[^A-Za-z0-9]","-");
        return res;
    }





}
