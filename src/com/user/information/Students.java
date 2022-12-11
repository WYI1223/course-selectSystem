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

    public int getId() {
        return id;
    }

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

        for(;;){
            //选择功能1.浏览课程表2.浏览购物车
            System.out.println("choose function: \n1.check course list\n2.check shopping list");
            int choice = input.nextInt();
            switch(choice){
                case 1->checkCourseList();
                case 2->checkShoppingList();
            }
        }
    }

    public static void checkCourseList(){
        Scanner input = new Scanner(System.in);

        //新建shopping对象(此对象涵盖全课表)
        shopping shop = new shopping();

        //选择功能1.level排序2.学分排序3.可用座位排序4.时间排序
        System.out.println("chose the function you want to do:\n1.according to level\n2.according to credits\n3.according to available seats\n4.according to date");
        int choice = input.nextInt();

        switch(choice){
            case 1->shop.sortLevel();
            case 2->shop.sortCre();
            case 3->shop.sortSeat();
            case 4->shop.sortDate();
        }
    }

    public static void checkShoppingList(){

        Scanner input = new Scanner(System.in);

        //打印当前购物车
        System.out.println(shoppingCart.toString());

        //显示购物车学分
        System.out.println(shoppingCart.getCredits());

        //选择功能1.删除（）课程2.浏览课程表3.返回首页
        System.out.println("choose the function you want to do:\n1.remove x(serial number) course\n2.check course list\n3.return to menu");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                for(;;){
                    //当前购物车课程个数
                    int i = shoppingCart.toString().length() + 1;

                    //购物车内第x位课程
                    System.out.println("which course you want to remove(serial number)");
                    int x = input.nextInt();
                    if(x < 0 || x > i){
                        System.out.println("invalid number");
                    }
                    else shoppingCart.delCourse(shoppingCart.getCourseInfo(x));break;
                }
                break;

            case 2:checkCourseList();break;
            case 3:break;
        }
        return;
    }
}
