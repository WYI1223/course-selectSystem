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


public class Students extends Member implements Serializable {

    private String major;
    private int id;
    private int grade;
    private int creditsTotal;
    private int creditsAvailable;

    private ArrayList<Course> courseList;
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


    public int getCreditsAvailable() {
        return creditsAvailable;
    }

    public static void main(String[] args) {
        //学生可在此程序运行的方法
        //1.添加课程（课程会筛查重复时间以及内容）
        //2.删除课程
        //打印课程表
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you acount(Idnumber + firstname + lastname + grades + major):");
        int infor1 = input.nextInt();
        String fname = input.next();
        String lname = input.next();
        int Greades = input.nextInt();
        String major = input.next();
        Students Sun = new Students(infor1,fname,lname,Greades,major);
        
        System.out.println("choose function: \n1.check course list\n2.check shopping list");
        int choice = input.nextInt();
        switch(choice){
            case 1:checkCourseList();break;
            case 2:checkShoppingList();break;
        }
    }

    public static void checkCourseList(){
        Scanner input = new Scanner(System.in);

        System.out.println("chose the function you want to do:\n1.according to level\n2.according to credits\n3.according to available seats\n4.according to date");

        int choice = input.nextInt();

        switch(choice){
            case 1:
            case 2:
            case 3:
            case 4:
        }
    }

    public static void checkShoppingList(){

    }
}
