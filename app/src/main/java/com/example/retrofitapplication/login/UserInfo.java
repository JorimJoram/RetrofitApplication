package com.example.retrofitapplication.login;

public class UserInfo {
    private String id;
    private String pw;
    private String c_dt;
    private int role;

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setC_dt(String c_dt) {
        this.c_dt = c_dt;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getC_dt() {
        return c_dt;
    }

    public int getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", c_dt='" + c_dt + '\'' +
                ", role=" + role +
                '}';
    }
}
