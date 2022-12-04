package com.user.information;
//对Studens和Faculty类的一个测试程序
import com.course.information.shopping;

import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you acount(Idnumber + firstname + lastname + grades + major):");
        int infor1 = input.nextInt();
        String fname = input.next();
        String lname = input.next();
        int Greades = input.nextInt();
        String major = input.next();
        Students Sun = new Students(infor1,fname,lname,Greades,major);
        System.out.println(Sun.toString());

    }
}
