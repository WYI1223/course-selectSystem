package com.user.information;
//用户：学生
    //当前年级
    //当前学分
    //已修课程
    //加入已修课程（查重）
    //删除已修课程
    //加入选择课程（给与反馈）

import com.course.information.Course;

import java.io.Serializable;
import java.util.ArrayList;


public class Students extends Member implements Serializable {

    private String major;
    private int id;
    private int grade;
    private int creditsTotal;
    private int creditsAvailable;

    private ArrayList<Course> courseList;
    private Course[] courseSelect;
    public Students(int id,String fname,String lname,int grades,String major){
        this.ID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.grade = grades;
        this.major = major;
    }


    //实现学生信息print（名字，id，专业，年级，总学分）
    public String toString(){
        return "Student name: "+firstName+" "+lastName+'\''+
                ", ID: "+ID+
                ", Major: "+major+
                ", Grade: "+grade+
                ", Credits: "+creditsTotal;
    }


    public boolean isComplete(Course course){
        if (courseList.contains(course)){
            return true;
        }
        else
            return false;
    }


    public int getCreditsAvailable() {
        return creditsAvailable;
    }

    public static void main(String[] args) {
        //学生可在此程序运行的方法
        //1.添加课程（课程会筛查重复时间以及内容）
        //2.删除课程
        //打印课程表
    }
}
