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
        for (;;){
            int choice1 = input.nextInt();
        if (choice1 == 1){
            for (;;){


            System.out.println("chose the function you want to do:\n1.according to level\n2.according to credits\n3.according to available seats\n4.according to date");

            int choice = input.nextInt();
            if (choice == 1 ){


            }
            else if (choice==2){
                break;
            }
            else if (choice==3){
                break;
            }
            else if (choice==4){
                break;
            }

        }
        }

        }


    }
}
