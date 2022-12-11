package com.course.CourseList;

import com.course.Shopping.shopping;
import com.course.information.Course;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static com.function.storeRead.deserializeCourse;

public class courseList {
    public static ArrayList<Course> updataCourse() throws IOException, ClassNotFoundException {
        ArrayList<Course> courseList = new ArrayList<>();
        int number = 26445;
        for (;;){
            if (number==26547)
                break;
            File file = new File("Data\\Course\\information\\"+number+++".txt");
            if(!file.isFile())
                continue;
            Course course = deserializeCourse(file);
            courseList.add(course);
//            System.out.println(course.toString());
        }
        return courseList;
    }

    public static void sortCre(ArrayList<Course> courseList,shopping shoppingcart) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });
        printcourselist(courseList,shoppingcart);

    }

    public static void sortSeat(ArrayList<Course> courseList,shopping shoppingcart) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getAvailableSeats() - o2.getAvailableSeats();
            }
        });
        printcourselist(courseList,shoppingcart);
    }

    public static void sortDate(ArrayList<Course> courseList,shopping shoppingcart) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });

        printcourselist(courseList,shoppingcart);

    }

    public static void sortLevel(ArrayList<Course> courseList,shopping shoppingcart) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getlevel() - o2.getlevel();
            }
        });
        printcourselist(courseList,shoppingcart);
    }
    public static void printcourselist(ArrayList<Course> courseL,shopping shoppingcart) {
        int i = 0;
        for (;;) {

            if (i*10+9>=courseL.size()) {
                Scanner input = new Scanner(System.in);
                //show course
                System.out.println("----------------");
                for (int j = 0;j<courseL.size()-i*10;j++){
                    System.out.println(j+"."+courseL.get(i * 10 + j));
                }
                System.out.println("----------------");

                //give choice to do function
                System.out.println("Enter 3 chose the () number course/Or quit");
                int choice = input.nextInt();
                if (choice == 3) {
                    System.out.println("choose the number () to register");
                    int number = input.nextInt();
                    courseL.get(i*10+number).register();
                    shoppingcart.addCourse(courseL.get(i*10+number));
                    System.out.println("register successfully!");
                }
                break;
            }
            //show course
            System.out.println("----------------");
            for (int j = 0;j<10;j++){
                System.out.println(j+"."+courseL.get(i * 10 + j));
            }
            System.out.println("----------------");

            //give choice to do funtcion
            Scanner input = new Scanner(System.in);
            System.out.println("1.last page 2.next page 3.choose the () number course to register 4.quit");
            int choice = input.nextInt();

            if (choice == 1&&i!=0) {
                i--;
            }
            else if (choice == 2) {
                i++;
            }
            else if (choice == 3) {
                System.out.println("choose the number () to register");
                int number = input.nextInt();
                courseL.get(i*10+number).register();
                shoppingcart.addCourse(courseL.get(i*10+number));
                System.out.println("register successfully!");
            }
            else {
                break;
            }

        }

    }


}
