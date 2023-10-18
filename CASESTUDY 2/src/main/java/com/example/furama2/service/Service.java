package com.example.furama2.service;

public class Service {
    int code;
    String name;
    int area;
    double costRent;
    int maximumContain;
    int codeTypeRent;
    int codeTypeService;
    String standardRoom;
    String descriptionConvenience;
    double areaSwimmingPool;
    int numberFloor;
    public Service() {
    }

    public Service(int code, String name, int area, double costRent, int maximumContain, int codeTypeRent, int codeTypeService, String standardRoom, String descriptionConvenience, double areaSwimmingPool, int numberFloor) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.costRent = costRent;
        this.maximumContain = maximumContain;
        this.codeTypeRent = codeTypeRent;
        this.codeTypeService = codeTypeService;
        this.standardRoom = standardRoom;
        this.descriptionConvenience = descriptionConvenience;
        this.areaSwimmingPool = areaSwimmingPool;
        this.numberFloor = numberFloor;
    }

    public Service(String name, int area, double costRent, int maximumContain, int codeTypeRent, int codeTypeService, String standardRoom, String descriptionConvenience, double areaSwimmingPool, int numberFloor) {
        this.name = name;
        this.area = area;
        this.costRent = costRent;
        this.maximumContain = maximumContain;
        this.codeTypeRent = codeTypeRent;
        this.codeTypeService = codeTypeService;
        this.standardRoom = standardRoom;
        this.descriptionConvenience = descriptionConvenience;
        this.areaSwimmingPool = areaSwimmingPool;
        this.numberFloor = numberFloor;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getMaximumContain() {
        return maximumContain;
    }

    public void setMaximumContain(int maximumContain) {
        this.maximumContain = maximumContain;
    }

    public int getCodeTypeRent() {
        return codeTypeRent;
    }

    public void setCodeTypeRent(int codeTypeRent) {
        this.codeTypeRent = codeTypeRent;
    }

    public int getCodeTypeService() {
        return codeTypeService;
    }

    public void setCodeTypeService(int codeTypeService) {
        this.codeTypeService = codeTypeService;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionConvenience() {
        return descriptionConvenience;
    }

    public void setDescriptionConvenience(String descriptionConvenience) {
        this.descriptionConvenience = descriptionConvenience;
    }

    public double getAreaSwimmingPool() {
        return areaSwimmingPool;
    }

    public void setAreaSwimmingPool(double areaSwimmingPool) {
        this.areaSwimmingPool = areaSwimmingPool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
}
