package hello.post_crud.repository;
import hello.post_crud.domain.Post;

import java.util.List;

public interface PostRepository {

    List<Post> findAll();
    Post save(Post post);
}
