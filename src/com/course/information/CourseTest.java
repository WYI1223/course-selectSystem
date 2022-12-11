package com.course.information;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import static com.function.storeRead.deserializeCourse;

public class CourseTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        int ID = 6234;
//        String term = "23/SPWZ";
//        String SubjectCode = "CPS";
//        int Number = 2231;
//        int credit = 4;
//        String Title = "COMPUTER PROGRAMMING";
//        String Description = "Fundamental computing and programming concerts; " +
//                "use of systems software; problem solving; design of algorithms " +
//                "using a high-level, object-oriented programming language.";
//        int Requisites = 21207;
//        String AcademicLevel = "Undergraduate";
//
//        Date EndDate = new Date(new BigDecimal("1685419200000").longValue());
//        Date StartDate = new Date(new BigInteger("1676264400000").longValue());
//        int[] Days = {2,4};
//        int Available = 18;
//        int Capacity = 18;
//        Date StartTime = new Date(new BigInteger("1669815000000").longValue());
//        Date EndTime = new Date(new BigInteger("1669817700000").longValue());
//        System.out.println(new Date(new BigInteger("1676264400000").longValue()));//start date
//        System.out.println(new Date(new BigInteger("1685419200000").longValue()));//date
//        System.out.println(new Date(new BigInteger("1669815000000").longValue()));//start time
//        System.out.println(new Date(new BigInteger("1669817700000").longValue()));//end
//        System.out.println("08:30:00");
//        System.out.println(
//        "08:30:00".substring(0,2)+""+"08:30:00".substring(3,5));
//        System.out.println("09:45:00".hashCode());

        int number = 26445;
        int count = 0;
        for (;;){
            if (number==26547)
                break;
            File file = new File("Data\\Course\\information\\"+number+++".txt");
            if(!file.isFile())
                continue;
            Course course = deserializeCourse(file);
            System.out.println(course.toString());


        }





//        {"Term":{"Code":"23/SPWZ","Description":"Spring 2023 Wenzhou","StartDate":"\/Date(1676178000000)\/","EndDate":"\/Date(1685419200000)\/",
//# "ReportingYear":2022,"Sequence":6,"ReportingTerm":"23/SPWZ","FinancialPeriod":0,"DefaultOnPlan":false,"IsActive":false,"ForPlanning":true,
//# "RegistrationDates":[{"RegistrationStartDate":"\/Date(1668920400000)\/","RegistrationEndDate":"\/Date(1676869200000)\/",
//# "PreRegistrationStartDate":"\/Date(1597896000000)\/","PreRegistrationEndDate":"\/Date(1597896000000)\/","AddStartDate":"\/Date(1676869200000)\/",
//# "AddEndDate":"\/Date(1676869200000)\/","DropStartDate":"\/Date(1676955600000)\/","DropEndDate":"\/Date(1680840000000)\/",
//# "DropGradeRequiredDate":"\/Date(1676955600000)\/","Location":""}],"FinancialAidYears":[],"SessionCycles":[],"YearlyCycles":[]},
//# "Course":
//#  {"Id":"6234","SubjectCode":"CPS","Number":"2231","MinimumCredits":4.00000,"MaximumCredits":null,"VariableCreditIncrement":null,"Ceus":null,"Title":"COMPUTER PROGRAMMING",
//# "Description":"Fundamental computing and programming concerts; use of systems software; problem solving; design of algorithms using a high-level, object-oriented programming language.",
//# "TermSessionCycle":"","TermYearlyCycle":"E","YearsOffered":"EVERY SEMESTER","TermsOffered":null,"LocationCodes":[],"IsPseudoCourse":false,
//# "Requisites":[{"RequirementCode":"21207","IsRequired":true,"CompletionOrder":1,"CorequisiteCourseId":null,"IsProtected":false}],
//# "EquatedCourseIds":["CPS_2231"],"LocationCycleRestrictions":[],"VerifyGrades":null,"ShowDropRoster":false},
//# "TermDisplay":"Spring 2023 Wenzhou",
//    # "CourseDescription":"Fundamental computing and programming concerts; use of systems software; problem solving; design of algorithms using a high-level, object-oriented programming language.",
//    # "FacultyDisplay":[],"InstructorDetails":[],"DisplayOfficeHours":false,"AcademicLevel":"Undergraduate","AvailabilityStatusDisplay":"Open",
//# "MeetingsDisplay":["Tuesday, Thursday 8:30 AM - 9:15 AM TBD (Lecture) ","Tuesday, Thursday 8:30 AM - 9:15 AM 9:15 AM - 10:15 AM TBD (Lecture) "],
//# "MobileMeetingsDisplay":["T, Th 8:30-9:15 AM","2/13/2023 - 5/30/2023","TBD (LEC)","","T, Th 9:15-10:15 AM","2/13/2023 - 5/30/2023","TBD (LEC)",""],
//# "DatesDisplay":"2/13/2023-5/30/2023","AvailabilityDisplay":"18 / 18 / 0",
//# "CreditsDisplay":"4.00000 Credits","CourseTypesDisplay":[],"InstructionalMethodsDisplay":["Lecture","Lecture"],
//# "Comments":"WENZHOU-KEAN STUDENTS ONLY.  CNAHS STUDENTS ONLY.",
//# "BookstoreUrl":"https://kean.bncollege.com/webapp/wcs/stores/servlet/TBListView?cm_mmc=RI-_-732-_-1-_-A\u0026catalogId=10001\u0026storeId=24559\u0026langId=-1\u0026termMapping=Y\u0026courseXml=\u003c?xml version=\"1.0\" encoding=\"UTF-8\"?\u003e\u003ctextbookorder\u003e \u003ccourses\u003e\u003ccourse dept=\"CPS\" num=\"2231\" sect=\"W08\" term=\"23%2fSPWZ\"/\u003e\u003c/courses\u003e\u003c/textbookorder\u003e",
//# "FormattedMeetingTimes":
//    # [{"DaysOfWeekDisplay":"T/Th","StartTimeDisplay":"8:30 AM",
//    # "EndTimeDisplay":"9:15 AM","InstructionalMethodDisplay":"Lecture","BuildingDisplay":"","RoomDisplay":"",
//    # "DatesDisplay":"2/13/2023 - 5/30/2023","ShowTBD":false,"IsBuildingDisplayNullOrEmpty":true,"IsBuildingDisplayNullOrEmptyAndIsNotOnline":true,
//    # "IsBuildingDisplayNullOrEmptyAndIsOnline":false,
//    # "Days":[2,4],"EndDate":"\/Date(1685419200000)\/","EndTime":"09:15:00","Frequency":"W",
//    # "InstructionalMethodCode":"LEC","Room":"*",
//    # "StartDate":"\/Date(1676264400000)\/","StartTime":"08:30:00","IsOnline":false},
//    # {"DaysOfWeekDisplay":"T/Th","StartTimeDisplay":"9:15 AM","EndTimeDisplay":"10:15 AM","InstructionalMethodDisplay":"Lecture","BuildingDisplay":"","RoomDisplay":"",
//    # "DatesDisplay":"2/13/2023 - 5/30/2023","ShowTBD":false,"IsBuildingDisplayNullOrEmpty":true,
//    # "IsBuildingDisplayNullOrEmptyAndIsNotOnline":true,"IsBuildingDisplayNullOrEmptyAndIsOnline":false,"Days":[2,4],
//    # "EndDate":"\/Date(1685419200000)\/","EndTime":"10:15:00","Frequency":"W","InstructionalMethodCode":"LEC","Room":"*",
//    # "StartDate":"\/Date(1676264400000)\/","StartTime":"09:15:00","IsOnline":false}],
//# "IsNonTermOffering":false,"IsNonStandardDates":false,"FullTitleDisplay":"CPS*2231*W08 COMPUTER PROGRAMMING","SectionNameDisplay":"CPS*2231*W08",
//# "SectionTitleDisplay":"COMPUTER PROGRAMMING","StartDateDisplay":"2/13/2023","EndDateDisplay":"5/30/2023","LocationDisplay":"WENZHOU-KEAN UNIVERSITY",
//# "LocationCode":"W","HasUnlimitedSeats":false,"SpecialIconPath":"/Content/Images/","AdditionalFeesApply":false,"HasCustomSpecialIcon":false,"AllowAudit":true,
//# "AllowPassNoPass":false,"Available":18,"Books":[],"Capacity":18,"Ceus":null,"CourseId":"6234","EndDate":"\/Date(1685419200000)\/","Id":"256396","IsActive":true,

//# "Location":"W","MaximumCredits":null,"AvailabilityStatus":0,"Meetings":[{"InstructionalMethodCode":"LEC","StartTime":"\/Date(1669815000000)\/",

//# "Location":"W","MaximumCredits":null,"AvailabilityStatus":0,
// "Meetings":[{"InstructionalMethodCode":"LEC","StartTime":"\/Date(1669815000000)\/",

//# "EndTime":"\/Date(1669817700000)\/","Days":[2,4],"Room":"*","StartDate":"\/Date(1676264400000)\/","EndDate":"\/Date(1685419200000)\/","Frequency":"W",
//# "IsOnline":false},{"InstructionalMethodCode":"LEC","StartTime":"\/Date(1669817700000)\/","EndTime":"\/Date(1669821300000)\/","Days":[2,4],"Room":"*",
//# "StartDate":"\/Date(1676264400000)\/","EndDate":"\/Date(1685419200000)\/","Frequency":"W","IsOnline":false}],"PrimarySectionMeetings":[],
//# "MinimumCredits":4.00000,"Number":"W08","OnlyPassNoPass":false,"OverridesCourseRequisites":false,"Requisites":[],"StartDate":"\/Date(1676264400000)\/",
//# "TermId":"23/SPWZ","Title":"COMPUTER PROGRAMMING","VariableCreditIncrement":null,"WaitlistAvailable":false,"Waitlisted":0,"CourseName":"CPS*2231",
//# "Synonym":"26488","ShowWaitlistInfo":false,"ShowSpecialIcon":false}

    }



}
