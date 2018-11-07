package sch.hunnu.entity;

import java.math.BigDecimal;
import java.sql.Time;

public class Student {
    private BigDecimal ID;
    private String name;
    private String sex;
    private String phone;
    private Time   birth;

    public Student() {
    }

    public Student(BigDecimal ID, String name, String sex, String phone, Time birth) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                '}';
    }

    public BigDecimal getID() {
        return ID;
    }

    public void setID(BigDecimal ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Time getBirth() {
        return birth;
    }

    public void setBirth(Time birth) {
        this.birth = birth;
    }
}
