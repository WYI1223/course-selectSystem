package com.Start;

import com.Start.login.UserLogin;

import java.io.IOException;
import java.io.*;
import java.util.Scanner;

import static com.Start.login.UserLogin.LoginM;
import static com.Start.login.UserLogin.UserRegister;


public class Login {
    public static void main(String[] args) throws FileNotFoundException {

        File userfile1 = new File("Data\\Member\\Students\\");
        File userfile = new File("");


        for (;;) {
            Scanner input = new Scanner(System.in);

            System.out.println("Please enter your Student ID:");
            int id = input.nextInt();
            userfile = new File(userfile1 +"\\"+ id);

            int status = LoginM(id);

            if (status == 0) {
                System.out.print("Unregistered User\nPlease enter your password:");
                String psw = input.next();
                if (UserRegister(userfile,psw))
                    break;
            }
            else if (status == 2) {
                continue;
            }
            System.out.println("Login successful!");
        }

    }



}
