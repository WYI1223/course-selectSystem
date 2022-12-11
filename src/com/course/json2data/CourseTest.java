package com.course.json2data;

import com.google.gson.Gson;

public class CourseTest {
    private int id;
    private String term;
    private String termcode;
    private String SubjectCode;
    private String Number;
    private String title;
    private String section;
    private String[] prof;
    private int[][] days;
    private String[] starttime;
    private String[] endtime;
    private String[] startdate;
    private String[] enddate;
    private int capacity;
    private String[] Requisites;
    private float credits;
    private String description;
    private String comments;

    public int getId() {
        return id;
    }

    public String getTerm() {
        return term;
    }

    public String getTermcode() {
        return termcode;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public String getNumber() {
        return Number;
    }
    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String[] getProf() {
        return prof;
    }

    public int[][] getDays() {
        return days;
    }

    public String[] getStartdate() {
        return startdate;
    }

    public String[] getEnddate() {
        return enddate;
    }

    public String[] getStarttime() {
        return starttime;
    }

    public String[] getEndtime() {
        return endtime;
    }

    public int getCapacity() {
        return capacity;
    }

    public String[] getRequisites() {
        return Requisites;
    }

    public float getCredits() {
        return credits;
    }

    public String getDescription() {
        return description;
    }

    public String getComments() {
        return comments;
    }

    public static CourseTest fromJson(String json) {
        return new Gson().fromJson(json, CourseTest.class);
    }

    public String toString() {
        return this.id+""+this.term+""
                +this.SubjectCode +""+this.title+""+this.section+""+"\n"
                +this.days[0][0]+"\n"+this.days[0][1]+"\n"+this.capacity+this.credits+this.startdate[0];
    }
}