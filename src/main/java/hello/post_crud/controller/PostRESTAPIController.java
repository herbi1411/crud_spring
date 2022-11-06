package hello.post_crud.controller;

import hello.post_crud.domain.Post;
import hello.post_crud.dto.NewPostRequest;
import hello.post_crud.dto.PostElementResponse;
import hello.post_crud.dto.PostsResponse;
import hello.post_crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class PostRESTAPIController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<PostsResponse> findPosts() {
        PostsResponse postsResponse = postService.findPosts();
        return ResponseEntity.ok(postsResponse);
    }

    @PostMapping("/posts")
//    public ResponseEntity<PostElementResponse> addPost(@Valid @ModelAttribute NewPostRequest newPostRequest) { // postman
    public ResponseEntity<PostElementResponse> addPost(@Valid @RequestBody NewPostRequest newPostRequest) { //json
        PostElementResponse postElementResponse = postService.addPost(newPostRequest);
        return ResponseEntity.ok(postElementResponse);
    }
}
