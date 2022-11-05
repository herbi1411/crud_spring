package hello.post_crud.dto;

import hello.post_crud.domain.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponse {
    private final List<PostElementResponse> posts;

    public PostsResponse(List<PostElementResponse> posts) {
        this.posts = posts;
    }

    public static PostsResponse ofPostList(List<Post> postList) {
        List<PostElementResponse> postElementResponses = postList
                .stream()
                .map(PostElementResponse::from)
                .collect(Collectors.toList());
        return new PostsResponse(postElementResponses);
    }
}
