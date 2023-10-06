package com.example.khachhang;


import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {
    private static List<KhachHang> list;
    static {
        list.add(new KhachHang("Nhi","20-12-2002","31 Nguyen Du","anh1"));
        list.add(new KhachHang("Nhi2","20-12-2003","32 Nguyen Du","anh2"));
        list.add(new KhachHang("Nhi3","20-12-2004","33 Nguyen Du","anh3"));
        list.add(new KhachHang("Nhi4","20-02-2004","34 Nguyen Du","anh7"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list",list);
        response.setContentType("text/html");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);

    }

    public void destroy() {
    }
}