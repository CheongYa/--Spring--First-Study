스프링 입문
===========
김영한 개발자 님의 강의를 토대로 만든 것 입니다.
* Link : [Inflearn](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard "Inflearn link") 

## Part 0. 강의 소개
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

## Part1. 프로젝트 환경설정
### Sec1. 프로젝트 생성
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
### Sec2. 라이브러리 살펴보기
build.gradle에 작성한 것들은 얼마 되지 않지만, 의존관계가 있는 라이브러리를 함께 다운로드 한다.   
그렇기 때문에 External Libraries를 열어서 봐보면 엄청난 양의 라이브러리가 나타난다.
### Sec3. View 환경설정
#### Welcome Page 만들기
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