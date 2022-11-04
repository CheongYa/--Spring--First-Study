package hello.hellospring.domain;

public class Member {

    private Long id;    //데이터 구분을 위해 시스템이 저장하는 id
    private String name;

    //Getter and Setter 사용
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
