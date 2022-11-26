package com.course.information;
//课程购物车

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class shopping extends Course{
    private int credits;
    private String term;
    private String course;
    private boolean sameCourse;
    private ArrayList<Course> courseList;

    //判断是否存在相同课程
    public boolean haveSameCourse(Course course) {
        if (courseList.contains(course))
            return true;
        return false;
    }

    //添加新课程
    public void addCourse(Course course){
        if (haveSameCourse(course)==false) {
            courseList.add(course);
        }
    }

    //删除课程
    public void delCourse(Course course) {
        if (haveSameCourse(course)) {
            courseList.remove(course);
        } else {
            System.out.println(course.getTitle() + " is not exist in shopping cart.");
        }
    }





}
