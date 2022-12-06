import requests
import json

# 这里header中应该包含了一个验证时间的cookie，每次需要获取信息之前手动登录一次，打开F12复制发送往
# https://selfservice.kean.edu/Student/Courses/SearchAsync
# 的Request headers，粘贴在下方即可。
# 注：快速添加单引号和逗号的方式：
# 打开替换功能(Ctrl + R)， 打开选区替换，选中headers选区，打开正则功能
# 查找栏：(.*?): (.*)
# 替换栏：'$1': '$2',


max_page_num = 24
url = 'https://selfservice.kean.edu/Student/Courses/SearchAsync'
headers = {
    '__RequestVerificationToken':'c8fyuzBPNyzkAIWOWk7I4bdBSlu9Jn93dCIRE9uJxfyABRj8nG_GYW0ck7w_vsJy1mH5Rd3e-4K0qirvOwgiSnWWhxYJ7rwNyyzXTmPh4MU1',
    'Accept': 'application/json, text/javascript, */*; q=0.01',
    'Accept-Encoding': 'gzip, deflate, br',
    'Accept-Language': 'en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7',
    'Connection': 'keep-alive',
    'Content-Length': '751',
    'Content-Type': 'application/json, charset=UTF-8',
    'Cookie': '_gcl_au=1.1.207627324.1669452735; _ga=GA1.2.1190905544.1629033682; BE_CLA3=p_id=R4NA626J4J84R8LJLP82JP8NAAAAAAAAAH&bf=5789af93a85e8fae9f7ce435f00ad81e&bn=2&bv=3.44&s_expire=1669548069473&s_id=R4NA626J4J84R2P8LA62JP8NAAAAAAAAAH; _ga_HN53Y9FJJ9=GS1.1.1669461020.2.1.1669462896.0.0.0; __RequestVerificationToken_L1N0dWRlbnQ1=abRGdODBizmT2l2i4opci3q-xLdeKiJNg4c6bF38-CRY3O-YPcMRsaH9KwgRWzFw5HlI1BDPUZiN7VoUCLv8HMN3Pxywp4Di5q7uYS2j4vM1; _gid=GA1.2.1079614461.1669882013; studentselfservice_production_sfid=G78R02W83885; studentselfservice_production_AuthMethod=Forms; studentselfservice_production_0=BF9FA2B86129FAC148FA965334D7497380F6F3597B1AB3213C56E184829C22DA2947B97D0CCCBFC8FCA715A37B430528DFCB3F607EA7CA5674BA82EAFD76E2A6BDC83C9FD24DA37A303FA302E65B75A784E03D2051FAB16BDDFC8ED1C1444BD364CF2C8182D221689DBB973E886E0C067D5556EDB41CB54F254C773FB891C2259BE4FCA8B9AC3FEC916981B1EC3A6827EE73AB8196D84330B5A159EDC4DFC4F36961C1C4C2EF2149DB78EBC67076F068279945F298DCFA94A34B7ED64E1AF3FF4FB58C74F73733F1D3556AF2A554479E45241CD0D2AA8B8050C46F419A1AB0E32FB596E1E4C7E0A9659FF60583A4423D10A57D5F32D216879E4FFDBD6CBF6F9D96299A9B47ED3D3633763A3F2C3741A699665296B813B106DD11841BE00F69B3DDEA9EAEEA21B161EE4BB34972023F576C3453772A72A6BC058731262624C9F146BC5332B1FEE3D58374650781885AB9417A8A60B8E6A3522084588852A315B36DD0CF176175CB8B4AB29DE0120836A5F75DD123B5593784FBFC86DBBC316A35E734E68F2C9F1702436A0C0C75E315FD9A6A87347E6DABD1DACEAD664F8F9138A652EA3F7F21FCB2FF02CE6DC65680F06668F47FC407A805209A82044C11BB2DABE6D4F062DE8CCE4C585C16789998B7C98BB15A6F806CEB511D268A65462C8BB39DBE9EDF0AD6AD67017BC2B113E823DA8BA6218B53E334776AC392DC6A85D6D30D63ADDD39DA6A5A288CA61A8C7C21E0DA09240A5BAEB4017D2EE9DD5CDC4A5717CB0344E36635630BCEE405D0FC86EB1F44834BE45440E27F8F9416E05EB91F08CC6D0BC1AB253F533C1303A7F4E20F62FE766D278DA78638386C90E3E559CD630B9536B890FA71B274933DCD7950048D21E88912B5E138D8C61FF8B3DC5570C7C01E2F3314E4AFCEDCB53CAB3C469B7E6EF5768C41DDBE09569B946CA98C5077CD7FEB87E17933E1CD6C9E545EEB74E07B7EE9D8FBDC7A9C96A69BEEE09B67B2949FB645881CC4E4731D67E8FA01DB8A8F76B184F574D7AACFDABC310C951979BAF84FE0E1FF719C5D0FF3BEEFBCEBF1E2FF4AB85232B809FDD9D262C7A3F0A982AF23F33AFDCC5F8B5C2D38A2878AFBF6DF291DE3E188CF85BF31B1006855DFB1DCA297ACB6F14E538050A452F245B4C5A21E8B361B194059C60A1EF9D1',
    'Host': 'selfservice.kean.edu',
    'Origin': 'https://selfservice.kean.edu',
    'Referer': 'https://selfservice.kean.edu/Student/Courses/Search',
    'Sec-Fetch-Dest': 'empty',
    'Sec-Fetch-Mode': 'cors',
    'Sec-Fetch-Site': 'same-origin',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36',
    'X-Requested-With': 'XMLHttpRequest',
    'sec-ch-ua': '"Google Chrome";v="107", "Chromium";v="107", "Not=A?Brand";v="24"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"Windows"',
}

# searchParameters内的pageNumber变量控制了当前页页码
for page_number in range(1, max_page_num + 1):
    payload = {"searchParameters":"{\"keyword\":null,\"terms\":[\"23/SPWZ\"],\"requirement\":null,\"subrequirement\":null,"
                                  "\"courseIds\":null,\"sectionIds\":null,\"requirementText\":null,\"subrequirementText\":\"\",\"group\":null,"
                                  "\"startTime\":null,\"endTime\":null,\"openSections\":null,\"subjects\":[],\"academicLevels\":[],"
                                  "\"courseLevels\":[],\"synonyms\":[],\"courseTypes\":[],\"topicCodes\":[],\"days\":[[\"1\",\"2\",\"3\",\"4\",\"5\"],\"locations\":[],"
                                  "\"faculty\":[],\"onlineCategories\":null,\"keywordComponents\":[],\"startDate\":null,\"endDate\":null,"
                                  "\"startsAtTime\":null,\"endsByTime\":null,\"pageNumber\":1,\"sortOn\":\"SectionName\",\"sortDirection\":\"Ascending\","
                                  "\"subRequirementText\":null,\"quantityPerPage\":30,\"openAndWaitlistedSections\":null,\"searchResultsView\":\"SectionListing\"}"}

    payload2 = {"searchParameters":"{\"keyword\":null,\"terms\":[],\"requirement\":null,\"subrequirement\":null,\"courseIds\":null,\"sectionIds\":null,\"requirementText\":null,"
                                   "\"subrequirementText\":\"\",\"group\":null,\"startTime\":null,\"endTime\":null,\"openSections\":null,\"subjects\":[\"CPS\"],\"academicLevels\":[],"
                                   "\"courseLevels\":[],\"synonyms\":[],\"courseTypes\":[],\"topicCodes\":[],\"days\":[],\"locations\":[],\"faculty\":[],\"onlineCategories\":null,"
                                   "\"keywordComponents\":[],\"startDate\":null,\"endDate\":null,\"startsAtTime\":null,\"endsByTime\":null,\"pageNumber\":1,\"sortOn\":\"None\","
                                   "\"sortDirection\":\"Ascending\",\"subRequirementText\":null,\"quantityPerPage\":30,\"openAndWaitlistedSections\":null,\"searchResultsView\":\"CatalogListing\"}"}

    payload3 = {"searchParameters":
                   "{\"keyword\":null,\"terms\":[\"23/SPWZ\"],\"requirement\":null,\"subrequirement\":null,"
                   "\"courseIds\":null,\"sectionIds\":null,\"requirementText\":null,\"subrequirementText\":\"\","
                   "\"group\":null,\"startTime\":null,\"endTime\":null,\"openSections\":null,\"subjects\":[\"CPS\"],"
                   "\"academicLevels\":[],\"courseLevels\":[],\"synonyms\":[],\"courseTypes\":[],\"topicCodes\":[],"
                   "\"days\":[\"1\",\"2\",\"3\",\"4\",\"5\"],\"locations\":[],\"faculty\":[],\"onlineCategories\":null,"
                   "\"keywordComponents\":[],\"startDate\":null,\"endDate\":null,\"startsAtTime\":null,"
                   f"\"endsByTime\":null,\"pageNumber\": {page_number},\"sortOn\":\"SectionName\","
                   "\"sortDirection\":\"Ascending\", "
                   "\"subRequirementText\":null,\"quantityPerPage\":30,\"openAndWaitlistedSections\":null,"
                   "\"searchResultsView\":\"SectionListing\"} "
               }

    r = requests.post(url=url, headers=headers, data=json.dumps(payload3), verify=False)
    print(r.content.decode(encoding='utf-8'))
    # 先保存后续在本地处理，不浪费时间，对这个cookie有心理阴影。
    with open(f'info/searchInfo_{page_number}.json', 'w+', encoding='utf-8') as file:
        file.write(r.content.decode(encoding='utf-8'))

# {"Term":{"Code":"23/SPWZ","Description":"Spring 2023 Wenzhou","StartDate":"\/Date(1676178000000)\/","EndDate":"\/Date(1685419200000)\/",
# "ReportingYear":2022,"Sequence":6,"ReportingTerm":"23/SPWZ","FinancialPeriod":0,"DefaultOnPlan":false,"IsActive":false,"ForPlanning":true,
# "RegistrationDates":[{"RegistrationStartDate":"\/Date(1668920400000)\/","RegistrationEndDate":"\/Date(1676869200000)\/",
# "PreRegistrationStartDate":"\/Date(1597896000000)\/","PreRegistrationEndDate":"\/Date(1597896000000)\/","AddStartDate":"\/Date(1676869200000)\/",
# "AddEndDate":"\/Date(1676869200000)\/","DropStartDate":"\/Date(1676955600000)\/","DropEndDate":"\/Date(1680840000000)\/",
# "DropGradeRequiredDate":"\/Date(1676955600000)\/","Location":""}],"FinancialAidYears":[],"SessionCycles":[],"YearlyCycles":[]},
# "Course":
#  {"Id":"6234","SubjectCode":"CPS","Number":"2231","MinimumCredits":4.00000,"MaximumCredits":null,"VariableCreditIncrement":null,"Ceus":null,"Title":"COMPUTER PROGRAMMING",
# "Description":"Fundamental computing and programming concerts; use of systems software; problem solving; design of algorithms using a high-level, object-oriented programming language.",
# "TermSessionCycle":"","TermYearlyCycle":"E","YearsOffered":"EVERY SEMESTER","TermsOffered":null,"LocationCodes":[],"IsPseudoCourse":false,
# "Requisites":[{"RequirementCode":"21207","IsRequired":true,"CompletionOrder":1,"CorequisiteCourseId":null,"IsProtected":false}],
# "EquatedCourseIds":["CPS_2231"],"LocationCycleRestrictions":[],"VerifyGrades":null,"ShowDropRoster":false},
# "TermDisplay":"Spring 2023 Wenzhou",
    # "CourseDescription":"Fundamental computing and programming concerts; use of systems software; problem solving; design of algorithms using a high-level, object-oriented programming language.",
    # "FacultyDisplay":[],"InstructorDetails":[],"DisplayOfficeHours":false,"AcademicLevel":"Undergraduate","AvailabilityStatusDisplay":"Open",
# "MeetingsDisplay":["Tuesday, Thursday 8:30 AM - 9:15 AM TBD (Lecture) ","Tuesday, Thursday 8:30 AM - 9:15 AM 9:15 AM - 10:15 AM TBD (Lecture) "],
# "MobileMeetingsDisplay":["T, Th 8:30-9:15 AM","2/13/2023 - 5/30/2023","TBD (LEC)","","T, Th 9:15-10:15 AM","2/13/2023 - 5/30/2023","TBD (LEC)",""],
# "DatesDisplay":"2/13/2023-5/30/2023","AvailabilityDisplay":"18 / 18 / 0",
# "CreditsDisplay":"4.00000 Credits","CourseTypesDisplay":[],"InstructionalMethodsDisplay":["Lecture","Lecture"],
# "Comments":"WENZHOU-KEAN STUDENTS ONLY.  CNAHS STUDENTS ONLY.",
# "BookstoreUrl":"https://kean.bncollege.com/webapp/wcs/stores/servlet/TBListView?cm_mmc=RI-_-732-_-1-_-A\u0026catalogId=10001\u0026storeId=24559\u0026langId=-1\u0026termMapping=Y\u0026courseXml=\u003c?xml version=\"1.0\" encoding=\"UTF-8\"?\u003e\u003ctextbookorder\u003e \u003ccourses\u003e\u003ccourse dept=\"CPS\" num=\"2231\" sect=\"W08\" term=\"23%2fSPWZ\"/\u003e\u003c/courses\u003e\u003c/textbookorder\u003e",
# "FormattedMeetingTimes":
    # [{"DaysOfWeekDisplay":"T/Th","StartTimeDisplay":"8:30 AM",
    # "EndTimeDisplay":"9:15 AM","InstructionalMethodDisplay":"Lecture","BuildingDisplay":"","RoomDisplay":"",
    # "DatesDisplay":"2/13/2023 - 5/30/2023","ShowTBD":false,"IsBuildingDisplayNullOrEmpty":true,"IsBuildingDisplayNullOrEmptyAndIsNotOnline":true,
    # "IsBuildingDisplayNullOrEmptyAndIsOnline":false,
    # "Days":[2,4],"EndDate":"\/Date(1685419200000)\/","EndTime":"09:15:00","Frequency":"W",
    # "InstructionalMethodCode":"LEC","Room":"*",
    # "StartDate":"\/Date(1676264400000)\/","StartTime":"08:30:00","IsOnline":false},
    # {"DaysOfWeekDisplay":"T/Th","StartTimeDisplay":"9:15 AM","EndTimeDisplay":"10:15 AM","InstructionalMethodDisplay":"Lecture","BuildingDisplay":"","RoomDisplay":"",
    # "DatesDisplay":"2/13/2023 - 5/30/2023","ShowTBD":false,"IsBuildingDisplayNullOrEmpty":true,
    # "IsBuildingDisplayNullOrEmptyAndIsNotOnline":true,"IsBuildingDisplayNullOrEmptyAndIsOnline":false,"Days":[2,4],
    # "EndDate":"\/Date(1685419200000)\/","EndTime":"10:15:00","Frequency":"W","InstructionalMethodCode":"LEC","Room":"*",
    # "StartDate":"\/Date(1676264400000)\/","StartTime":"09:15:00","IsOnline":false}],
# "IsNonTermOffering":false,"IsNonStandardDates":false,"FullTitleDisplay":"CPS*2231*W08 COMPUTER PROGRAMMING","SectionNameDisplay":"CPS*2231*W08",
# "SectionTitleDisplay":"COMPUTER PROGRAMMING","StartDateDisplay":"2/13/2023","EndDateDisplay":"5/30/2023","LocationDisplay":"WENZHOU-KEAN UNIVERSITY",
# "LocationCode":"W","HasUnlimitedSeats":false,"SpecialIconPath":"/Content/Images/","AdditionalFeesApply":false,"HasCustomSpecialIcon":false,"AllowAudit":true,
# "AllowPassNoPass":false,"Available":18,"Books":[],"Capacity":18,"Ceus":null,"CourseId":"6234","EndDate":"\/Date(1685419200000)\/","Id":"256396","IsActive":true,
# "Location":"W","MaximumCredits":null,"AvailabilityStatus":0,"Meetings":[{"InstructionalMethodCode":"LEC","StartTime":"\/Date(1669815000000)\/",
# "EndTime":"\/Date(1669817700000)\/","Days":[2,4],"Room":"*","StartDate":"\/Date(1676264400000)\/","EndDate":"\/Date(1685419200000)\/","Frequency":"W",
# "IsOnline":false},{"InstructionalMethodCode":"LEC","StartTime":"\/Date(1669817700000)\/","EndTime":"\/Date(1669821300000)\/","Days":[2,4],"Room":"*",
# "StartDate":"\/Date(1676264400000)\/","EndDate":"\/Date(1685419200000)\/","Frequency":"W","IsOnline":false}],"PrimarySectionMeetings":[],
# "MinimumCredits":4.00000,"Number":"W08","OnlyPassNoPass":false,"OverridesCourseRequisites":false,"Requisites":[],"StartDate":"\/Date(1676264400000)\/",
# "TermId":"23/SPWZ","Title":"COMPUTER PROGRAMMING","VariableCreditIncrement":null,"WaitlistAvailable":false,"Waitlisted":0,"CourseName":"CPS*2231",
# "Synonym":"26488","ShowWaitlistInfo":false,"ShowSpecialIcon":false}