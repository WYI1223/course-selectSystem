package com.course;

import com.course.Shopping.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.course.CourseList.courseList;
import com.course.information.Course;

import static com.course.CourseList.courseList.*;

public class Function {
    public static void checkShoppingList(shopping shoppingCart) throws IOException, ClassNotFoundException {

        shoppingCart.showCourse();

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
