package com.course.json2data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class json2course {


    public static void main(String[] args) {
        Gson gson = new Gson();
        // String json = "{\"id\": 26445, \"term\": \"Spring 2023 Wenzhou\", \"termcode\": \"23/SPWZ\", \"SubjectCode\": \"CPS\", \"Number\": \"1032\", \"title\": \"MICROCOMPUTER APPLICATIONS  \", \"section\": \"W01\", \"prof\": [], \"days\": [[1, 3]], \"starttime\": [\"08:30:00\"], \"endtime\": [\"09:45:00\"], \"startdate\": [\"/Date(1676264400000)/\"], \"enddate\": [\"/Date(1685419200000)/\"], \"capacity\": 25, \"Requisites\": [], \"credits\": \"3.0\", \"description\": \"A study of computer literacy concepts, and computer organization of data in files and databases for information generation. Emphasis is on the proper use of microcomputer application packages to fulfill the information needs of organizations, and support professional problem solutions. Students will be introduced to a variety of microcomputer application packages. \\r\\n\\r\\n\", \"comments\": \"WENZHOU-KEAN STUDENTS ONLY.  FRESHMEN ONLY.\"}";
        String [] files = {
            
             "course_info_after_26445.json","course_info_after_26446.json","course_info_after_26447.json",
             "course_info_after_26448.json","course_info_after_26449.json","course_info_after_26450.json",
             "course_info_after_26451.json","course_info_after_26452.json","course_info_after_26453.json",
             "course_info_after_26454.json","course_info_after_26455.json","course_info_after_26456.json",
             "course_info_after_26458.json","course_info_after_26459.json","course_info_after_26460.json",
             "course_info_after_26461.json","course_info_after_26462.json","course_info_after_26464.json",
        };
        for(String file: files){
        String jsonData = readJsonDataFromFile(file);

        CourseTest courseTest = gson.fromJson(jsonData, JsonArray.class);
        // CourseTest courseTest = gson.fromJson(json,CourseTest.class);
        System.out.println(courseTest.toString());
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