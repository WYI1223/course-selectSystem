package com.user.information;
//用户：学生
    //当前年级
    //当前学分
    //已修课程
        //加入已修课程
        //删除已修课程
    //加入选择课程

import com.course.information.Course;

import java.io.Serializable;
import java.util.ArrayList;

public class Students extends Member implements Serializable {

    private String major;
    private int grade;
    private int creditsTotal;
    private int creditsAvailable;

    private ArrayList<Course> courseList;
    private Course[] courseSelect;

    //实现学生信息print（名字，id，专业，年级，总学分）
    public String toString(){
        return "Student name: "+firstName+lastName+'\''+
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
}
