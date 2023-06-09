package model;

public class Department {
    private String department_ID;
    private String department_name;

    public Department(){}
    public Department(String department_ID, String department_name){
        this.department_ID = department_ID;
        this.department_name = department_name;
    }

    public String getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(String department_ID) {
        this.department_ID = department_ID;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
