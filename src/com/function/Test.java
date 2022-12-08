package com.function;

import com.course.information.Course;

import java.io.File;
import java.io.IOException;

import static com.function.storeRead.deserializeCourse;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course1 = new Course(111, "CPS2231");
        course1.serialize();
        deserializeCourse(course1);
    }
}
