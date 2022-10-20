스프링 입문
===========
김영한 개발자 님의 강의를 토대로 만든 것 입니다.
* Link : [Inflearn](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard, "Inflearn link") 

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
* https://start.spring.io 접속
* 프로젝트 선택 > Gradle + Java + 2.7.4 (뒤에 괄호 달린 것 X), Packaging: jar, Java11
* Project Metadata > groupld : hello, artifactld : hello-spring
* Dependencies > Spring Web, Thymeleaf
* GENERATE > 다운로드 완료 후 압축 풀기 (hello-spring 파일이 생긴다.)
* Intellij를 이용하여 build.gradle 열기
    - build.gradle이란, 버전 설정과 라이브러리를 가져와 주는 것.
* main - java - hello - hellospring - HelloSpringApplication에 들어가 main 메소드 실행
* Run에 Tomcat started on port(s): 8080 어쩌구가 뜨는걸 확인 후   웹 브라우저에 localhost:8080 주소칸에 입력
    - 에러 페이지가 뜬다면 성공, 사이트에 연결이 불가능하다고 나온다면 실패
