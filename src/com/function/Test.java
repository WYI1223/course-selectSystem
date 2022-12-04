package com.function;

import com.course.information.Course;

import java.io.File;
import java.io.IOException;

import static com.function.storeRead.deserializeCourse;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course1 = new Course("111", "222");
        course1.serialize();
        Course course2 = new Course("222","333");
        deserializeCourse(course2);
    }
}
