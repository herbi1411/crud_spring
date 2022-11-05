package hello.post_crud.service;

import hello.post_crud.domain.Post;
import hello.post_crud.dto.NewPostRequest;
import hello.post_crud.dto.PostsResponse;
import hello.post_crud.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Long addPost(NewPostRequest newPostRequest) {
        Post savedPost = createPost(newPostRequest);
        postRepository.save(savedPost);
        System.out.println("savedPost = " + savedPost);
        return savedPost.getId();
    }

    private Post createPost(NewPostRequest newPostRequest) {
        return Post.builder()
                .title(newPostRequest.getTitle())
                .content(newPostRequest.getContent())
                .build();
    }

    public PostsResponse findPosts() {
        List<Post> posts = postRepository.findAll();
        return PostsResponse.ofPostList(posts);
    }
}
