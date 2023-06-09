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
public class Relative extends Person{
    private String relationship;
    private Employee employee;
    public Relative(String id, String fullname, Date birth, String email, String gender, Employee employee, String relationship){
        super(id, fullname, birth, email, gender);
        this.relationship = relationship;
        this.employee = employee;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
