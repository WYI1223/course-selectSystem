package com.function;

import com.course.information.Course;
import com.course.information.shopping;
import com.user.information.Member;
import com.user.information.Students;

import java.io.*;

public class storeRead {

    //single-------------------------
    //solo course Store to document
    public static void serialize(Course course) throws IOException{
            ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File(course.getID()+course.getTitle()+".txt") ) );
        objectOutputStream.writeObject( course );
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成"+course.getID()+course.getTitle()+".txt"+"文件");
        System.out.println("==============================================");
    }
    //solo course Read from document
    public static void deserializeCourse(Course course) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream("data\\course\\information\\"+course.getID()+""+course.getTitle()+".txt") );
        course = (Course) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println(course);
    }
    //single Faculty store and read
    public static void serialize(Member member) throws IOException{
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File(member.getID()+member.getName()+".txt") ) );
        objectOutputStream.writeObject( member );
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成"+member.getID()+member.getName()+".txt"+"文件");
        System.out.println("==============================================");
    }
    public static void deserializeMember(Member member) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("data\\member\\information\\"+member.getID()+""+member.getName()+".txt") ) );
        member = (Member) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println(member);
    }
    //single Students store and read

    //Shopping cart store
    public static void serialize(shopping shopping) throws IOException{
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File(shopping.getStudents()+"ShoppingCart.txt") ) );
        objectOutputStream.writeObject(shopping);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成"+shopping.getStudents()+"ShoppingCart.txt"+"文件");
        System.out.println("==============================================");
    }
    //Shopping cart read
    public static void deserializeShopping(Students student) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("data\\shopping\\information\\"+student.getName()+"ShoppingCart.txt") ) );
        student.setShoppingCart((shopping)objectInputStream.readObject() ) ;
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println();
    }


    //all--------------------------------
    //Store all course

    //Read all course

    //store&read all faculty

    //store&read all students

    //Shopping cart store

    //Shopping cart read


}
