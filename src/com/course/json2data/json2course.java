package com.course.json2data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class json2course {


    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        int number = 26445;

        int count = 0;
        for (;;){
            if (number==26547)
                break;
            File file = new File("src\\com\\course\\json2data\\data\\course_info_after_"+number+++".json");
            if(!file.isFile())
                continue;

               String jsonData = readJsonDataFromFile(String.valueOf(file));

                CourseTest courseTest = gson.fromJson(jsonData, CourseTest.class);
            // CourseTest courseTest = gson.fromJson(json,CourseTest.class);
                System.out.println(courseTest.toString());
                System.out.println(count);


            count++;
        }

    }
    // Example usage:

    public static String readJsonDataFromFile(String filePath) throws IOException {
        // 创建一个字符串缓冲区，用于存储文件中的JSON数据
        StringBuilder jsonData = new StringBuilder();

        // 创建一个文件读取流
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // 定义一个变量，用于存储每一行读取到的数据
        String line;

        // 使用循环读取文件中的每一行数据
        while ((line = reader.readLine()) != null) {
            // 将读取到的数据添加到字符串缓冲区中
            jsonData.append(line);
        }

        // 关闭文件读取流
        reader.close();

        // 将字符串缓冲区中的数据转换为字符串并返回
        return jsonData.toString();
    }

}