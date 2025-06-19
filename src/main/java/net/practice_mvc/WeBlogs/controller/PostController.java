package net.practice_mvc.WeBlogs.controller;

import net.practice_mvc.WeBlogs.dto.PostDto;
import net.practice_mvc.WeBlogs.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/admin/posts")
    public String getAllPosts(Model model){
        model.addAttribute("posts",postService.retrieveAllPosts());
        return "/admin/list_posts";
    }





}
