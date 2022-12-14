package com.course.information;

import java.io.File;
import java.io.IOException;

import static com.function.storeRead.deserializeCourse;

public class CourseAvaOver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("Data\\Course\\information\\"+26445+".txt");
        Course course = deserializeCourse(file);
        course.setAvailableSeats(0);
        course.serialize();
        System.out.println(course.getAvailableSeats());



    }
}
