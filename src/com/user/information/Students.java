package com.user.information;
//用户：学生
    //当前年级
    //当前学分
    //已修课程
    //加入已修课程（查重）
    //删除已修课程
    //加入选择课程（给与反馈）

import com.course.information.Course;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import com.course.information.shopping;


public class Students extends Member implements Serializable {


    private String major;
    private int id;
    private int grade;
    private int creditsTotal;
    private int creditsAvailable;

    //该学生的购物车
    private static shopping shoppingCart;

    //已修课程
    private ArrayList<Course> courseList;
    //选择课程
    private Course[] courseSelect;


    //实现学生信息print（名字，id，专业，年级，总学分）
    public String toString(){
        return "Student name: "+firstName+" "+lastName+'\''+
                ", ID: "+ID+
                ", Major: "+major+
                ", Grade: "+grade+
                ", Credits: "+creditsTotal;
    }
    public Students(int id,String fname,String lname,int grades,String major){
        this.ID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.grade = grades;
        this.major = major;
    }

    public boolean isComplete(Course course){
        if (courseList.contains(course)){
            return true;
        }
        else
            return false;
    }

    public void addCompleteCourse(Course i){
        if(isComplete(i) == true){
            courseList.add(i);
        }
        else System.out.println("已完成此课程");
    }

    public void removeCompleteCourse(Course i){
        if(isComplete(i) == true){
            courseList.remove(i);
        }
        else System.out.println("未完成此课程");
    }


    public int getCreditsAvailable() {
        return creditsAvailable;
    }

    //将序号（）加入课程购物车
    public void addShoppingCourse(Course i){
        shoppingCart.addCourse(i);
    }

    //购物车删除序号（）课程
    public void delShoppingCourse(Course i){
        shoppingCart.delCourse(i);
    }

}
