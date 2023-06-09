/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class DepartmentManager {
    private Employee employee;
    private Department department;
    private Date ngay_bo_nhiem;

    public DepartmentManager(Department department, Employee employee, Date ngay_bo_nhiem){
        this.department = department;
        this.employee = employee;
        this.ngay_bo_nhiem = ngay_bo_nhiem;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Date getNgay_bo_nhiem() {
        return ngay_bo_nhiem;
    }

    public void setNgay_bo_nhiem(Date ngay_nham_chuc) {
        this.ngay_bo_nhiem = ngay_nham_chuc;
    }
}
