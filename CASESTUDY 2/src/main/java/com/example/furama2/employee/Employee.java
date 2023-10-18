package com.example.furama2.employee;

public class Employee {
    int id;
    String name;
    String birthDay;
    String cmnd;
    double salary;
    String phone;
    String email;
    String address;
    int codePosition;
    int codeDegree;
    int codeDepartment;

    public Employee(int id, String name, String birthDay, String cmnd, double salary, String phone, String email, String address, int codePosition, int codeDegree, int codeDepartment) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.cmnd = cmnd;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.codePosition = codePosition;
        this.codeDegree = codeDegree;
        this.codeDepartment = codeDepartment;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCodePosition() {
        return codePosition;
    }

    public void setCodePosition(int codePosition) {
        this.codePosition = codePosition;
    }

    public int getCodeDegree() {
        return codeDegree;
    }

    public void setCodeDegree(int codeDegree) {
        this.codeDegree = codeDegree;
    }

    public int getCodeDepartment() {
        return codeDepartment;
    }

    public void setCodeDepartment(int codeDepartment) {
        this.codeDepartment = codeDepartment;
    }

    public Employee(String name, String birthDay, String cmnd, double salary, String phone, String email, String address, int codePosition, int codeDegree, int codeDepartment) {
        this.name = name;
        this.birthDay = birthDay;
        this.cmnd = cmnd;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.codePosition = codePosition;
        this.codeDegree = codeDegree;
        this.codeDepartment = codeDepartment;
    }
}
