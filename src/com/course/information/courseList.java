package com.course.information;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class courseList {
    ArrayList<Course> courseList;


    public void sortCre() {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });
        printcourselist(courseList);

    }

    public void sortSeat() {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getAvailableSeats() - o2.getAvailableSeats();
            }
        });
        printcourselist(courseList);
    }

    public void sortDate() {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStartDate().compareTo(o2.getStartDate());
            }
        });

        printcourselist(courseList);

    }

    public void sortLevel() {
        courseList.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getlevel() - o2.getlevel();
            }
        });
        printcourselist(courseList);
    }
    public void printcourselist(ArrayList<Course> courseL) {
        int i = 0;
        for (;;) {
            for (int j = 0;j<10;j++){
                System.out.println(j+"."+courseL.get(i * 10 + j));
            }
            Scanner input = new Scanner(System.in);
            System.out.println("1.last page 2.next page 3.choose the () number course to register 4.quit");
            int choice = input.nextInt();
            if (choice == 1&&i!=0) {
                i++;
            } else if (choice == 2) {
                i--;
            } else if (choice == 3) {
                int number = input.nextInt();
                courseL.get(i*10+number).register();
            } else if (i*10+9>=courseL.size()) {
                break;
            } else {
                break;
            }

        }

    }


}
