package hello.post_crud.dto;

import hello.post_crud.domain.Post;
import lombok.Builder;
import lombok.Getter;


@Getter
public class PostElementResponse {

    private Long id;
    private String title;
    private String content;

//    private int viewCount = 0;
//    private int likeCount = 0;

//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime modifiedAt;


    @Builder
    private PostElementResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static PostElementResponse from (Post post) {
        return PostElementResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
