# 42gg.4nd
42gg 4기 온보딩

## 1단계

---

### 개발 환경 세팅

- IDE는 IntelliJ 추천
- IntelliJ Community 버전에서 Ultimate 버전 업그레이드 하기 (학생 라이센스 신청)
    
     Email address : 대학 재학생 혹은 졸업생일 경우 학교 이메일 또는 42계정 이메일(”$intraId”@student.42seoul.kr) 사용 가능
    
    https://goddaehee.tistory.com/215
    
- MySQL 설치
    - MySQLWorkbench 이용
    - MySQL workbench에서 외부 접속하기
        
        [https://velog.io/@woals4815/MySQL-외부-접속-하기MySQLWorkbench-이용](https://velog.io/@woals4815/MySQL-%EC%99%B8%EB%B6%80-%EC%A0%91%EC%86%8D-%ED%95%98%EA%B8%B0MySQLWorkbench-%EC%9D%B4%EC%9A%A9)
        
- redis 설치

### CRUD 구현

- `@RestController` 를 이용한 CRUD 간단하게 구현해보기

## 2단계

---

### Jpa 연관관계 매핑

- KeyWords
    - `@Embedded, @Embeddable`
    - `@Inheritance`
        - JOINED
        - SINGLE_TABLE
        - TABLE_PER_CLASS
    - 영속성 컨텍스트, 연관관계 주인
    - `@ManyToOne, @OneToMany`
    - `@OneToOne`
- Entity

![스크린샷 2023-06-26 오후 5.09.36.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/60d52002-5386-4d18-8f88-ee02d978045c/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-06-26_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.09.36.png)

- Table

![스크린샷 2023-06-26 오후 5.09.59.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/06902124-87f6-4d16-afc6-3064d0f7e8cf/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-06-26_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.09.59.png)

- 참고자료
    
    김영한 **자바 ORM 표준 JPA 프로그래밍 - 기본편**
    
    [jpa-2023-01-30 (1).zip](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a5cdcd6e-5623-4220-95e8-a88225a5a11e/jpa-2023-01-30_(1).zip)
    

## 3단계

---

### Redis

- redis 자료구조 공부 (string, hash, zset 등) → redis docs에 잘 나와있음
- `RedisTemplate` 을 이용해서 redis hash, string, zset 자료구조에 접근하는 간단한 curd 로직 만들어보기
- Redis 명령어를 redis-cli나 java spring에서 어떻게 쓰는지 바로 찾고 싶으면 chat gpt 이용해보기. 대부분의 상황에서는 잘 적용된다. 안되면 Redis 공식문서나 구글링하기.
- 참고자료
    - [우아한테크 세미나] 191121 우아한 레디스 by 강대명님
    
    [[우아한테크세미나] 191121 우아한레디스 by 강대명님](https://youtu.be/mPB2CZiAkKM)
    
    - redis docs
    
    https://redis.io/docs/data-types/
    

### Spring Security를 이용한 로그인 구현

- `spring security`를 이용해서 kakao, google등 소셜로그인 하나 구현해보기
- 참고자료
    - OAuth 관련자료
    
    [https://www.notion.so/OAuth-e64027057cdc4ce1be6f1b0c86c3070f?pvs=18](https://www.notion.so/OAuth-e64027057cdc4ce1be6f1b0c86c3070f?pvs=21)
    

## 4단계

---

### Scheduler 사용해보기

- `org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler` 를 이용해서 매 분마다 log를 출력하는 프로그램 만들어보기

### 로그백 파일 확인

- 최대 30일 로그 기록, 각각 최대 용량 400(all), 500(myLog), 100(error)MB
    
    ```jsx
    logs
      ㄴ all.log //당일 전체로그 기록
    	ㄴ error.log // 당일 에러로그 기록
    	ㄴ myLog.log // 당일 사용자커스텀로그(함수 호출,종료 순서대로 기록) 기록
    	ㄴ allLogDays
    		 ㄴ //일자별 전체로그 기록
      ㄴ errorLogDays
    		 ㄴ //일자별 에러로그 기록
      ㄴ myLogDays
    		 ㄴ //일자별 사용자커스텀로그(함수 호출,종료 순서대로 기록) 기록
    ```
    
- 로그백 파일을 확인을 통한 현재 로그 출력 방식 이해하기
- 참고자료
    
    [[Spring] 스프링 부트에서 로그(Log) 사용하기 - Logback (Sync, AsyncAppender)](https://loosie.tistory.com/829)
    

- 추가자료

[spring-guide/docs/exception-guide.md at master · cheese10yun/spring-guide](https://github.com/cheese10yun/spring-guide/blob/master/docs/exception-guide.md)

## [참고](https://www.notion.so/566f00903027416fb1df7bf33f8ee20b?pvs=21)
