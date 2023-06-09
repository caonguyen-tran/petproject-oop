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
public class Designer extends Employee{
    private double heSo = 2.4;
    private double bonus;
    public Designer(String emp_ID, String fullname, Date birth, String email, String gender, Role role, Department department){
        super(emp_ID, fullname, birth, email, gender, role, department);
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double he_so) {
        this.heSo = he_so;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double tinhLuong() {
        return this.bonus + this.heSo*LUONG_CO_BAN;
    }
}
