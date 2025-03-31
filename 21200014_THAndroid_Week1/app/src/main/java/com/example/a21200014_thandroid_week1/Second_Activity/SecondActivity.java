package com.example.a21200014_thandroid_week1.Second_Activity;

import java.io.Serializable;

public class SecondActivity implements Serializable {
    private String name;
    private String id;
    private String studentClass;
    private String phone;
    private String grade;
    private String major;
    private String developmentPlan;

    public SecondActivity(String name, String id, String studentClass, String phone, String grade, String major, String developmentPlan) {
        this.name = name;
        this.id = id;
        this.studentClass = studentClass;
        this.phone = phone;
        this.grade = grade;
        this.major = major;
        this.developmentPlan = developmentPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDevelopmentPlan() {
        return developmentPlan;
    }

    public void setDevelopmentPlan(String developmentPlan) {
        this.developmentPlan = developmentPlan;
    }
}
