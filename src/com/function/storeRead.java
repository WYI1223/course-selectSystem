package com.function;

import com.course.information.Course;
import com.user.information.Member;

import java.io.*;

public class storeRead {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course1 = new Course("111","222");
//        serialize(course1);
            deserialize(course1);
            course1.toString();
    }
    //single-------------------------
    //solo course Store to document
    public static void serialize(Course course) throws IOException{
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File("course.txt") ) );
        objectOutputStream.writeObject( course );
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成course.txt文件");
        System.out.println("==============================================");
    }
    //solo course Read from document
    public static void deserialize(Course course) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("course.txt") ) );
        objectInputStream.close();
        course = (Course) objectInputStream.readObject();
        System.out.println("反序列化结果为：");
        System.out.println( course );
    }
    //single Faculty store and read
    public static void serialize(Member member) throws IOException{
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream( new File("member.txt") ) );
        objectOutputStream.writeObject( member );
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成member.txt文件");
        System.out.println("==============================================");
    }
    public static void deserialize( Member member ) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream( new FileInputStream( new File("member.txt") ) );
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println( member );
    }
    //single Students store and read

    //Shopping cart store

    //Shopping cart read



    //all--------------------------------
    //Store all course

    //Read all course

    //store&read all faculty

    //store&read all students

    //Shopping cart store

    //Shopping cart read


}
