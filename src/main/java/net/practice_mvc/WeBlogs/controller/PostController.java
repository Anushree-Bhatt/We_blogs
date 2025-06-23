package net.practice_mvc.WeBlogs.controller;

import jakarta.validation.Valid;
import net.practice_mvc.WeBlogs.dto.PostDto;
import net.practice_mvc.WeBlogs.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String createPost(@Valid @ModelAttribute PostDto postDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("postDto",postDto);
            return "/admin/new_post";
        }
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

    @GetMapping("/admin/posts/{id}/edit")
    public String getPostForm_edit(@PathVariable(name = "id") Long id, Model model){
        PostDto postDto = postService.retrievePost(id);
        model.addAttribute("postDto",postDto);
        return "/admin/edit_post";
    }

    @PostMapping("/admin/posts/edit")
    public String editPost(@Valid @ModelAttribute PostDto postDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("postDto",postDto);
            return "/admin/edit_post";
        }
        postService.updatePost(postDto);
        return "redirect:/admin/posts";
    }

    @GetMapping("/admin/posts/{id}/delete")
    public String getPostForm(@PathVariable(name = "id") Long id, Model model){
        postService.deletePost(id);
        return "redirect:/admin/posts";
    }


}
