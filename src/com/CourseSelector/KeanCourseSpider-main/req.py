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
    '__RequestVerificationToken':'16vwxYdS6Ugp-00v7SneftlbQcLMlSaGhjzbSf3C30a-LR98RR5QEjJPD7biuizmH6tqkYysUeWSA7Bg1faFdydnCjGKIXJclG9zP1EfFos8q6ZSFJhZtSfqqEzXlv-k9_srxEp9GRZ5SyY9qVFDkQ2',
    'Accept': 'application/json, text/javascript, */*; q=0.01',
    'Accept-Encoding': 'gzip, deflate, br',
    'Accept-Language': 'en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7',
    'Connection': 'keep-alive',
    'Content-Length': '751',
    'Content-Type': 'application/json, charset=UTF-8',
    'Cookie': '_gid=GA1.2.1610692491.1669398442; _gcl_au=1.1.207627324.1669452735; _ga=GA1.2.1190905544.1629033682; BE_CLA3=p_id=R4NA626J4J84R8LJLP82JP8NAAAAAAAAAH&bf=5789af93a85e8fae9f7ce435f00ad81e&bn=2&bv=3.44&s_expire=1669548069473&s_id=R4NA626J4J84R2P8LA62JP8NAAAAAAAAAH; _ga_HN53Y9FJJ9=GS1.1.1669461020.2.1.1669462896.0.0.0; __RequestVerificationToken_L1N0dWRlbnQ1=jjXx7HCrWXVebd_Dc39EeRJKcV51UwKfOKvWvjFyUqAjNtZ2eh_DdJqn170glblcA03DdA92bcg4M_d_swItqeLBlzoH6jDwaK0hFn4gLOs1; studentselfservice_production_sfid=C08E81983Y22; studentselfservice_production_AuthMethod=Forms; studentselfservice_production_0=6327A4FEC9B710EFC1858327FAA77DFE018CAC3D316C32722F0A58D50B26F93545FBC68B7645AF9EF4B71F5BD8574DDCCB5374899FB497DB0ABFA63F7812ABBD8FF98E2CA25738312A19DA554A0512BB47CC553E6835819CEA05932C0C39945259216300B8E49B3E5D7D73B351627B6B7F33614FC714B10635B45C821CDCBEDA3580CDE67EF3FC9048152A8C5944751F223D3EF5231036DB1A3D90AF6F9DF3E83717950A8841D8408AC29C0D22044067065BF04244CF04CFCCCE48298D2D6473C0E9DC3CC572AE21B920BB1DE7DBCD17256D53441CC45993BF524BD7850312566E37C46141C8A47E3E235FB28E0DBE40D09733D57E25CD6289F22AF468ADDDD8CB493C60665744FFD0C74DC869B780E9A62E2071DF5E4BA7EA01D2A5984D58738CA85E2E3881652DCDEC0B9AED5D9CF0087ACD996C2B0E04218C6020054FE008B2E1D44A7F2617167665FEC0157D3925B8A0090AF30136BA45B32A7857CDA96D4F2415661EB0729617A8055D74D4054967892049EC272105E26303832A96D01EA2368166EDEFFFF1F7D01479B4E1F29BF0305B80836037252F7958493028D9DA1CC9FEDE5B018C4B29F3E1F2F0DBFE22BE29C27DA3EC08743BF3646F1E62640BEB21FAD7E2BF449D0BB5D8A42CC2EB4EB35C6D634DAFA54FE13677EF37CF7C2BB8B29CC9F201C3E44BF58B40193EA47A33EA42E70E41F197D68FCBA0E353586DF054AB36F257B50B55555C753C16FDFE51C68F21A617591F51A0DD4AB21F42E46DCB474F14FC2FC635C25692FE4971F0F8DCE88BEF27CF276BEA85FC6671B8432E578516E0A0678FB2D04AAC20E45E58B8FFCD488712ABFFEDC07E3AE268B8FEEAF15299408D05837398A4585E3E97EF50BFFFE85331205E7D730BE7BFA42F11E72DAE364865D9DB815E2F04DF06A0BEBAE49AC86C1416D141BED2ABB715E4AC681EF06961CBFBEDCEE0F4084736CB76ADD9B664CD88DB9BC3DD3CC50774CF749F80EBA1B5FC46581F6C203D62726CB098BED245FF119779677D81BB653B81165381AD5BF552A7F81FD58B430CD8A99D6E5FA3672CB8884744ECC8735F44A7272FBF14BBBC5F06A5CB9B753C6B1A8052DC6D1189EE344019E6F62F8BB10228EEB7F4DAFF828852A6C7645131C92EC3CC8C728C251E8EECA6A8944128F0F86FE7',
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
    payload = {"searchParameters":"{\"keyword\":null,\"terms\":[],\"requirement\":null,\"subrequirement\":null,\"courseIds\":null,\"sectionIds\":null,\"requirementText\":null,\"subrequirementText\":\"\",\"group\":null,\"startTime\":null,\"endTime\":null,\"openSections\":null,\"subjects\":[],\"academicLevels\":[],\"courseLevels\":[],\"synonyms\":[],\"courseTypes\":[],\"topicCodes\":[],\"days\":[],\"locations\":[],\"faculty\":[],\"onlineCategories\":null,\"keywordComponents\":[],\"startDate\":null,\"endDate\":null,\"startsAtTime\":null,\"endsByTime\":null,\"pageNumber\":1,\"sortOn\":\"SectionName\",\"sortDirection\":\"Ascending\",\"subRequirementText\":null,\"quantityPerPage\":30,\"openAndWaitlistedSections\":null,\"searchResultsView\":\"SectionListing\"}"}

    r = requests.post(url=url, headers=headers, data=json.dumps(payload), verify=False)
    print(r.content.decode(encoding='utf-8'))
    # 先保存后续在本地处理，不浪费时间，对这个cookie有心理阴影。
    with open(f'info/searchInfo_{page_number}.json', 'w+', encoding='utf-8') as file:
        file.write(r.content.decode(encoding='utf-8'))
