package hello.post_crud.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="post_id")
    @Getter
    private Long id;

    @Embedded
    private Title title;
    @Embedded
    private Content content;

//    private int viewCount = 0;
//    private int likeCount = 0;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    protected Post() {

    }

    @Builder
    private Post(String title, String content) {
        this.title = new Title(title);
        this.content = new Content(content);
    }

    public String getTitle() {
        return title.getValue();
    }

    public String getContent() {
        return content.getValue();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title=" + title +
                ", content=" + content +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
