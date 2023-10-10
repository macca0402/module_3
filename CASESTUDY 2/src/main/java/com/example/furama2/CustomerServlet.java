package com.example.furama2;

import com.example.furama2.customer.Customer;
import com.example.furama2.customer.ServiceCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    ServiceCustomer serviceCustomer = new ServiceCustomer();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
//            case "delete":
//                showCustomer(request,response);
//                break;
//            case "edit":
//                showService(request,response);
//                break;
//            case "search":
//                showContract(request,response);
//                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int customerTypeId = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String customerName = request.getParameter("ho_va_ten");
        String customerBirthday = request.getParameter("ngay_sinh");
        String customerGender = request.getParameter("gioi_tinh");
        String customerIdCard = request.getParameter("cmnd");
        String customerPhone = request.getParameter("so_dien_thoai");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("dia_chi");
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        serviceCustomer.add(customer);
        request.setAttribute("customerList", serviceCustomer.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            response.sendRedirect("/customer-servlet");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
//            case "delete":
//                showCustomer(request,response);
//                break;
//            case "edit":
//                showService(request,response);
//                break;
//            case "search":
//                showContract(request,response);
//                break;
            default:
                showCustomer(request, response);
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("createCustomer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", serviceCustomer.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
