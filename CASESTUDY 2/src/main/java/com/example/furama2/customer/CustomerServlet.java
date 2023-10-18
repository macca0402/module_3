package com.example.furama2.customer;

import com.example.furama2.customer.Customer;
import com.example.furama2.customer.ServiceCustomer;
import java.util.List;
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
//                case "delete":
//                delete(request,response);
//                break;
//
            case "update":
                update(request,response);
                break;
//            case "search":
//                showContract(request,response);
//                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("ma_khach_hang"));
        int customerTypeId = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String customerName = request.getParameter("ho_ten");
        String customerBirthday = request.getParameter("ngay_sinh");
        String customerGender = request.getParameter("gioi_tinh");
        String customerIdCard = request.getParameter("so_cmnd");
        String customerPhone = request.getParameter("so_dien_thoai");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("dia_chi");
        Customer customer = new Customer(id,customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        request.setAttribute("customerList",serviceCustomer.update(customer));
        try {
            response.sendRedirect("/customer-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int customerTypeId = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String customerName = request.getParameter("ho_ten");
        String customerBirthday = request.getParameter("ngay_sinh");
        String customerGender = request.getParameter("gioi_tinh");
        String customerIdCard = request.getParameter("so_cmnd");
        String customerPhone = request.getParameter("so_dien_thoai");
        String customerEmail = request.getParameter("email");
        String customerAddress = request.getParameter("dia_chi");
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        serviceCustomer.add(customer);
        request.setAttribute("customerList", serviceCustomer.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer.jsp");
        try {
            requestDispatcher.forward(request, response);
            response.sendRedirect("/customer-servlet");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            case "delete":
                delete(request,response);
                break;
            case "view":
                showView(request,response);
                break;
            case "update":
                showUpdate(request,response);
                break;
            case "customer":
                customer(request,response);
                break;
//            case "search":
//                showContract(request,response);
//                break;
            default:
                showCustomer(request, response);
        }

    }

    private void customer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", serviceCustomer.customerUseService());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customerUseService.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=serviceCustomer.findByID(id);
        request.setAttribute("customer",customer);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("customer/update.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        Customer customer=serviceCustomer.findByID(id);
        request.setAttribute("customer",customer);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("customer/view.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        List<Customer> customerList=serviceCustomer.delete(id);
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer.jsp");
        try {
            response.sendRedirect("/customer-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
