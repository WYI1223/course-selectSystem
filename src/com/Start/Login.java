package com.Start;

import com.course.Shopping.shopping;
import com.course.information.Course;
import com.user.information.Students;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.Start.login.UserLogin.LoginM;
import static com.Start.login.UserLogin.UserRegister;
import static com.course.Function.checkCourseList;
import static com.course.Function.checkShoppingList;
import static com.function.storeRead.deserializeCourse;
import static com.function.storeRead.deserializeStudent;


public class Login {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File userfile1 = new File("data\\Member\\Students\\");
        File userfile = new File("");
        int id;
        Students students = new Students();


        for (; ; ) {
            Scanner input = new Scanner(System.in);

            System.out.println("Please enter your Student ID:");
            id = input.nextInt();

            userfile = new File(userfile1 + "\\" + id);
            File file = new File(userfile + "\\students.txt");

            int status = LoginM(id);

            if (status == 0) {
                System.out.print("Unregistered User\nPlease enter your password:");
                String psw = input.next();
                if (!UserRegister(userfile, psw))
                    break;
                System.out.println("\nEnter you acount(firstname + lastname + grades + major):");
                String fname = input.next();
                String lname = input.next();
                int Greades = input.nextInt();
                String major = input.next();
                students = new Students(id, fname, lname, Greades, major);
            } else if (status == 2) {
                continue;
            }
            System.out.println("Login successful!");

            //反序列化
            students = deserializeStudent(file);
            System.out.println(students.toString());
            shopping shoppingcart = new shopping(students);

            ArrayList courses = new ArrayList<>(students.getShoppingCartNumber());
            for (;;){
                File coursefile = new File("data\\course\\information\\"+courses.remove(0)+".txt");
                shoppingcart.addCourse(deserializeCourse(coursefile));
                if(courses.isEmpty())
                    break;
            }


            ArrayList<Course> courseList = new ArrayList<>();

            for (; ; ) {
                //选择功能1.浏览课程表2.浏览购物车
                System.out.println("choose function: \n1.check course list\n2.check shopping list");
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> checkCourseList(courseList, shoppingcart);
                    case 2 -> checkShoppingList(shoppingcart);
                }
            }

        }

    }
}
