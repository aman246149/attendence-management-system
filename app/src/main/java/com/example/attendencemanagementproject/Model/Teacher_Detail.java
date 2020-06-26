package com.example.attendencemanagementproject.Model;

public class Teacher_Detail {
    private int id;
    private String name;
    private String password;
    private String mobile_no;
    private int teacher_id;

    public Teacher_Detail(){}

    public Teacher_Detail(String name,int teacher_id,String password,String mobile_no)
    {
        this.name=name;
        this.teacher_id=teacher_id;
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

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
