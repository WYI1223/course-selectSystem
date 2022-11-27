package com.course.information;
//课程购物车

import java.util.ArrayList;

public class shopping{

    private int credits;
    private String term;
    private String course;
    private ArrayList<Course> courseList;

    //判断是否存在相同课程
    public boolean haveSameCourse(Course course) {
        if (courseList.contains(course))
            return true;
        return false;
    }

    //添加新课程
    public void addCourse(Course course){
        if (!haveSameCourse(course)) {
            courseList.add(course);
            credits+=course.getCredits();
        }
    }

    //删除课程
    public void delCourse(Course course) {
        if (haveSameCourse(course)) {
            courseList.remove(course);
            credits-=course.getCredits();
        } else {
            System.out.println(course.getTitle() + " is not exist in shopping cart.");
        }
    }

    //计算购物车当前学分
    public int reCredits(){
        int temp = 0;
        for (int i = 0; i < courseList.size(); i++) {
            temp += courseList.get(i).getCredits();
        }
        credits = temp;
        return credits;
    }

    //查看当前购物车学分
    public int getCredits() {
        return credits;
    }
}


