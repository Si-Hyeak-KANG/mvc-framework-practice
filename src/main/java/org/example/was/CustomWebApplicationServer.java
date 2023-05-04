package org.example.was;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * STEP 1 : 사용자 요청을 메인 Thread 가 처리
 * STEP 2 : 사용자 요청이 들어올 때마다 Thread 를 생성해서 사용자 요청을 처리 -> 동시 접속자가 많아질 수록. cpu 와 메모리 사용량 증가, 서버 다운
 * STEP 3 : 안정적인 서비스를 위해 'Thread Pool' 적용
 */
// Custom Tomcat Practice - WAS (Web Application Server)
// HTTP 프로토콜 통신 방식
public class CustomWebApplicationServer {

    private final int port;

    // Thread Pool 생성
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                // client 마다 별도 스레드 실행
                // new Thread(new ClientRequestHandler(clientSocket)).start();

                executorService.execute(new ClientRequestHandler(clientSocket));
            }
        }
    }
}
