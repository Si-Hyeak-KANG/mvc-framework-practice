package org.example.was.counter;

/**
 * 여러 프로세스 혹은 쓰레드가 하나의 자원을 얻기 위해 경쟁하는 상태
 */
public class RaceConditionDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter, "Thread-1");
        Thread t2 = new Thread(counter, "Thread-2");
        Thread t3 = new Thread(counter, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        /*
        서블릿 객체를 싱글통으로 관리할 때
        상태를 유지하게 설게하면 안됨 (하나의 자원을 쓰레드끼리 공유)
        따라서 원하는 결과 x -> Thread safety 하지 않음

        동기화 처리
         */
    }
}
