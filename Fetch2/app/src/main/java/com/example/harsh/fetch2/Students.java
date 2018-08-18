package com.example.harsh.fetch2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by harsh on 30/3/18.
 */

@Entity(tableName = "students")
public class Students {

    @PrimaryKey
    private int rollNo;

    private String name;
    private String Father;
    private int studentNo;
    private String branch;
    private String year;
    private String section;
    private int current_sem;
    private String DOB;
    private long contact;
    private long parent_contact;
    private String email;
    private double High_School;
    private double Intermediate;
    private double B_tech;
    private double sem_1_marks;
    private double sem_1_attendence;
    private double sem_2_marks;
    private double sem_2_attendence;
    private double sem_3_marks;
    private double sem_3_attendence;
    private double sem_4_marks;
    private double sem_4_attendence;
    private double sem_5_marks;
    private double sem_5_attendence;
    private double sem_6_marks;
    private double sem_6_attendence;
    private double sem_7_marks;
    private double sem_7_attendence;
    private double sem_8_marks;
    private double sem_8_attendence;

    public void setName(String name) {
        this.name = name;
    }

    public void setFather(String father) {
        Father = father;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setCurrent_sem(int current_sem) {
        this.current_sem = current_sem;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public void setParent_contact(long parent_contact) {
        this.parent_contact = parent_contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHigh_School(double high_School) {
        High_School = high_School;
    }

    public void setIntermediate(double intermediate) {
        Intermediate = intermediate;
    }

    public void setB_tech(double b_tech) {
        B_tech = b_tech;
    }

    public void setSem_1_marks(double sem_1_marks) {
        this.sem_1_marks = sem_1_marks;
    }

    public void setSem_1_attendence(double sem_1_attendence) {
        this.sem_1_attendence = sem_1_attendence;
    }

    public void setSem_2_marks(double sem_2_marks) {
        this.sem_2_marks = sem_2_marks;
    }

    public void setSem_2_attendence(double sem_2_attendence) {
        this.sem_2_attendence = sem_2_attendence;
    }

    public void setSem_3_marks(double sem_3_marks) {
        this.sem_3_marks = sem_3_marks;
    }

    public void setSem_3_attendence(double sem_3_attendence) {
        this.sem_3_attendence = sem_3_attendence;
    }

    public void setSem_4_marks(double sem_4_marks) {
        this.sem_4_marks = sem_4_marks;
    }

    public void setSem_4_attendence(double sem_4_attendence) {
        this.sem_4_attendence = sem_4_attendence;
    }

    public void setSem_5_marks(double sem_5_marks) {
        this.sem_5_marks = sem_5_marks;
    }

    public void setSem_5_attendence(double sem_5_attendence) {
        this.sem_5_attendence = sem_5_attendence;
    }

    public void setSem_6_marks(double sem_6_marks) {
        this.sem_6_marks = sem_6_marks;
    }

    public void setSem_6_attendence(double sem_6_attendence) {
        this.sem_6_attendence = sem_6_attendence;
    }

    public void setSem_7_marks(double sem_7_marks) {
        this.sem_7_marks = sem_7_marks;
    }

    public void setSem_7_attendence(double sem_7_attendence) {
        this.sem_7_attendence = sem_7_attendence;
    }

    public void setSem_8_marks(double sem_8_marks) {
        this.sem_8_marks = sem_8_marks;
    }

    public void setSem_8_attendence(double sem_8_attendence) {
        this.sem_8_attendence = sem_8_attendence;
    }

    public String getName() {
        return name;
    }

    public String getFather() {
        return Father;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public String getBranch() {
        return branch;
    }

    public String getYear() {
        return year;
    }

    public String getSection() {
        return section;
    }

    public int getCurrent_sem() {
        return current_sem;
    }

    public String getDOB() {
        return DOB;
    }

    public long getContact() {
        return contact;
    }

    public long getParent_contact() {
        return parent_contact;
    }

    public String getEmail() {
        return email;
    }

    public double getHigh_School() {
        return High_School;
    }

    public double getIntermediate() {
        return Intermediate;
    }

    public double getB_tech() {
        return B_tech;
    }

    public double getSem_1_marks() {
        return sem_1_marks;
    }

    public double getSem_1_attendence() {
        return sem_1_attendence;
    }

    public double getSem_2_marks() {
        return sem_2_marks;
    }

    public double getSem_2_attendence() {
        return sem_2_attendence;
    }

    public double getSem_3_marks() {
        return sem_3_marks;
    }

    public double getSem_3_attendence() {
        return sem_3_attendence;
    }

    public double getSem_4_marks() {
        return sem_4_marks;
    }

    public double getSem_4_attendence() {
        return sem_4_attendence;
    }

    public double getSem_5_marks() {
        return sem_5_marks;
    }

    public double getSem_5_attendence() {
        return sem_5_attendence;
    }

    public double getSem_6_marks() {
        return sem_6_marks;
    }

    public double getSem_6_attendence() {
        return sem_6_attendence;
    }

    public double getSem_7_marks() {
        return sem_7_marks;
    }

    public double getSem_7_attendence() {
        return sem_7_attendence;
    }

    public double getSem_8_marks() {
        return sem_8_marks;
    }

    public double getSem_8_attendence() {
        return sem_8_attendence;
    }
}
