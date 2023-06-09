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
public class Tester extends Employee{
    private double heSo = 2.3;
    private int errs;
    
    public Tester(String emp_ID, String fullname, Date birth, String email, String gender, Role role, Department department){
        super(emp_ID, fullname, birth, email, gender, role, department);
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double he_so) {
        this.heSo = he_so;
    }

    public int getErrs() {
        return errs;
    }

    public void setErrs(int errs) {
        this.errs = errs;
    }
   
    @Override
    public double tinhLuong() {
        return (this.errs * 200000.0) + this.heSo * LUONG_CO_BAN;
    }
}
