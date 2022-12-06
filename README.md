# course-selectSystem
 2232FinalProject
## 运行起来是什么样的

1. 运行
````
选课系统
选择下列选项
1. 浏览课程表
2. 浏览当前购物车
````
````
1.浏览课程表
--------
选择如何排序
1.按照level排序
2.按照学分排序
3.按照可用位置排序
4.按照时间排序
--------
````
````
1. 浏览课程表(Level)
-------
1. term:23/SPWZ|Course: CPS*2231-W05|Instructor:Ken|availableSeats:10 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
2. term:23/SPWZ|Course: CPS*2390-W05|Instructor:baha|availableSeats:12 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
3. term:23/SPWZ|Course: CPS*3520-W01|Instructor:Abuajia|availableSeats:5 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
4. term:23/SPWZ|Course: CPS*2231-W05|Instructor:Ken|availableSeats:5 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
5. term:23/SPWZ|Course: CPS*2231-W05|Instructor:Ken|availableSeats:0 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
-------
0.上一页 1.下一页 2.加入将序号（）加入课程购物车 3.进入课程购物车 4.返回首页
````

````
2.浏览当前购物车
-------
1. term:23/SPWZ|Course: CPS*2231-W05|Instructor:Ken|availableSeats:10 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
2. term:23/SPWZ|Course: CPS*2390-W05|Instructor:baha|availableSeats:12 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
3. term:23/SPWZ|Course: CPS*3520-W01|Instructor:Abuajia|availableSeats:5 | Date: 2023.2.14-2023.6.30 | days:1,3 | time: 7:00-8:15
-------
当前购物车学分：9 
1. 删除序号（）课程 2.浏览课程表 3.返回首页
````

## 整体结构的初步构想
- data文件夹
  - course存放课程相关 info为各节课对象序列化存储的文件夹
  - User为用户文件夹
    - Faculty 教师对象存放
    - Student 学生对象存放
      - students
    - shopping cart 购物车
1. 实现Course, Faculty, Student, Shoping cart序列化
   1. 实现4个类的toString方法
   2. 实现类内存储与读取（即序列化和反序列化）
2. 完善Faculty类
   1. 若课程涉及此教师，则教师所上的课便加上这一课程。
3. 完善购物车系统（可以用linklist存，这样就是按照存入顺序输出。.contain也是有的）
   1. 实现时间冲突选项
      1. Data数据的完善
         - 分别为Start Day End Day 作为起止日期
         - Days[]一维数组保存周几上课
         - StartTime EndTime 保存具体上下课时间（通常为第一节课的时间）
   2. 实现学分检测
   3. 实现检测是否完成前置课程
   4. 检测是否是本年级学生课程
   5. 实现课程容量检测（这个放到course里实现，学生+1就-1可用）
   6. Optional:注册与选择分离
4. 课程预览
   1. 将所有课程实例化
   2. 考虑用什么存储课程（课程很多，如何读取和输出最快，按照什么排序）
   3. 多种类搜索（自定义搜索）
      1. 限定时间，学分，教师
   4. 多种类排序（自定义排序）
      1. 按照时间，学分，课程ID，课程编号
   5. 特殊化ADT，如BST
## 新增 12.04
- 将course所有方法实现调用course对象序列化存储
- 构建course调用反序列化，如果不存在则创建一个新的对象，存在则读取反序列化中的对象
- 将linklist复写，新写方法如重新排序，按....来
- 购物车作为一个linklist可以存入course类的对象
  - 在浏览课程列表时，可以将课程列表中即Arraylist中的对象存入购物车中即Linklist
  - 实现linklist的toString输出。
### 流程相关
1. （独立的）将Json字符串转换为java对象，通过序列化存入course/information/"code".text
   1. 也就是说 将全部导入的 java对象 本地化 保存在 文件夹里。（这个文件夹就相当于我们的数据库）
2. 运行程序，建立一个购物车，并保存至当前学生的这个对象中。
3. 下一步是如何浏览所有课程，建立一个arraylist或者其他链表，分别将部分课程反序列化成对象加入这个链表中，然后输出
   1. 记录最后一个反序列化的课程对象的code。
   2. 当用户输入next page（也可以是数字代替）将储存的这个code+1循环 后面5个或者10个课程再次反序列化加入链表中，输出
   3. 以上部分实现了如何预览课程
   4. 如何选择课程？
      1. 这些课程序列化之后存入了这个链表中，当用户输入了第几个号码也就是第几个课程，将这个课程加入用户的购物车linklist中
      2. 这样就完成了课程的加入
4. 完成了课程选择和浏览之后，学生需要访问自己的课表购物车，于是可以调用课表购物车的toString方法
   1. 对已选课表中的课程进行更改，比如删除。
   2. 还想再要添加新课程就重新回到第三步。

## version1
![](Picture/outline.jpg)