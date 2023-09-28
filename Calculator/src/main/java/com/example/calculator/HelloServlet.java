package com.example.calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Nhi";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        float num1=Float.parseFloat(request.getParameter("num1"));
        float num2=Float.parseFloat(request.getParameter("num2"));

        String operator=request.getParameter("operator");
        if("+".equals(operator)){
            float result=num1+num2;
            request.setAttribute("result",result);}
        if("-".equals(operator)){
            float result=num1-num2;
            request.setAttribute("result",result);
        }
        if("*".equals(operator)){
            float result=num1*num2;
            request.setAttribute("result",result);
        }
        if("/".equals(operator)){
            float result=num1/num2;
            request.setAttribute("result",result);
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request,response);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}