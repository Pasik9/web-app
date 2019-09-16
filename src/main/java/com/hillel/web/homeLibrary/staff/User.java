package com.hillel.web.homeLibrary.staff;

public class User extends Id {

    private String userName;
    private Role role;
    private String password;

    public User() {

    }

    public User(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(int id,String userName,Role role,String password) {
        super(id);
        this.userName = userName;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
