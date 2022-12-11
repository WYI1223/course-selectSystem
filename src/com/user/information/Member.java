package com.user.information;
//用户父类
//名字：姓，名字，
//年龄，ID

import java.io.*;


public class Member implements Serializable {

    String firstName;
    String lastName;
    int ID;
    private File path;

    public int getID() {
        return ID;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public void serializeMember() throws IOException{
        File path1 = new File("data\\Member\\information\\");
        path1.mkdirs();
        File path = new File("data\\Member\\information\\"+getID()+getName()+".txt");
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream( new FileOutputStream(path));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成"+getID()+getName()+".txt"+"文件");
        System.out.println("==============================================");
    }
}
