package com;

import com.course.information.Course;
import com.user.information.Students;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.course.Function.checkCourseList;
import static com.course.Function.checkShoppingList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
        Students students = new Students(infor1,fname,lname,Greades,major);
        ArrayList<Course> courseList = null;

        for(;;){
            //选择功能1.浏览课程表2.浏览购物车
            System.out.println("choose function: \n1.check course list\n2.check shopping list");
            int choice = input.nextInt();
            switch(choice){
                case 1->checkCourseList(courseList);
                case 2->checkShoppingList(students.getShoppingCart(),courseList);
            }
        }
    }
}
