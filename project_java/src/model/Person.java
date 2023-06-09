package model;

import java.util.Date;

public abstract class Person {
    private String ID;
    private String fullname, email, gender;
    private Date birth;
    public Person(){
        
    }
    public Person(String ID, String fullname, Date birth, String email, String gender){
        this.ID = ID;
        this.fullname = fullname;
        this.birth = birth;
        this.email = email;
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String full_name) {
        this.fullname = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
