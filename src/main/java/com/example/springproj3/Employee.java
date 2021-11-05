package com.example.springproj3;

public class Employee {
    private  String documentId;
    private String employeeName;
    private String employeeContactNumber;
    private String employeeAddress;


    public Employee(){

    }

    public Employee(String documentId, String employeeName, String employeeAddress, String employeeContactNumber){
        this.documentId = documentId;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
