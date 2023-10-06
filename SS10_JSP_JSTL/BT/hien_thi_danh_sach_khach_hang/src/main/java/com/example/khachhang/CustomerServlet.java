package com.example.khachhang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    private static List<KhachHang> list;

    static {
        list.add(new KhachHang("Nhi", "20-12-2002", "31 Nguyen Du", "anh1"));
        list.add(new KhachHang("Nhi2", "20-12-2003", "32 Nguyen Du", "anh2"));
        list.add(new KhachHang("Nhi3", "20-12-2004", "33 Nguyen Du", "anh3"));
        list.add(new KhachHang("Nhi4", "20-02-2004", "34 Nguyen Du", "anh7"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", new ArrayList<KhachHang>());
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
