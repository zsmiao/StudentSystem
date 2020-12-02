package xyz.itclay.studentsystem;

import xyz.itclay.studentsystem.util.Student_jdbc;

import java.util.Scanner;

public class Begin {
    public static void begin() throws Exception {
        Student_jdbc.connectionDatabase();
        Scanner scanner = new Scanner(System.in);
        lo:
        while (true) {
            System.out.println("**********学生信息管理系统**********");
            System.out.println("1.立即登录");
            System.out.println("2.用户注册");
            System.out.println("3.密码找回");
            System.out.println("0.退出系统");
            System.out.print("请选择>>>>>");
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    System.out.println("退出成功！");
                    break;
                case 1:
                    Login.loginIn();
                    break;
                case 2:
                    Registration.registration();
                    break;
                case 3:
                    Recover.recover();
                    break;
                default:
                    System.out.println("您的选择有误，请您重新输入！");
                    continue lo;
            }
            break;
        }
    }
}