package com.example.khachhang;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/khach-hang-servlet")
public class customerServlet1 extends HttpServlet {
    private static List<KhachHang> list;

    static {
        list.add(new KhachHang("Nhi", "20-12-2002", "31 Nguyen Du", "anh1"));
        list.add(new KhachHang("Nhi2", "20-12-2003", "32 Nguyen Du", "anh2"));
        list.add(new KhachHang("Nhi3", "20-12-2004", "33 Nguyen Du", "anh3"));
        list.add(new KhachHang("Nhi4", "20-02-2004", "34 Nguyen Du", "anh7"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
