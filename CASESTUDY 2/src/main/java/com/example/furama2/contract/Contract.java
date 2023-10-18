package com.example.furama2.contract;

import java.sql.Date;

public class Contract {
    int code;
    String start;
    String end;
    double deposit;
    int codeEmployee;
    int codeCustomer;
    int codeService;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(int codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public int getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(int codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public int getCodeService() {
        return codeService;
    }

    public void setCodeService(int codeService) {
        this.codeService = codeService;
    }

    public Contract() {
    }

    public Contract(String start, String end, double deposit, int codeEmployee, int codeCustomer, int codeService) {
        this.start = start;
        this.end = end;
        this.deposit = deposit;
        this.codeEmployee = codeEmployee;
        this.codeCustomer = codeCustomer;
        this.codeService = codeService;
    }

    public Contract(int code, String start, String end, double deposit, int codeEmployee, int codeCustomer, int codeService) {
        this.code = code;
        this.start = start;
        this.end = end;
        this.deposit = deposit;
        this.codeEmployee = codeEmployee;
        this.codeCustomer = codeCustomer;
        this.codeService = codeService;
    }
}
