package xyz.itclay.studentsystem;

import xyz.itclay.studentsystem.util.Student_jdbc;

import java.util.Scanner;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Student_jdbc.connectionDatabase();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("**********学生信息管理系统***********");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.查看学生信息");
            System.out.println("5.查看所有学生信息");
            System.out.println("0.退出系统");
            System.out.print("请选择您要操作的选项>>>>>");
            int input = scanner.nextInt();
            if (input == 0) {
                System.out.println("感谢使用！！！");
                break;
            } else if (input == 1) {
                Student_jdbc.add();
            } else if (input == 2) {
                Student_jdbc.remove();
            } else if (input == 3) {
                Student_jdbc.updata();
            } else if (input == 4) {
                Student_jdbc.show();
            } else if (input == 5) {
                Student_jdbc.showAll();
            } else {
                System.out.println("您的输入有误！");
            }
        }
        Student_jdbc.conn.close();
    }
}
