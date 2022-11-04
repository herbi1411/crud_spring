package hello.post_crud.repository;

import hello.post_crud.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    Member deleteOne(Member member);

    Member updateOne(Member member, String newName);
}
