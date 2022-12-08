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
        if(Contains(i) == true){
            System.out.println("已存在此课程");
        }
        else courses.add(i);
    }

    //显示教师所属课程的学生列表
    public void printStudents(){
        for (int i =0; i<courses.size();i++){
            System.out.println("The students in courses: "+courses.get(i).toString()+" is:");
            courses.get(i).printStu();
            System.out.println();
        }
    }

    //删除课程
   public void removeCourse(Course i){
        if(Contains(i) == false)System.out.println("此课程不存在");
        else courses.remove(i);
   }

   //检查课程列表
   private boolean Contains(Course i){
        boolean result = courses.contains(i);
        return result;
   }




}
