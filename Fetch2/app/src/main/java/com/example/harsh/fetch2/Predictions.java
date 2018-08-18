package com.example.harsh.fetch2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "predictions")
public class Predictions {

    @PrimaryKey
    private int rollNo;

    private String name;
    private String branch;
    private double predicted_marks;
    private double predicted_drop;
    private String personality;
    private String recommended1;
    private String recommended2;
    private String recommended3;
    private String recommended4;
    private String recommended5;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPredicted_marks() {
        return predicted_marks;
    }

    public void setPredicted_marks(double predicted_marks) {
        this.predicted_marks = predicted_marks;
    }

    public double getPredicted_drop() {
        return predicted_drop;
    }

    public void setPredicted_drop(double predicted_drop) {
        this.predicted_drop = predicted_drop;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getRecommended1() {
        return recommended1;
    }

    public void setRecommended1(String recommended1) {
        this.recommended1 = recommended1;
    }

    public String getRecommended2() {
        return recommended2;
    }

    public void setRecommended2(String recommended2) {
        this.recommended2 = recommended2;
    }

    public String getRecommended3() {
        return recommended3;
    }

    public void setRecommended3(String recommended3) {
        this.recommended3 = recommended3;
    }

    public String getRecommended4() {
        return recommended4;
    }

    public void setRecommended4(String recommended4) {
        this.recommended4 = recommended4;
    }

    public String getRecommended5() {
        return recommended5;
    }

    public void setRecommended5(String recommended5) {
        this.recommended5 = recommended5;
    }
}
