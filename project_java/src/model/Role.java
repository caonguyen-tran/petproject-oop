package model;

public class Role {
    private String role_ID;
    private String name_role;
    
    public Role(String role_ID, String name_role){
        this.role_ID = role_ID;
        this.name_role = name_role;
    }

    public String getRole_ID() {
        return role_ID;
    }

    public void setRole_ID(String role_ID) {
        this.role_ID = role_ID;
    }
    
    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }
}
