package com.example.furama2.contract;
import com.example.furama2.customer.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ContractServlet", value = "/contract-servlet")
public class ContractServlet extends HttpServlet {
    ServiceContract serviceContract=new ServiceContract();
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
            case "createContractDetail":
                createContractDetail(request, response);
                break;
//            case "update":
//                update(request,response);
//                break;

        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int codeContract=Integer.parseInt(request.getParameter("ma_hop_dong"));
        int codeServiceAttach =Integer.parseInt(request.getParameter("ma_dich_vu_di_kem"));
        int quantity =Integer.parseInt(request.getParameter("so_luong"));
        ContractDetail contractDetail=new ContractDetail(codeContract,codeServiceAttach,quantity);
        serviceContract.add(contractDetail);
        request.setAttribute("list", serviceContract.findAllDetail());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract/contractDetail.jsp");
        try {
            requestDispatcher.forward(request, response);
            response.sendRedirect("/contract-servlet");
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String start= request.getParameter("ngay_lam_hop_dong");
        String end= request.getParameter("ngay_ket_thuc");
        double deposit=Double.parseDouble(request.getParameter("tien_dat_coc"));
        int codeEmployee=Integer.parseInt(request.getParameter("ma_nhan_vien"));
        int codeCustomer=Integer.parseInt(request.getParameter("ma_khach_hang"));
        int codeService =Integer.parseInt(request.getParameter("ma_dich_vu"));
        Contract contract = new Contract(start,end,deposit,codeEmployee,codeCustomer,codeService);
        serviceContract.add(contract);
        request.setAttribute("list", serviceContract.getAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract/contract.jsp");
        try {
            requestDispatcher.forward(request, response);
            response.sendRedirect("/contract-servlet");
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
            case "createContract":
                showFormCreate(request, response);
                break;
            case "createContractDetail":
                showFormCreateDetail(request, response);
                break;
            case "contract":
                contract(request,response);
                break;
            case "contractDetail":
                showContractDetail(request,response);
                break;
        }

    }

    private void showFormCreateDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract/createContractDetail.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContractDetail(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list",serviceContract.findAllDetail());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("contract/contractDetail.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract/createContract.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void contract(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list",serviceContract.getAll());
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("contract/contract.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
