package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
//원래 밑에서 생성된 Assertions에 ALT+엔터를 사용해 add on 어쩌고 선택, 이후 바로 assertThat이라 사용 가능

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  //테스트가 실행되고 끝날 때마다 저장소를 지우게 됨, 지우지 않는다면 순서에 영향을 받아 오류가 날 수 있음
    public void afterEach() {
        repository.clearStore();
    }

    @Test   //아래 메서드를 실행할 수 있게 됨
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, result);  //기대값, 실제값 을 비교해준다, junit 기능
        assertThat(member).isEqualTo(result);    //member가 result와 같은지 확인, org.assert 기능
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  //shift+F6 사용하여 이름 한 번에 바꾸기 가능
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
