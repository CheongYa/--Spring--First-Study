스프링 입문
===========
김영한 개발자 님의 강의를 토대로 만든 것 입니다.
* Link : [Inflearn](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard "Inflearn link")

# Part 0. 강의 소개
프로젝트 사용 기술
* Spring Boot
* Gradle
* Thymeleaf
* JPA(Java Persistence API)
* HIBERNATE

사용 환경
* Java 11
* IntelliJ IDE
* H2 1.4.200

# Part1. 프로젝트 환경설정
## Sec1. 프로젝트 생성
* [Spring Web](https://start.spring.io "스프링 사이트") 접속
* 프로젝트 선택 > Gradle + Java + 2.7.4 (뒤에 괄호 달린 것 X), Packaging: jar, Java11
* Project Metadata > groupld : hello, artifactld : hello-spring
* Dependencies > Spring Web, Thymeleaf
* GENERATE > 다운로드 완료 후 압축 풀기 (hello-spring 파일이 생긴다.)
* Intellij를 이용하여 build.gradle 열기
  - build.gradle이란, 버전 설정과 라이브러리를 가져와 주는 것.
* main - java - hello - hellospring - HelloSpringApplication에 들어가 main 메소드 실행
* Run에 Tomcat started on port(s): 8080 어쩌구가 뜨는걸 확인 후   
  웹 브라우저에 localhost:8080 주소칸에 입력
  - 에러 페이지가 뜬다면 성공, 사이트에 연결이 불가능하다고 나온다면 실패
- - -
## Sec2. 라이브러리 살펴보기
build.gradle에 작성한 것들은 얼마 되지 않지만, 의존관계가 있는 라이브러리를 함께 다운로드 한다.   
그렇기 때문에 External Libraries를 열어서 봐보면 엄청난 양의 라이브러리가 나타난다.
- - -
## Sec3. View 환경설정
### Welcome Page 만들기
* src - main - resources - static에 index.html 파일 생성 후 코드 작성
* 결과로 Hello hello가 출력된다면 성공

Spring에 대해 찾고 싶은게 있다면 https://spring.io >  Projects > Spring Boot > LEARN >  
Reference Doc. 에서 다양한 내용을 찾을 수 있다.  
이제는 동작하고 프로그래밍 되는 화면을 만들어보겠다.   
hello.hellospring 패키지 안에 controller 패키지를 생성 후 HelloController 클래스를 생성한다.  
이후 resource > templates 디렉토리 안에 hello.html 파일을 생성 후 코드들을 작성한다.  
껏다가 다시 실행 후 웹 브라우저에 localhost:8080/hello를 주소창에 입력하면 "안녕하세요. hello!!"가 화면에 출력된다.  
**동작 방식**
* 위 주소 입력 ➡ 내장 톰켓 서버 ➡ helloController ➡ return: hello, model(data:hello!!)  
  ➡ viewResolver(templates에 존재하는 hello.html을 기본적으로 찾음) ➡
* Thymeleaf 템플릿 엔진 처리 ➡ hello.html 변환 ➡ 웹 브라우저  
  **resources: hemplates/ + {ViewName} + .heml**

**꿀팁**  
**spring-boot-devtools** 라이브러리를 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이  
View 파일 변경이 가능하다.
- - -
## Sec4. 빌드하고 실행하기
1. 명령 프롬프트(cmd) 실행
2. hello-spring 파일까지 진입
3. gradlew clean build 작성 후 엔터(실행) ➡ build 폴더 생성 ➡ build 폴더 진입
4. dir 작성 후 엔터 ➡ 폴더들 보여줌 ➡ libs 진입
5. java -jar hello-spring-0.0.1-SNAPSHOT.jar 작성 후 엔터 ➡ 실행확인
- - -
# Part2. 스프링 웹 개발 기초
## Sec1. 정적 컨텐츠
정적 컨텐츠란? 파일을 그대로 웹 브라우저에 전달해주는 형태의 개발 방식!  
파일을 그냥 내려준다.
* src - main - resources - static 폴더에 hello-static.html 파일 생성 후 작성
* 실행 후 웹 브라우저에 http://localhost:8080/hello-static.html 작성 후 결과 확인
* 위 주소 입력 ➡ 내장 톰켓 서버 ➡ 스프링 컨테이너의 컨트롤러에서 hello-static이 관련된 것이  
있는지 확인 ➡ 컨트롤러에 맵핑이 된 것이 없다면 resources에 있는 hello-static을 찾음  
➡ 웹 브라우저에 반환
* - - -
## Sec2. MVC와 템플릿 엔진
MVC: Model, View, Controller  
보통 Controller(서버 뒷단에 관련된 것)와 View(화면에 관련된 것)를 쪼개는게 기본  
저장은 Model에 되며 그것을 꺼내서 사용하는 방식!
* controller에 있는 HelloController 자바 클래스에 맵핑 할 내용 추가
* templates 폴더에 hello-template.html 파일 생성 후 내용 추가
* 실행 후 웹 브라우저에 http://localhost:8080/hello-mvc?name=spring 작성 후 결과 확인
* 결과로 hello spring 이 출력된다면 성공. name=spring!!!으로 바꿔서 작성할 경우  
hello spring!!!이 출력이 됨
* localhost:8080/hello-mvc 입력 ➡ 내장 톰켓 서버 ➡ 스프링 컨테이너의 helloController ➡  
return: hello-template, model(name:spring) ➡ viewResolver가 templates/hello-template.html을  
찾아서 Thymeleaf에게 넘김 ➡ HTML로 변환 후 웹 브라우저에 넘김
- - -
## Sec3. API
HttpMessageConverter를 이용해서 Json이나 StringConverter로 바꿔 반환한다.
- - -
# Part3. 회원 관리 예제 - 백엔드 개발
## Sec1. 비즈니스 요구사항 정리
* 데이터: 회원 ID, 이름
* 기능: 회원 등록, 조회
* 아직 데이터 저장소가 선정되지 않음(가상의 시나리오)

**<일반적인 웹 애플리케이션 계층 구조>**  
컨트롤러 ➡ 서비스 ➡ 리포지토리 ➡ DB  
  ↘    ↓     ↙  
       도메인  
* 컨트롤러: 웹 MVC의 컨트롤러 역할
* 서비스: 핵심 비즈니스 로직 구현
* 리포지토리: 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
* 도메인: 비즈니스 도메인 객체, ex)회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨

**<클래스 의존관계>**  
MemberService ➡(interface)MemberRepository ⬅ MemoryMemberRepository
* 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계
* 데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정
* 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용
- - -
## Sec2. 회원 도메인과 리포지토리 만들기
1. hello.hellospring 패키지에 domain 패키지를 생성
2. Member 클래스 생성 후 내용 작성
3. hello.hellospring 패키지에 repository 패키지를 생성
4. repository에 MemberRepository 인터페이스 생성 후 내용 작성
5. repository에 MemoryMemberRepository 클래스 생성 후 내용 작성
- - -
## Sec3. 회원 피로지토리 테스트 케이스 작성
**테스트 케이스를 사용하는 이유**  
개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이션의
컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기
어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프레임워크로 테스트를
실행해서 이러한 문제를 해결한다.
1. test 폴더에 존재하는 hello.hellospring 패키지에 repository 패키지를 생성
2. MemoryMemberRepositoryTest 클래스 생성 후 내용 작성
3. AfterEach를 사용하기 위해 MemoryMemberRepository에 clearStore() 메서드 추가
- - -
## Sec4. 회원 서비스 개발
회원 리포지토리와 도메인을 사용하여 실제 비즈니스 로직을 작성하는 것.
1. main에 service 패키지를 생성
2. MemberService 클래스 생성 후 내용 작성
- - -
## Sec5. 회원 서비스 테스트
1. MemberService 클래스에서 CTRL + SHIFT + T 를 눌러 자동으로 test 코드 껍데기 구현
2. 테스트 코드 작성
3. 작성하며 MemberService 코드 수정
- - -
# Part4. 스프링 빈과 의존관계
## Sec1. 컴포넌트 스캔과 자동 의존관계 설정
1. main의 controller 패키지에 MemberController 클래스 생성 후 내용 작성
   * 생성자에 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌. DI(Dependency Injection) 즉, 의존성 주입이라고 함.
2. 실행 시 memberService가 스프링 빈으로 등록되지 않았기에 오류 발생
3. 컴포넌트 스캔과 자동 의존관계 설정 혹은 자바 코드로 직접 스프링 빈 등록가능
4. MemberService에 @Service와 @Autowired 작성. 만일 생성자가 1개만 있으면 @Autowired는 생략 가능.
5. 회원 리포지토리에 @Repository를 작성하여 스프링 빈 등록
6. memberService와 memberRespository가 스프링 컨테이너에 스프링 빈으로 등록됨
* 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록
(유일하게 하나만 등록해서 공유)따라서 같은 스프링 빈이면 모두 같은 인스턴스다. 
설정으로 싱글톤이 아니게 설정이 가능하지만 특별한 경우를 제외하면 대부분 싱글톤을 사용한다.
- - -
## Sec2. 자바 코드로 직접 스프링 빈 등록하기
회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고
진행
1. main의 hello.hellpspring 패키지에 SpringConfig 생성 후 작성
* XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않으므로 생략
* DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다. 의존관계가 실행중에
  동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장
* 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
  그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로
  등록한다.
* @Autowired 를 통한 DI는 helloConroller, memberService 등과 같이 스프링이 관리하는
  객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
- - -
# Part5. 회원 관리 예제 - 웹 MVC 개발
## Sec1. 회원 웹 기능 - 홈 화면 추가
1. controller 패키지에 HomeController 클래스 생성 후 코드 작성
2. templates 폴더에 home.html 파일 생성 후 코드 작성
3. 실행하여 확인해보기
* ststic에 index.html을 살펴보면 아무것도 없으면 welcome 페이지로 넘어가게 해놨지만 
에러가 뜨는걸 확인할 수 있다. 이유는 컨트롤러가 정적 파일보다 우선순위가 높기 때문이다.
- - -
## Sec2. 회원 웹 기능 - 등록
1. MemberController 에 코드 추가
2. templates 폴더에 members 폴더 생성 후 createMemberForm.html 파일 생성 및 코드 작성
3. controller에 MemberForm 클래스 생성 후 코드 작성
- - -
## Sec3. 회원 웹 기능 - 조회
1. MemberController에 코드 추가 작성
2. templates - members 폴더에 memberList.html 파일 생성 후 코드 작성
- - -
# Part6. 스프링 DB 접근 기술
## Sec1. H2 데이터베이스 설치
0. https://www.h2database.com/html/download-archive.html 에서 h2 1.4.200 버전 다운
1. cmd 를 이용하여 h2의 bin 폴더까지 진입 후 h2.bat 명령어로 실행 -> 브라우저가 열림
   * 만일 실행이 안 될경우 xxx.xxx.x.x 부분을 localhost로 변경
2. 한 번 연결을 해본 후 test.mv.db 라는 폴더가 생성되어야 한다.
3. 뒤로 되돌아가 JDBC URL 을 jdbc:h2:tcp://localhost/~/test 로 교체 후 다시 연결.
4. ```
   drop table if exists member CASCADE;  
   create table member  
   (  
   id bigint generated by default as identity,  
   name varchar(255),  
   primary key (id)  
   );
   ```  
   를 이용하여 H2 데이터베이스에 접근해 member 테이블을 생성
5. sql 폴더 생성 후 ddl.sql 파일을 만들어 테이블 관리
- - -
## Sec2. 순수 JDBC
예전(약 20년 이상) 선배들이 사용한 방법으로 이런 방법도 있구나 알고만 넘어가자.
1. build.gradle 파일에 jdbc, h2 데이터베이스 관련 라이브러리 추가 후 옆에 나오는 코끼리 모양 클릭
2. main - resources 폴더에 존재하는 application.properties 에  스프링 부트 데이터베이스 연결 설정 추가
   * 이렇게 하면 spring 이 db 와 연결하는 것을 자동으로 해줌.
3. main/java/repository 에 JdbcMemberRepository 클래스 생성
4. public class JdbcMemberRepository 뒤에 implements MemberRepository 를 작성 후 옵션 + 엔터를 하면 가져와진다. (나머지는 복붙함)
5. main/java/service/SpringConfig 클래스에 내용 추가
6. 실행하고 회원 목록을 들어가 본다면 db에 저장되어 있는 정보가 가져와 진다. 또한 회원 가입을 하고 회원 목록을 가보면 생성되어 있는걸 확인할 수 있다.

memberService 는 interface 의 memberRepository 를 의존하고 있다. 그리고 memberRepository 는 구현제로 MemoryMemberRepository 와 JdbcMemberRepository 가 존재한다.  
spring 컨테이너로 설정을 memorymemberRepository 를 빼내고 jdbcmemberRepository 를 등록한 것이다.
- - -
## Sec3. 스프링 통합 테스트
1. test/java/service 에 존재하는 MemberServiceTest 를 복사하여 MemberServiceIntegrationTest 라는 이름으로 붙여넣는다.
2. class 위에 @SpringBootTest 과 @Transactional 를 작성하고 나머지들도 수정한다.
3. test 코드를 돌리기 전에 h2 에 저장되어 있는 데이터들을 지워준다. 왜냐하면 db 에 저장되어 있는 정보들도 가져오기 때문에 겹쳐서 충돌이 날 수도 있다.

순수한 **단위 테스트**가 스프링 컨테이너까지 올려 테스트 하는 **통합 테스트**보다 좋을 확률이 높다.
- - -
## Sec4. 스프링 JdbcTemplate
* 스프링 JdbcTemplate 는 순수 Jdbc와 동일한 환경설정을 하면 된다.
* 스프링 JdbccTemplate과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분
  제거해준다. 하지만 SQL은 직접 작성해야 한다.
1. main/java/repository 에 JdbcTemplateMemberRepository 클래스를 생성 후 작성한다.
2. SpringConfig 에 가서 JdbcMemberRepository 에 관련된 문장을 주석처리 후 JdbcTemplateMemberRepository 에 관한 문장을 작성한다.
3. 테스트 코드로 가서 실행해보기
- - -
## Sec5. JPA
SQL 쿼리도 JPA가 자동으로 처리를 해줘 SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환하게 될 수 있기 때문에 개발 생산성을 크게 높일 수 있다.
1. build.gradle 에 dependencies 부분에 내용 추가. (jdbc는 이제 필요가 없으니 주석 처리)
   * data-jpa 는 jdbc 같은 것들도 전부 포함을 하고 있다.
2. resources 에 application.properties 에서 내용 추가
    * jpa 를 사용하면 객체를 보고 스스로 테이블을 다 만듬. 하지만 이미 만들어놨기 때문에 ddl-auto 를 꺼둠. create로 하면 create 테이블까지 자동으로 만듬.
3. main - java - domain - Member 클래스에 내용 추가.
4. main - java - repository 폴더에 JpaMemberRepository 생성 후 내용 작성.
5. MemberService 에 @Transactional 붙여주기.
6. SpringConfig 에 내용 수정 및 추가.
7. test - service - MemberServiceIntegrationTest(통합테스트)에서 테스트.
- - -
## Sec6. 스프링 테이터 JPA
* 스프링 데이터 JPA는 JPA를 편리하게 사용하도록 도와주는 기술이다. 따라서 JPA를 먼저 학습한
  후에 스프링 데이터 JPA를 학습해야 한다.  

**<스프링 데이터 JPA 제공 기능>**
* 인터페이스를 통한 기본적인 CRUD
* findByName(), findByEmail() 처럼 메서드 이름 만으로 조회 기능 제공
* 페이징 기능 자동 제공

1. main - java - repository 에 SpringDataJpaMemberRepository 라는 이름의 인터페이스를 생성한다.
2. SpringDataJpaMemberRepository 에 내용 작성
3. main - java 에 존재하는 SpringConfig 에서 내용 작성 및 수정
4. 테스트 돌려보기

참고: 실무에서는 JPA와 스프링 데이터 JPA를 기본으로 사용하고, 복잡한 동적 쿼리는 Querydsl이라는
라이브러리를 사용하면 된다. Querydsl을 사용하면 쿼리도 자바 코드로 안전하게 작성할 수 있고, 동적
쿼리도 편리하게 작성할 수 있다. 이 조합으로 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리를
사용하거나, 앞서 학습한 스프링 JdbcTemplate를 사용하면 된다.
- - -
# Part7. AOP
## Sec1. AOP가 필요한 상황
* 모든 메소드의 호출 시간을 측정하고 싶을 때.
* 공통 관심 사항(cross-cutting concern) vs 핵심 관리 사항(core concern)
* 회원 가입 시간, 회원 조회 시간을 측정하고 싶을 때.

1. main - java - service 에 존재하는 MemberService 에 내용  수정
2. 테스트 코드와 직접 실행하여 로그가 나오는지 확인

< 문제 >
* 회원가입, 회원 조회에 시간을 측정하는 기능은 핵심 관심 사항이 아님.
* 시간을 측정하는 로직은 공통 관심 사항.
* 시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어려움.
* 시간을 측정하는 로직을 별도의 공통 로직으로 만들기 매우 어려움.
* 시간을 측정하는 로직을 변경할 때 모든 로직을 찾아가면서 변경해야 함.
- - -
## Sec2. AOP 적용
* AOP : Aspect Oriented Programming
* 공통 관심 사항 vs 핵심 관심 사항 분리
1. main - java - hello.hellospring 하위에 aop 패키지 생성
2. aop 패키지에 TimeTraceAop 클래스 생성
3. 생성 후 반드시 @Aspect 작성 후 내용들 작성
4. 스프링 빈으로 등록해주기 위해 SpringConfig 에 @Bean 을  사용하여 추가 혹은 @Aspect 밑에 @Component 를 사용해도 되지만 전자가 더 좋음.
5. @Around 를 이용하여 아래 내용들을 적용시킬 곳을 선택
6. MemberService 에서 기존에 했던 문장 삭제
7. HelloSringApplication 을 실행하여 어떻게 나오는지 확인

< 해결 >
* 회원가입, 회원 조회 등 핵심 관심사항과 시간을 측정하는 공통 관심 사항을 분리한다.
* 시간을 측정하는 로직을 별도의 공통 로직으로 만든다.
* 핵심 관심 사항을 깔끔하게 유지할 수 있다.
* 변경이 필요하면 이 로직(TimeTraceAop)만 변경하면 된다.
* 원하는 적용 대상을 선택할 수 있다. @Around("execution(* hello.hellospring..*(..))")

< 동작 방식 >  
memberController 가 memberService 를 호출할 경우를 예시로 들어본다.  
* AOP 적용 전 의존 관계는 호출하면 그냥 그대로 불러진다. memberController -> memberService 가 된다.
* AOP 적용 후 의존관계는 가짜 memberService(= 프록시) 를 만들어 진짜 memberService 보다 먼저 호출이 되게끔 만든다.
  memberController -> 프록시 memberService -> (joinpoint.proceed())가 첨가됨 -> 실제 memberService 가 된다.

동작 방식을 확인할 수 있는 방법은 controller 에 존재하는 MemberController 에 System.out.println("memberService = " + memberService.getClass()); 를 작성해주면 콘솔 창에서 확인이 가능하다.
- - -
