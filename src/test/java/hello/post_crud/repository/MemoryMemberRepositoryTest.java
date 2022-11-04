package hello.post_crud.repository;

import hello.post_crud.MemberServiceConfig;
import hello.post_crud.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemoryMemberRepositoryTest {
    @Test
    void join() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MemberServiceConfig.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        Member member = new Member();
        member.setName("jiheon");
        member.setId(1L);
        memberRepository.save(member);
    }
}