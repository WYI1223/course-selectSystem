package com.course.information;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class shopping extends Course{
    private int credits;
    private String term;
    private String course;
    private boolean sameCourse;
    private ArrayList<String> courseList;

    public boolean isSameCourse(String course) {
        for (int i =0; i <courseList.size();i++){
            if(courseList.get(i).toLowerCase(Locale.ROOT)==this.course.toLowerCase(Locale.ROOT)){return false;}

        }
        return true;
    }

    public void addCourse(){
        if (isSameCourse(course)==false) {
            courseList.add(course);
        }
    }

    public void removeCourse(){
        Scanner input = new Scanner(System.in);
        String currentCourse = input.next();
        if (isSameCourse(currentCourse)){
            courseList.remove(currentCourse);
        }
    }






}
