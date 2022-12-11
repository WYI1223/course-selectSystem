package com.course;

import com.course.Shopping.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.course.CourseList.courseList;
import com.course.information.Course;

import static com.course.CourseList.courseList.*;

public class Function {
    public static void checkShoppingList(shopping shoppingCart,ArrayList<Course> courseList) throws IOException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);

        //打印当前购物车
        shoppingCart.printcouselist();
        //显示购物车学分
        System.out.println(shoppingCart.reCredits());

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

            case 2:checkCourseList(courseList,shoppingCart);break;
            case 3:break;
        }
        return;
    }
    public static void checkCourseList(ArrayList<Course> courseList,shopping shoppingcart) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);

        //新建shopping对象(此对象涵盖全课表)
        courseList = updataCourse();
        //选择功能1.level排序2.学分排序3.可用座位排序4.时间排序
        System.out.println("chose the function you want to do:\n1.according to level\n2.according to credits\n3.according to available seats\n4.according to date");
        int choice = input.nextInt();

        switch(choice){
            case 1->sortLevel(courseList,shoppingcart);
            case 2->sortCre(courseList,shoppingcart);
            case 3->sortSeat(courseList,shoppingcart);
            case 4->sortDate(courseList,shoppingcart);
        }
    }
}
