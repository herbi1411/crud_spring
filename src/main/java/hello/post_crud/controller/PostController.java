package hello.post_crud.controller;


import hello.post_crud.domain.Post;
import hello.post_crud.dto.NewPostRequest;
import hello.post_crud.dto.PostElementResponse;
import hello.post_crud.dto.PostsResponse;
import hello.post_crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public String findPosts(Model model) {

        PostsResponse postsResponse = postService.findPosts();

        //객체 -> list로 바꾸기 위한 작업 (HTML 반환을 위해)
        List<PostElementResponse> postElementResponses = postsResponse.getPosts();
        model.addAttribute("posts", postElementResponses);
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String createForm() {
        return "posts/createPostForm";
    }

    @PostMapping("/posts/create")
    public String create(NewPostRequest newPostRequest) {
        postService.addPost(newPostRequest);
        return "redirect:/posts";
    }
}
