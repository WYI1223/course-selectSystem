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

public class Students extends Member implements Serializable {

    private String major;
    private int grade;
    private int credits;



    private Course[] courseFinished;
    private Course[] courseSelect;

    public String toString(){
        return "Student name: "+firstName+lastName+'\''+
                ", ID: "+ID+
                ", Major: "+major+
                ", Grade: "+grade+
                ", Credits: "+credits;
    }
    
}
