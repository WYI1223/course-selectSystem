package com.couse.information;
//课程父类
    //课程编号
    //课程老师
    //课程学生
    //课程学分
    //课程时间
    //课程打分模式
    //课程教师


import com.user.information.Faculty;
import com.user.information.Students;
import java.util.Date;

public class Course {
    private String code;

    private int credits;

    private Date date;
    private String Grading;


    private Faculty instructor;

    private Students[] students;
    
    
    
    
}
