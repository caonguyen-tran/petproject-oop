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
public class Developer extends Employee{
    private double heSo = 2.5;
    private double luongOT;
    
    public Developer(String emp_ID, String fullname, Date birth, String email, String gender, Role role, Department department){
        super(emp_ID, fullname, birth, email, gender, role, department);
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double he_so) {
        this.heSo = he_so;
    }

    public double getLuongOT() {
        return luongOT;
    }

    public void setLuongOT(double luongOT) {
        this.luongOT = luongOT;
    }

    @Override
    public double tinhLuong() {
        return this.luongOT + LUONG_CO_BAN * this.heSo;
    }
}
