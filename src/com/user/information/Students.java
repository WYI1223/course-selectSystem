package com.user.information;
//用户：学生
    //当前年级
    //当前学分
    //已修课程
    //加入已修课程（查重）
    //删除已修课程
    //加入选择课程（给与反馈）

import com.course.information.Course;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.course.Shopping.shopping;
import java.io.*;


public class Students extends Member implements Serializable {


    private String major;
    private int id;
    private int grade;
    private int creditsTotal;
    private int creditsAvailable;

    //该学生的购物车
    transient private shopping shoppingCart;
    File file = new File("data\\Member\\Students\\"+id);
    private ArrayList<Integer> shoppingCartNumber = new ArrayList<>();

    //已修课程
    private ArrayList<Course> coursefinished;
    //选择课程
    private ArrayList<Course> courseSelect;

    public Students() {
    }
    public Students(int id,String fname,String lname,int grades,String major) throws IOException {
        this.ID = id;
        this.firstName = fname;
        this.lastName = lname;
        this.grade = grades;
        this.major = major;
        file = new File("data\\Member\\Students\\"+id);
        serialize();
    }

    //实现学生信息print（名字，id，专业，年级，总学分,课表）
    public String toString(){
        return "Student name: "+firstName+" "+lastName+'\''+
                ", ID: "+ID+
                ", Major: "+major+
                ", Grade: "+grade+
                ", Credits: "+creditsTotal+
                ", Shopping Cart Course ID: "+ shoppingCartNumber.toString();
    }
    public void serialize() throws IOException {
        File path = new File(file+"\\students.txt");
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
        System.out.println("序列化成功！已经生成"+getID()+".txt"+"文件");
        System.out.println("==============================================");
    }

    public boolean isComplete(Course course){
        if (coursefinished.contains(course)){
            return true;
        }
        else
            return false;
    }

    public void addCompleteCourse(Course i){
        if(isComplete(i) == true){
            coursefinished.add(i);
        }
        else System.out.println("已完成此课程");
    }

    public void removeCompleteCourse(Course i){
        if(isComplete(i) == true){
            coursefinished.remove(i);
        }
        else System.out.println("取消完成此课程");
    }

    public void addShoppingCartNumberSection(int number) throws IOException {
        if (!shoppingCartNumber.contains((Integer) number)) {
            shoppingCartNumber.add(number);
            serialize();
        }
    }
    public void delShoppingCartNumberSection(int number) throws IOException {
        Integer section = number;
        shoppingCartNumber.remove(section);
        serialize();
    }

    public ArrayList<Integer> getShoppingCartNumber() {
        return shoppingCartNumber;
    }

    public int getCreditsAvailable() {
        return creditsAvailable;
    }

    //将序号（）加入课程购物车
//    public void addShoppingCourse(Course i){
//        shoppingCart.addCourse(i);
//    }

    //购物车删除序号（）课程
//    public void delShoppingCourse(Course i){
//        shoppingCart.delCourse(i);
//    }


    public shopping getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(shopping shoppingCart) {
//        Students.shoppingCart = shoppingCart;
    }
}
