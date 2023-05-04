package org.example;

import org.example.calculate.Calculator;
import org.example.calculate.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// 그래서 나온 것이 추상 클래스 GenericServlet -> service 만 추상 메서드이므로 이것만 구현, 나머지는 필요할 때만
@WebServlet("/calculate2")
public class CalculatorServlet2 extends GenericServlet {

    private final static Logger log = LoggerFactory.getLogger(CalculatorServlet2.class);


    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        log.info("service");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
