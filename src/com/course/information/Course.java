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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class Course implements Comparable, Serializable {

    private String title;
    private int ID,capacity,availableSeats;
    private String subjectCode;
    private int credits;
    private int Number;
    private String Section;
//        日期
    private Date startDate,endDate;
    private int[] Days;
//         meeting时间
    private String startTime,endTime;
    private int[] requisites;
    private String Grading;

    private String[] prof;
    private int level;
    private Students students;
    private ArrayList StudentsList; //储存学生

//          文件位置
    private File path;

    private boolean isAvailable;
    private String description;
    private String comments;

    public Course() {
    }

    public Course(int ID, String title){
            this.path = new File("data\\course\\information\\"+ID+".txt");
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

    public int getlevel() {return Number;}

    public void addAvailableseats() throws IOException {
        availableSeats++;
        serialize();
    }



    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
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

    public int [] getDays(){
        return Days;
    }
    //对象序列化的实现
    public void serialize() throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
//        System.out.println("序列化成功！已经生成"+getID()+".txt"+"文件");
//        System.out.println("==============================================");
    }

    public String getInformation(){
        return "Course Section: "+this.subjectCode+"_"+this.Number+"_"+this.Section+'\''+
                ",title: "+this.title+ ", credits: "+this.credits+ ", instructor: "+ Arrays.toString(prof)+
                ",Time: "+this.startTime+"-"+this.endTime+" Days: "+ Arrays.toString(Days)+
                ", period: "+this.startDate+" - "+this.endDate+" "+this.getAvailableSeats();
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", SubjectCode='" + subjectCode + '\'' +
                ", ID=" + ID +
                ", credits=" + credits +
                ", capacity=" + capacity +
                ", availableSeats=" + availableSeats +
                ", Number=" + Number +
                ", Section='" + Section + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", Days=" + Arrays.toString(Days) +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", requisites=" + Arrays.toString(requisites) +
                ", Grading='" + Grading + '\'' +
                ", prof=" + Arrays.toString(prof) +
                ", level=" + level +
                ", students=" + students +
                ", StudentsList=" + StudentsList +
                ", path=" + path +
                ", isAvailable=" + isAvailable +
                '}';
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }


    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    //注册课程，并对使用者进行反馈
    public void register() throws IOException {
        if(availableSeats==0) {
            isAvailable = false;
            System.out.println("The course is full");
        }
        else {
            availableSeats = availableSeats - 1;
//            StudentsList.add(students);
            serialize();
        }
    }

    public void printStu(){
        for (int i = 0; i<StudentsList.size();i++){
            StudentsList.get(i).toString();
        }
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void setInstructor(String[] instructor) {
        this.prof = instructor;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public void setPath(File path) {
        this.path = path;
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }



    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setStartDate(BigInteger startDate) {
        this.startDate = new Date(startDate.longValue());
    }

    public void setEndDate(BigInteger startDate) {
        this.endDate = new Date(startDate.longValue());
    }

    public void setDays(int[] days) {
        Days = days;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setRequisites(int[] requisites) {
        this.requisites = requisites;
    }

    public void setGrading(String grading) {
        Grading = grading;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setSection(String section) {
        Section = section;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
}
