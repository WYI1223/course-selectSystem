package com.course.json2data;
import com.course.information.Course;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

public class json2course {


    public static void main(String[] args) throws IOException {

        String json = "{\"id\": 26445, \"term\": \"Spring 2023 Wenzhou\", " +
                "\"termcode\": \"23/SPWZ\", \"SubjectCode\": \"CPS\", " +
                "\"Number\": \"1032\", \"title\": \"MICROCOMPUTER APPLICATIONS  \", " +
                "\"section\": \"W01\", \"prof\": [], \"days\": [[1, 3]]," +
                " \"starttime\": [\"08:30:00\"], \"endtime\": [\"09:45:00\"], " +
                "\"startdate\": [\"/Date(1676264400000)/\"], " +
                "\"enddate\": [\"/Date(1685419200000)/\"], \"capacity\": 25," +
                " \"Requisites\": [], \"credits\": \"3.0\", " +
                "\"description\": \"A study of computer literacy concepts, and computer organization of data in files and databases for information generation. Emphasis is on the proper use of microcomputer application packages to fulfill the information needs of organizations, and support professional problem solutions. Students will be introduced to a variety of microcomputer application packages. \\r\\n\\r\\n\", \"comments\": \"WENZHOU-KEAN STUDENTS ONLY.  FRESHMEN ONLY.\"}";

        int number = 26445;
        Gson gson = new Gson();
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
            Course course = new Course(courseTest.getId(), courseTest.getTitle());
            course.setNumber(Integer.parseInt(courseTest.getNumber()));
            course.setSection(courseTest.getSection());
            course.setInstructor(courseTest.getProf());
            course.setDays(courseTest.getDays()[0]);
            course.setCapacity(courseTest.getCapacity());
            course.setAvailableSeats(courseTest.getCapacity());
            course.setStartDate(new BigInteger(courseTest.getStartdate()[0].substring(6,19)));
            course.setEndDate(new BigInteger(courseTest.getEnddate()[0].substring(6,19)));
            course.setStartTime(courseTest.getStarttime()[0]);
            course.setEndTime(courseTest.getEndtime()[0]);
            course.setCredits((int) courseTest.getCredits());
            course.setDescription(courseTest.getDescription());
            course.setComments(courseTest.getComments());
            System.out.println(course.toString());
            course.serialize();
        }

    }

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