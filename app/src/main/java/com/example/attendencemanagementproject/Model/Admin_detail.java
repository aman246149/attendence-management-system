package com.example.attendencemanagementproject.Model;

public class Admin_detail {
    private int id;
    private String name;
    private String password;
    private String mobile_no;
    private int admin_id;

    public Admin_detail(){}

    public Admin_detail(String name, int admin_id, String password, String mobile_no)
    {
        this.name=name;
        this.admin_id=admin_id;
        this.password=password;
        this.mobile_no=mobile_no;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
