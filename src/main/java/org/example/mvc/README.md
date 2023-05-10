# 스프링 웹 MVC 프레임워크

## 처리 흐름

1. 요청을 보내면, Dispatcher Servlet 이 받음
2. Dispatcher Servlet 은 Handler Mapping에서 요청을 처리해줄 Handler 와 메소드 정보를 알아냄
   - Handler Mapping은 어떤 요청에 어떤 컨트롤러가 동작할 지 xml 또는 java의 어노테이션 등에 설정된 정보를 관리
3. Handler Adapter에 실행 요청
4. Handler Adapter에 의해 컨트롤러, 메소드가 실행되어 결과 반환
5. Dispatcher Servlet 에 컨트롤러가 반환한 view name을 View Resolver에 전달
6. View Resolver를 통해 View 출력

## 관련 Annotation

* DispatcherServlet
* AnnotationHandlerMapping
* HandlerAdapter
* ViewResolver