package com.course.CourseList;

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

    public static void sortCre(ArrayList<Course> courseList) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });
        printcourselist(courseList);

    }

    public static void sortSeat(ArrayList<Course> courseList) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getAvailableSeats() - o2.getAvailableSeats();
            }
        });
        printcourselist(courseList);
    }

    public static void sortDate(ArrayList<Course> courseList) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStartDate().compareTo(o2.getStartDate());
            }
        });

        printcourselist(courseList);

    }

    public static void sortLevel(ArrayList<Course> courseList) {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getlevel() - o2.getlevel();
            }
        });
        printcourselist(courseList);
    }
    public static void printcourselist(ArrayList<Course> courseL) {
        int i = 0;
        for (;;) {
            if (i*10+9>=courseL.size()) {
                break;
            }
            for (int j = 0;j<10;j++){
                System.out.println(j+"."+courseL.get(i * 10 + j));
            }
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
                int number = input.nextInt();
                courseL.get(i*10+number).register();
            }
            else {
                break;
            }

        }

    }


}
