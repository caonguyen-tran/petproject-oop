package model;

import java.util.Date;

public abstract class Employee extends Person{
    protected final int LUONG_CO_BAN = 1490000;
    private Role role;
    private Department department;
    
    public Employee(String emp_ID, String fullname, Date birth, String email, String gender, Role role, Department department){
        super(emp_ID, fullname, birth, email, gender);
        this.role = role;
        this.department = department;
    }

    public abstract double tinhLuong();

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
