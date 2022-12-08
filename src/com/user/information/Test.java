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
        
        System.out.println("choose function: \n1.check course list\n2.check shopping list");
        int choice = input.nextInt();
        switch(choice){
            case 1:checkCourseList();break;
            case 2:checkShoppingList();break;
        }

    }

    public static void checkCourseList(){
        Scanner input = new Scanner(System.in);

        System.out.println("chose the function you want to do:\n1.according to level\n2.according to credits\n3.according to available seats\n4.according to date");

        int choice = input.nextInt();

        switch(choice){
            case 1:
            case 2:
            case 3:
            case 4:
        }
    }

    public static void checkShoppingList(){

    }
}
