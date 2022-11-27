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
        //2. ID: "256354" 课程ID
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
        //12. Capacity: 课程容量
        //13. Available: 可用座位
        //14. Faculty[]
        //15. Student[]

import com.user.information.Faculty;
import com.user.information.Students;

import java.io.*;
import java.util.Date;

public class Course implements Comparable, Serializable {
    private String code;
    private String title;
    private String term;
    private String AcademicLevel="Undergraduate";
    private int credits;
    private Date startDate;
    private Date endDate;
    private Date date;
    private String Grading;
    private String location;
    private Faculty instructor;
    private File path;

    private Students[] students;
    public Course(String code,String title){
            this.path = new File("data\\course\\information\\"+code+".txt");
            this.code = code;
            this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }


    //comparable 接口实现
    @Override
    public int compareTo(Object o) {
        Course course1 = (Course) o;
        if (this.credits > course1.credits)
            return 1;
        else if (this.credits == course1.credits)
            return 0;
        else
            return -1;
    }


    public String callTerm(){
        return term;
    }
    public void serialize() throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        System.out.println("序列化成功！已经生成course.txt文件");
        System.out.println("==============================================");
    }

    public String toString(){
        return "Course Code: "+this.code+'\''+
                "title: "+this.title+
                ", term: "+this.term+
                ", credits: "+this.credits+
                ", instructor: "+this.instructor+
                ", period: "+this.startDate+" - "+this.endDate;
    }

}
