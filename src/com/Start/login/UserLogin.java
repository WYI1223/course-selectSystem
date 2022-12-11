package com.Start.login;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class UserLogin {

    public static int LoginM(int ID) throws FileNotFoundException {
        File UserInfo = new File("Data\\Member\\Students\\"+ID);
        if (!UserInfo.exists()){
            return 0;
        }
        else {
            File upsw = new File(UserInfo+"\\password.txt");
            Scanner input = new Scanner(upsw);
            Scanner inputu = new Scanner(System.in);
            String Password = inputu.nextLine();
            if(toPswSHA256(Password).equals(input.nextLine())){
                System.out.println("Correct");
                return 1; //登陆成功
            }
            else {
                System.out.println("Password fail!");
                return  2; //密码错误
            }
        }
    }
    public static boolean UserRegister(File file,String Password) throws FileNotFoundException {


//        Scanner input = new Scanner(System.in);
//        System.out.print("Please Enter your game name:");
//        String UserName = input.nextLine();
        if (file.mkdirs()){
//            System.out.print("Please Enter your Password:");
//            String Password = input.nextLine();
            PrintWriter outputUser = new PrintWriter(file +"\\Password.txt");
            outputUser.println(toPswSHA256(Password));
            outputUser.close();
            return true;
        }
        else {
            return false;
        }
    }

    public static String toPswSHA256(String psw) {
        MessageDigest messageDigest;
        String securityCode = "";
        try{
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(psw.getBytes(StandardCharsets.UTF_8));
            securityCode = byte2Hex(messageDigest.digest());
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return securityCode;

    }
    private static String byte2Hex(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (byte aByte: bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if(temp.length()==1)
                stringBuilder.append("0");
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }









}
