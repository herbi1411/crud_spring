package hello.post_crud.repository;

import hello.post_crud.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPostRepository extends PostRepository, JpaRepository<Post, Long> {

    List<Post> findAll();
    Post save(Post post);
}
