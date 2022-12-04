package com.user.information;
//用户：教师
//方法：取消教授所属的课程
//方法：显示学生列表
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

    //显示教师所属课程的学生列表
    public void printStudents(){
        for (int i =0; i<courses.size();i++){
            System.out.println("The students in courses: "+courses.get(i).toString()+" is:");
            courses.get(i).printStu();
            System.out.println();
        }
    }

   




}
