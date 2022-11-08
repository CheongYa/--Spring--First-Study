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