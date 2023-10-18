package com.example.furama2.employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee-servlet")
public class EmployeeServlet extends HttpServlet {
    ServiceEmployee serviceEmployee = new ServiceEmployee();

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

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("ma_nhan_vien"));
        String name = request.getParameter("ho_ten");
        String birthDay = request.getParameter("ngay_sinh");
        String cmnd = request.getParameter("so_cmnd");
        double salary = Double.parseDouble(request.getParameter("luong"));
        String phone = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String address = request.getParameter("dia_chi");
        int codePosition = Integer.parseInt(request.getParameter("ma_vi_tri"));
        int codeDegree = Integer.parseInt(request.getParameter("ma_trinh_do"));
        int codeDepartment = Integer.parseInt(request.getParameter("ma_bo_phan"));
        Employee employee = new Employee(id, name, birthDay, cmnd, salary, phone, email, address, codePosition, codeDegree, codeDepartment);
        request.setAttribute("employeeList", serviceEmployee.update(employee));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("ho_ten");
        String birthDay = request.getParameter("ngay_sinh");
        String cmnd = request.getParameter("so_cmnd");
        double salary = Double.parseDouble(request.getParameter("luong"));
        String phone = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String address = request.getParameter("dia_chi");
        int codePosition = Integer.parseInt(request.getParameter("ma_vi_tri"));
        int codeDegree = Integer.parseInt(request.getParameter("ma_trinh_do"));
        int codeDepartment = Integer.parseInt(request.getParameter("ma_bo_phan"));
        Employee employee = new Employee(name, birthDay, cmnd, salary, phone, email, address, codePosition, codeDegree, codeDepartment);
        serviceEmployee.add(employee);
        request.setAttribute("employeeList", serviceEmployee.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee.jsp");
        try {
            requestDispatcher.forward(request, response);
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
                delete(request, response);
                break;
            case "view":
                showView(request, response);
                break;
            case "update":
                showUpdate(request, response);
                break;
//            case "search":
//                showContract(request,response);
//                break;
            default:
                showCustomer(request, response);
        }

    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = serviceEmployee.findByID(id);
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/update.jsp");
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
        Employee employee = serviceEmployee.findByID(id);
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Employee> employeeList = serviceEmployee.delete(id);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/createEmployee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCustomer(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList", serviceEmployee.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
