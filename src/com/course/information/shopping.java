package com.course.information;
//课程购物车

import java.util.ArrayList;
import com.user.information.Students;

public class shopping{

    private int credits;
    private String term;
    private String course;
    private Students students;

    private ArrayList<Course> courseList;

    //判断课程是否冲突
    //1.前置课是否修完
    //2.学分是否超出
    //3.是否重复修课
    //4.课程是否可用
    public boolean check(){
        boolean check1 = false;
        boolean check2 = false;

        for(int i =0;i<courseList.size();i++){
            if (students.isComplete(courseList.get(i).getPreCourse())){
                check1 = true;
            }
        }

        if (this.credits>students.getCreditsAvailable()){
            if (haveSameCourse()){
                for (int i = 0; i<courseList.size();i++){
                    if (courseList.get(i).getAvailableSeats()==0)
                        check2 = true;
                }
            }
        }
        return check1&&check2;
    }


    //判断是否存在相同课程
    public boolean haveSameCourse(Course course) {
        if (courseList.contains(course))
            return true;
        return false;
    }


    public boolean haveSameCourse(){
        boolean isSame = false;
        for(int i = 0;i < courseList.size();i++){
            for(int ii = 0;ii < courseList.size(); ii++){
                if (courseList.get(i)==courseList.get((ii)))
                    isSame = true;
            }
        }
        return  isSame;
    }
    //添加新课程
    public void addCourse(Course course){
        if (!haveSameCourse(course)&&credits<=19) {
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

    public String toString(){
        return "You have these courses in your cart: "+courseList;
    }

    //实现在不考虑冲突的情况下，注册所有购物车内课程
    public void register(){
        for(int i =0; i<=courseList.size(); i++){
            courseList.get(i).register();
        }

    }
}


