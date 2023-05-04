# CGI 프로그램과 서블릿

## CGI (Common Gateway Interface)

* 웹 서버와 애플리케이션 사이에 데이터를 주고받는 규약
* CGI 규칙에 따라서 만들어진 프로그램을 CGI 프로그램이라고 함
* CGI 프로그램 종류로는 컴파일 방식(C, C++, Java 등)과 인터프리터 방식 (PHP, Python 등)이 있음

### 인터프리터 방식 CGI 프로그램

웹 서버 <-----> Script engine <-----> Script 파일

## Servlet (Server + Applet 의 합성어)
* 자바에서 웹 애플리케이션을 만드는 기술
* 자바에서 동적인 웹페이를 구현하기 위한 표준

### 서블릿과 서블릿 컨테이너
웹 서버 <-----> Servlet Container <-----> Servlet 파일

### Servlet Container

> 라이프 사이클을 관리한다.

* 서블릿의 생성부터 소멸까지의 라이프사이클을 관리
* 웹 서버와 소켓을 만들고 통신하는 과정을 대신 처리 (개발자는 비즈니스 로직에 집중)
* 서블릿 객체를 싱글톤으로 관리 (인스턴스 하나만 생성하여 공유하는 방식)
  * 상태를 유지(stateful)하게 설계하면 안됨
  * Thread safety 하지 않음

### WAS vs 서블릿 컨테이너
* WAS 는 서블릿 컨테이너를 포함하는 개념
* WAS 는 매 요청마다 스레드 풀에서 기존 스레드를 사용함
* WAS 의 주요 튜닝 포인트는 max thread 수
* 대표적인 WAS 로는 톰캣이 있음

### Servlet 인터페이스
* 서블릿 컨테이너가 서블릿 인터페이스에 있는 메소드들을 호출
* 서블릿 생명주기와 관련된 메소드
  * init(), service(), destroy()
* 서블릿 기타 메소드
  * getServletConfig()
  * getServletInfo()

---

## URL 인코딩 (= 퍼센트 인코딩)

* URL 로 사용할 수 없는 문자 (예약어, Non-ASCII 문자(한글) 등)를 사용할 수 있도록 인코딩하는 것
* 인코딩 된 문자는 triplet(세 개가 한 세트)로 인코딩 되며, 각각을 % 다음에 두 개의 16진수로 표현
  * 예) 강 -> %ea%b0%95
* 예약 문자
  * !, *, ', (, ), ;, :, @, &, =, +, $, (,) , /, ?, #, [, ]
* 인코딩 홈페이지
  * https://convertstring.com/ko/EncodeDecode/UrlEncode