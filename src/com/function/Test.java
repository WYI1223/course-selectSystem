package com.function;

import com.course.information.Course;
import com.user.information.Students;

import java.io.File;
import java.io.IOException;

import static com.function.storeRead.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Students CYC = new Students(1194100, "Cai", "Yingchao", 2, "CPS");
        System.out.println(CYC.getShoppingCart().getCredits());
        System.out.println("1done");
        CYC.getShoppingCart().serializeShopping();
        deserializeShopping(CYC);



    }
}
