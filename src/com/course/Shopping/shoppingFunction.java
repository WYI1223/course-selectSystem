package com.course.Shopping;

import com.course.information.Course;

import java.util.ArrayList;

public class shoppingFunction {


    public static boolean conflict(Course course, ArrayList<Course> shoppinglist){
        for (int i=0; i<shoppinglist.size();i++){
        if (shoppinglist.get(i).getDays()[0]==course.getDays()[0]
        ||shoppinglist.get(i).getDays()[1]==course.getDays()[1]
        ||shoppinglist.get(i).getDays()[0]==course.getDays()[1]
        ||shoppinglist.get(i).getDays()[1]==course.getDays()[0]) {
            if (shoppinglist.get(i).getStartTime().hashCode() - course.getStartTime().hashCode() < 0
                    && shoppinglist.get(i).getEndTime().hashCode() - course.getStartTime().hashCode() > 0
                    || shoppinglist.get(i).getStartTime().hashCode() - course.getEndTime().hashCode() < 0
                    && shoppinglist.get(i).getEndTime().hashCode() - course.getEndTime().hashCode() > 0
                    ||shoppinglist.get(i).getEndTime().hashCode() ==course.getEndTime().hashCode()
                    ||shoppinglist.get(i).getEndTime().hashCode() ==course.getStartTime().hashCode()
                    ||shoppinglist.get(i).getStartTime().hashCode() ==course.getEndTime().hashCode()
                    ||shoppinglist.get(i).getStartTime().hashCode() ==course.getStartTime().hashCode()
            )
                return false;
            else
                return true;
        }
    }
        return true;
    }



}
