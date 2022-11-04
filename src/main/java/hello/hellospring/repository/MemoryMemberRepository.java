package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   //시퀀스 값을 1개 올려줌
        store.put(member.getId(), member);  //store에 저장함
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //Null이 반환될 수 있기에 Optional.ofNullable로 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  //람다 사용, 루프
                .filter(member -> member.getName().equals(name))    //name이 파라미터로 넘어온 것과 같은지 확인
                .findAny(); //찾아지면 결과가 Optional로 반환, 없다면 Null 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 있는 values 즉 member 반환
    }

    public void clearStore() {
        store.clear();
    }
}
