package com.example.attendencemanagementproject.Model;


public class Student_Detail {
    private int id;
    private String name; //PRESENT
    private String father_name; //PRESENT
    private int Student_id; //PRESENT
    private String course; //PRESENT
    private int semester; //PRESENT
    private int year;  //PRESENT
    private String gender; //PRESENT
    private int roll_number; //PRESENT
    private String branch; //PRESENT
    private String phone_number; //PRESENT
    private String dob;  //PRESENT
    private String password; //PRESENT

    public Student_Detail(){}

    public Student_Detail( String name, String father_name, int student_id, String course, String branch, int semester, int year, int roll_number, String gender, String phone_number,String dob,String
            password)
    {
        this.name=name;
        this.father_name=father_name;
        this.Student_id=student_id;
        this.course=course;
        this.branch=branch;
        this.semester=semester;
        this.year=year;
        this.gender=gender;
        this.roll_number=roll_number;
        this.phone_number=phone_number;
        this.dob=dob;
        this.password=password;

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

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;

    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}