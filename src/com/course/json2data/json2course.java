package com.course.json2data;
import com.google.gson.Gson;

public class json2course {


    public static void main(String[] args) {

        String json = "{\"id\": 26445, \"term\": \"Spring 2023 Wenzhou\", \"termcode\": \"23/SPWZ\", \"SubjectCode\": \"CPS\", \"Number\": \"1032\", \"title\": \"MICROCOMPUTER APPLICATIONS  \", \"section\": \"W01\", \"prof\": [], \"days\": [[1, 3]], \"starttime\": [\"08:30:00\"], \"endtime\": [\"09:45:00\"], \"startdate\": [\"/Date(1676264400000)/\"], \"enddate\": [\"/Date(1685419200000)/\"], \"capacity\": 25, \"Requisites\": [], \"credits\": \"3.0\", \"description\": \"A study of computer literacy concepts, and computer organization of data in files and databases for information generation. Emphasis is on the proper use of microcomputer application packages to fulfill the information needs of organizations, and support professional problem solutions. Students will be introduced to a variety of microcomputer application packages. \\r\\n\\r\\n\", \"comments\": \"WENZHOU-KEAN STUDENTS ONLY.  FRESHMEN ONLY.\"}";

        Gson gson = new Gson();
        CourseTest courseTest = gson.fromJson(json,CourseTest.class);
        System.out.println(courseTest.toString());

    }
    // Example usage:

}