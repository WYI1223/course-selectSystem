package com.course.information;
//课程父类
    //课程编号
    //前置课要求
    //课程老师
    //课程学生
    //课程学分，课程学分对比
    //课程时间
    //课程打分模式
    //课程教师


import com.user.information.Faculty;
import com.user.information.Students;
import java.util.Date;

public class Course implements Comparable{
    private String code;
    private String term;

    private int credits;

    private Date date;
    private String Grading;


    private Faculty instructor;

    private Students[] students;


    public int getCredits() {
        return credits;
    }


    //comparable 接口实现
    @Override
    public int compareTo(Object o) {
        Course course1 = (Course) o;
        if (this.credits>course1.credits)
            return 1;
        else if (this.credits==course1.credits)
            return 0;
        else
            return -1;
    }

    public String callTerm(){
        return term;
    }



}
