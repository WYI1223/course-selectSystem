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

    //更新课程表课程
    //将课程读入arraylist中
    public static ArrayList<Course> updataCourse() throws IOException, ClassNotFoundException {
        ArrayList<Course> courseList = new ArrayList<>();
        int number = 26445;
        for (;;){
            if (number==26547)
                break;
            File file = new File("Data\\Course\\information\\"+number+++".txt");
            if(!file.isFile())
                continue;
            Course course = deserializeCourse(file);//将反序列化的内容存入到course里面
            courseList.add(course);
//            System.out.println(course.toString());
        }
        return courseList;
    }

    public static void sortCre(ArrayList<Course> courseList,shopping shoppingcart) throws IOException {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });
        printcourselist(courseList,shoppingcart);

    }

    public static void sortSeat(ArrayList<Course> courseList,shopping shoppingcart) throws IOException {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getAvailableSeats() - o2.getAvailableSeats();
            }
        });
        printcourselist(courseList,shoppingcart);
    }

    public static void sortDate(ArrayList<Course> courseList,shopping shoppingcart) throws IOException {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });

        printcourselist(courseList,shoppingcart);

    }

    public static void sortLevel(ArrayList<Course> courseList,shopping shoppingcart) throws IOException {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getlevel() - o2.getlevel();
            }
        });
        printcourselist(courseList,shoppingcart);
    }
    public static void printcourselist(ArrayList<Course> courseL,shopping shoppingcart) throws IOException {
        int i = 0;
        for (;;) {

            if (i*10+9>=courseL.size()) {
                Scanner input = new Scanner(System.in);
                //show course
                System.out.println("----------------");
                for (int j = 0;j<courseL.size()-i*10;j++){
                    System.out.println(j+"."+courseL.get(i * 10 + j).getInformation());
                }
                System.out.println("----------------");

                //give choice to do function(at the last page)
                System.out.println("Enter 3 chose the () number course Or choose other number to quit");
                int choice = input.nextInt();
                if (choice == 3) {
                    System.out.println("choose the number () to register");
                    int number = input.nextInt();
                    if (shoppingcart.getCredits()<16&&courseL.get(i*10+number).getAvailableSeats()>0){
                        courseL.get(i*10+number).register();

                        shoppingcart.addCourse(courseL.get(i*10+number));
                        continue;
                    }
                    else {
                        System.out.println("your credits are overflow or there is no available seats in the class!");
                    }
                }
                else if (choice!=3){
                    break;
                }
            }
            //show course
            System.out.println("----------------");
            for (int j = 0;j<10;j++){
                System.out.println(j+"."+courseL.get(i * 10 + j).getInformation());
            }
            System.out.println("----------------");

            //give choice to do funtcion
            Scanner input = new Scanner(System.in);
            System.out.println("1.last page 2.next page 3.choose the () number course to register 4.show more information of () course 5.quit");
            int choice = input.nextInt();

            if (choice == 1&&i!=0) {
                i--;
            }
            else if (choice ==1&&i==0){
                System.out.println("there is the first page back to the 'choose function'");
                System.out.println();
            }
            else if (choice == 2) {
                i++;
            }
            else if (choice == 3) {
                System.out.println("choose the number () to register");
                int number = input.nextInt();
                if (shoppingcart.getCredits()<16&&courseL.get(i*10+number).getAvailableSeats()>0){
                    courseL.get(i*10+number).register();

                    shoppingcart.addCourse(courseL.get(i*10+number));
                   }
                else {
                    System.out.println("your credits are overflow or there is no available seats in the class!");
                }
            }
            else if (choice == 4){
                System.out.println("Choose the course your want to see more information");
                int number1 = input.nextInt();
                System.out.println("----------------");
                System.out.println(courseL.get(i*10+number1).toString());
                System.out.println("----------------");
            }
            else {
                break;
            }

        }

    }


}
