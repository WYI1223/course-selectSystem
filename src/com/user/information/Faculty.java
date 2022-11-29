package com.user.information;
//用户：教师
//

import com.course.information.Course;
import java.io.Serializable;
import java.util.ArrayList;

public class Faculty extends Member implements Serializable {

    ArrayList<Course> courses = new ArrayList<>();
    public int age;

    public void addCourse(Course i){
        courses.add(i);
    }

   




}
