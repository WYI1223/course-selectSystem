package com.course.UI;

/**
 * 生成项目中所有的菜单
 */
public class Menu {
    //主界面
    public void mainMenu() {
        System.out.println("***********************************");
        System.out.println("**    1 Browse class schedule    **");
        System.out.println("**    2  Browse current cart     **");
        System.out.println("***********************************");
    }

    //课程表界面
    public void courseMenuByLevel() {
        System.out.println("*************************");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("*************************");
    }

    //课程表界面
    public void courseMenuByCredit() {
        System.out.println("*************************");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("*************************");
    }

    //课程表界面
    public void courseMenuByAvailableSeat() {
        System.out.println("*************************");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("*************************");
    }

    //课程表界面
    public void courseMenuByTime() {
        System.out.println("*************************");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("**                     **");
        System.out.println("*************************");
    }

    //查找界面
    public void searchMenu () {
        System.out.println("*********************************************");
        System.out.println("**      1. Sort by level                   **");
        System.out.println("**      2. Sort by credits                 **");
        System.out.println("**      3. Sort by available seat          **");
        System.out.println("**      4. Sort by time                    **");
        System.out.println("*********************************************");
    }

    //修改界面
    public void modifyMenu () {
        System.out.println("*************************");
        System.out.println("**      1 查看全记录      **");
        System.out.println("**      2 修改指定记录    **");
        System.out.println("**      3 返回上一级      **");
        System.out.println("*************************");
    }
    //修改子界面
    public void subModifyMenu () {
        System.out.println("*************************");
        System.out.println("**      1 修改姓名       **");
        System.out.println("**      2 修改年龄       **");
        System.out.println("**      3 修改性别       **");
        System.out.println("**      4 修改号码       **");
        System.out.println("**      5 修改住址       **");
        System.out.println("**      6 返回上一级     **");
        System.out.println("*************************");
    }

    //删除界面
    public void deleteMenu () {
        System.out.println("*************************");
        System.out.println("**      1 查看全记录      **");
        System.out.println("**      2 删除指定记录    **");
        System.out.println("**      3 删除全部记录    **");
        System.out.println("**      4 返回上一级      **");
        System.out.println("*************************");
    }
    //排序界面
    public void orderMenu () {
        System.out.println("*************************");
        System.out.println("**      1 按姓名排序      **");
        System.out.println("**      2 按年龄排序      **");
        System.out.println("**      3 按性别排序      **");
        System.out.println("**      4 查看全部记录    **");
        System.out.println("**      5 返回上一级      **");
        System.out.println("*************************");
    }
}
