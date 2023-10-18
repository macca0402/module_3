package com.example.furama2.service;

import com.example.furama2.customer.Customer;
import com.example.furama2.employee.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;


@WebServlet(name = "ServiceServlet", value = "/service-servlet")
public class ServiceServlet extends HttpServlet {
    ServiceSer service = new ServiceSer();

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
            case "update":
                update(request, response);
                break;
    }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("ten_dich_vu");
        int area =Integer.parseInt(request.getParameter("dien_tich"));
        double costRent =Double.parseDouble(request.getParameter("chi_phi_thue"));
        int maximumContain=Integer.parseInt(request.getParameter("so_nguoi_toi_da"));
        int codeTypeRent=Integer.parseInt(request.getParameter("ma_kieu_thue"));
        int codeTypeService=Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String standardRoom=request.getParameter("tieu_chuan_phong");
        String descriptionConvenience = request.getParameter("mo_ta_tien_nghi_khac");
        double areaSwimmingPool =Double.parseDouble(request.getParameter("dien_tich_ho_boi"));
        int numberFloor =Integer.parseInt(request.getParameter("so_tang"));
        Service service2 = new Service(name, area, costRent, maximumContain, codeTypeRent, codeTypeService, standardRoom, descriptionConvenience, areaSwimmingPool, numberFloor);
         service.add(service2);
         request.setAttribute("list",service.findAll());
        try {
            response.sendRedirect("/service-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int code =Integer.parseInt(request.getParameter("ma_dich_vu"));
        String name=request.getParameter("ten_dich_vu");
        int area =Integer.parseInt(request.getParameter("dien_tich"));
        double costRent =Double.parseDouble(request.getParameter("chi_phi_thue"));
        int maximumContain=Integer.parseInt(request.getParameter("so_nguoi_toi_da"));
        int codeTypeRent=Integer.parseInt(request.getParameter("ma_kieu_thue"));
        int codeTypeService=Integer.parseInt(request.getParameter("ma_loai_dich_vu"));
        String standardRoom=request.getParameter("tieu_chuan_phong");
        String descriptionConvenience = request.getParameter("mo_ta_tien_nghi_khac");
        double areaSwimmingPool =Double.parseDouble(request.getParameter("dien_tich_ho_boi"));
        int numberFloor =Integer.parseInt(request.getParameter("so_tang"));
        Service service2 = new Service(code, name, area, costRent, maximumContain, codeTypeRent, codeTypeService, standardRoom, descriptionConvenience, areaSwimmingPool, numberFloor);
        request.setAttribute("list",service.update(service2));
        try {
            response.sendRedirect("/service-servlet");
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
                delete(request, response);
                break;
            case "view":
                showView(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
            default:
                showService(request, response);
        }

    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("service", service.findByID(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("service", service.findByID(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int code = Integer.parseInt(request.getParameter("id"));
        List<Service> list = service.delete(code);
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/service.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/createService.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> list = service.findAll();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("service/service.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}