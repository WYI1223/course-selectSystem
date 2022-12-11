package com.course.json2data;

import com.google.gson.Gson;

public class json2course {

    public class Course {
        public int id;
        public String term;
        public String name;
        public String title;
        public String section;
        public String[] prof;
        public int[][] days;
        public String[] starttime;
        public String[] endtime;
        public String[] startdate;
        public String[] enddate;
        public String description;
        public String comments;

        public static Course fromJson(String json) {
            return new Gson().fromJson(json, Course.class);
        }

        @Override
        public String toString() {
            return this.id+""+this.term+""
                    +this.name +""+this.title+""+this.section+""+this.prof+"\n"
                    +days[0][0]+"123 "+days[0][1];
        }
    }

    public static void main(String[] args) {

        String json = "{\"id\": 26445, \"term\": \"Spring 2023 Wenzhou\", \"name\": \"CPS_1032\", " +
                "\"title\": \"MICROCOMPUTER APPLICATIONS  \", \"section\": \"W01\", \"prof\": [], " +
                "\"days\": [[1, 3]], \"starttime\": [\"08:30:00\"], \"endtime\": [\"09:45:00\"], " +
                "\"startdate\": [\"/Date(1676264400000)/\"], \"enddate\": [\"/Date(1685419200000)/\"], " +
                "\"description\": \"A study of computer literacy concepts, and computer organization of data in files and databases for information generation. Emphasis is on the proper use of microcomputer application packages to fulfill the information needs of organizations, and support professional problem solutions. Students will be introduced to a variety of microcomputer application packages. \\r\\n\\r\\n\", " +
                "\"comments\": \"WENZHOU-KEAN STUDENTS ONLY.  FRESHMEN ONLY.\"}";
        Course course = Course.fromJson(json);
        System.out.println(course.toString());


    }
    // Example usage:

}