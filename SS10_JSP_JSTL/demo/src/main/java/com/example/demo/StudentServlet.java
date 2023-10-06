package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.IService;
import com.example.demo.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    StudentRepository studentRepository = new StudentRepository();
    StudentService studentService = new StudentService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    create(request,response);
                    break;
                case "edit":
//                    update(request, response);
                    demoUpdate(request,response);
                    break;

                default:
                    showList(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreate(request,response);
                    break;
                case "edit":
                    showFormEdit(request, response);
                    break;
//                case "update":
//                    showFormEdit(request, response);
//                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "demoUpdate":
                    showFormEdit(request, response);
                    break;
                case "view":
                    showFormView(request, response);
                    break;

                default:
                    showList(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void showFormView(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id=Integer.parseInt(request.getParameter("id"));
        Student student=studentRepository.findById(id);
        request.setAttribute("student",student);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("view.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void demoUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        float point = Float.parseFloat(request.getParameter("point"));
        Student student = new Student(id, name, gender, point);
        studentService.update(student);
        try {
            response.sendRedirect("/student-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        List<Student> list=studentService.delete(id);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("student", studentService.findById(id));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.getAll();
        request.setAttribute("list", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }



    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        boolean gender=Boolean.parseBoolean(request.getParameter("gender"));
        float point=Float.parseFloat(request.getParameter("point"));
        Student student=new Student(name,gender,point);
        studentService.add(student);
        response.sendRedirect("/student-servlet");
    }

//    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
//        float point = Float.parseFloat(request.getParameter("point"));
//        Student student = new Student(id, name, gender, point);
//        studentService.edit(student);
//        response.sendRedirect("/student-servlet");
//    }
}
