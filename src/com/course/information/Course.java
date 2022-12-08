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
        //1. Code:"23/SPWZ" 23年 温州 春季学期
        //2. ID: "2232" 课程ID
        //3. Title: "MICROCOMPUTER APPLICATIONS" 课程名称
        //4. Number:"W02" 这个也就是Section
        //5. AcademicLevel: "Undergraduate" 学术等级 本科生
        //6. Credits: 3 学分
    // 日期与时间
        //7. StartDate 开始日期 endDate 结束日期
        //8. StartTime 开始时间 endTime 结束时间
        //9. Days: [1,3] 周一周三
        //10. Room: "*" 也就是位置
        //11. Requisites: id 是前置课，id是前置课的id
        //12. Capacity: 课程容量（已实现）
        //13. Available: 可用座位（已实现）
        //14. Faculty
        //15. Student[]
        //16. isAvailable:是否可用（已实现）


import com.user.information.Faculty;
import com.user.information.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Course implements Comparable, Serializable {
    private String code,title,room;
    private String AcademicLevel="Undergraduate";
    private int ID,credits,capacity,availableSeats;
//        日期
    private Date startDate,endDate;
    private int[] Days;
//         meeting时间
    private Date startTime,endTime;
    private int[] requisites;
    private String Grading;
    private int Capacity,Available;
    private Faculty instructor;
    private Students students;
    private ArrayList StudentsList; //储存学生

//          文件位置
    private File path;
    private Course preCourse;
    private boolean isAvailable;

    private static int[] allcourse;


    public Course(int ID,String title){
            this.path = new File("data\\course\\information\\"+ID+title+".txt");
            this.ID = ID;
            this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public int getID() {
        return ID;
    }

    public int getCredits() {
        return credits;
    }


    //comparable 接口实现
    @Override
    public int compareTo(Object o) {
        Course course1 = (Course) o;
        if (this.ID > course1.ID)
            return 1;
        else if (this.ID == course1.ID)
            return 0;
        else
            return -1;
    }


    //对象序列化的实现
    public void serialize() throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        System.out.println("序列化成功！已经生成"+getID()+getTitle()+".txt"+"文件");
        System.out.println("==============================================");
    }

    public String toString(){
        return "Course ID: "+this.ID+'\''+
                ",title: "+this.title+
                ", credits: "+this.credits+
                ", instructor: "+this.instructor+
                ", period: "+this.startDate+" - "+this.endDate;
    }

    public Course getPreCourse() {
        return preCourse;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    //注册课程，并对使用者进行反馈
    public void register(){
        if(availableSeats==0) {
            isAvailable = false;
            System.out.println("The course is full");
        }
        else {
            availableSeats = availableSeats - 1;
            StudentsList.add(students);
        }
    }

    public void printStu(){
        for (int i = 0; i<StudentsList.size();i++){
            StudentsList.get(i).toString();
        }
    }


}
