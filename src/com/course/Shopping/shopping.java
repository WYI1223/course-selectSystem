package com.course.Shopping;
//课程购物车

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import com.user.information.Students;

import com.course.information.Course;

import static com.course.Shopping.shoppingFunction.conflict;

public class shopping implements Serializable {

    private int credits = 0;
    private String term;
    private String course;
    private ArrayList<String> codeList = new ArrayList<>();
    private Students students;

    private ArrayList<Course> courseList = new ArrayList<Course>();

    //判断课程是否冲突
    //1.前置课是否修完
    //2.学分是否超出
    //3.是否重复修课
    //4.课程是否可用


    public shopping(Students students) {
        this.students = students;
    }

    public boolean check() {
        boolean check1 = false;
        boolean check2 = false;

        for (int i = 0; i < courseList.size(); i++) {
//            if (students.isComplete(courseList.get(i).getPreCourse())) {
//                check1 = true;
//            }
        }

        if (this.credits > students.getCreditsAvailable()) {
            if (haveSameCourse()) {
                for (int i = 0; i < courseList.size(); i++) {
                    if (courseList.get(i).getAvailableSeats() == 0)
                        check2 = true;
                }
            }
        }
        return check1 && check2;
    }

    public static void sortDate(ArrayList<Course> list) throws IOException {
        list.sort(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });
    }
    public ArrayList<Course> getcourselist(){
        return courseList;
    }


    //判断是否存在相同课程
    public boolean haveSameCourse(Course course) {
        if (courseList == null)
            return false;
        return courseList.contains(course);
    }


    public boolean haveSameCourse() {
        boolean isSame = false;
        for (int i = 0; i < courseList.size(); i++) {
            for (int ii = 0; ii < courseList.size(); ii++) {
                if (courseList.get(i) == courseList.get((ii)))
                    isSame = true;
            }
        }
        return isSame;
    }

    //添加新课程
    public void addCourse(Course course) throws IOException {
        if (!haveSameCourse(course) && credits <= 19&&conflict(course,this.courseList)) {
            courseList.add(course);
            students.addShoppingCartNumberSection(course.getID());
            credits += course.getCredits();
            System.out.println("register successfully!");
        }
        else {
            System.out.println("you already have this course in your shoppinglist or you have course that conflict with the present course");
        }
    }

    public void printcouselist() {
        for (int i = 0; i < courseList.size(); i++) {
            courseList.get(i).getInformation();
        }

    }


    //删除课程
    public void delCourse(Course course) throws IOException {
        if (haveSameCourse(course)) {
            courseList.remove(course);
            students.delShoppingCartNumberSection(course.getID());
            credits -= course.getCredits();
        } else {
            System.out.println(course.getTitle() + " is not exist in shopping cart.");
        }
    }

    //计算购物车当前学分
    public int reCredits() {
        int temp = 0;
        for (int i = 0; i < courseList.size(); i++) {
            temp += courseList.get(i).getCredits();
        }
        credits = temp;
        return credits;
    }

    //返回列表第i位课程
    public Course getCourseInfo(int i) {
        return courseList.get(i);
    }

    //查看当前购物车学分
    public int getCredits() {
        return credits;
    }


    public void showCourse() throws IOException {
        System.out.println("--------------------");
        for (;;) {
            if (this.credits==0){
                System.out.println("your shopping list is empty, suggest you to register some courses");
                break;
            }
            for (int i = 0; i < courseList.size(); i++) {
                System.out.println(i + "." + courseList.get(i).getInformation());
            }
            System.out.println("Total grades are :"+this.credits);

            System.out.println("choose the () number to remove or choose other to quit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if (0<=choice&&choice<=courseList.size()-1) {
                System.out.println("choose the number to remove");
                courseList.get(choice).addAvailableseats();
                courseList.remove(choice);
                this.students.delShoppingCartNumberSection(choice);
                if (this.credits>=3){
                    credits=credits-3;
                    System.out.println("remove successfully");
                } else if (this.credits<3) {
                    System.out.println("you have no course to remove!");
                }


            }
            else if (choice>courseList.size()-1){
                break;
            }
        }
        System.out.println("----------------------");
    }








    //实现在不考虑冲突的情况下，注册所有购物车内课程



    // public void bubbleSort(int [] arr,ArrayList<Course> list){
//        int n = arr.length;
//        int temp = 0;
//        Course tempcourse = new Course("adsa","sasa");
//        for (int i =0; i<n;i++){
//            for (int j = 1; j<(n-i);j++){
//                if(arr[j-1]>arr[j]){
//                    temp = arr[j];
//                    arr[j]=arr[j-1];
//                    arr[j-1] = temp;
//
//                    tempcourse = list.get(j);
//                    list.set(j,list.get(j-1));
//                    list.set(j-1,tempcourse);
//                }
//            }
//    }
    //实现分页展示购物表，和特定选项提供特定功能的方法（一页展示十个课程）
    //1.上一页
    //2.下一页
    //3.将user输入的序号所指课程加入购物车
    //4.返回操作的首页

    public Students getStudents() {
        return students;
    }

    public void serializeShopping() throws IOException {
        File path1 = new File("data\\Shopping\\information\\");
        path1.mkdirs();
        File path = new File("data\\Shopping\\information\\"+getStudents().getName()+"ShoppingCart.txt");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream(path));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成"+getStudents().getName()+"ShoppingCart.txt"+"文件");
        System.out.println("==============================================");
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}

