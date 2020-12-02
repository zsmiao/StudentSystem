package xyz.itclay.studentsystem;

import xyz.itclay.studentsystem.util.Student_jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Registration {
    public static void registration() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String adduser = "insert into tb_User(username,pwd) values (?,?)";
        lo:
        while (true) {
            System.out.println("********用户注册********");
            System.out.print("请输入用户名>>>>>");
            String user = scanner.next();
            System.out.print("请输入密码>>>>>");
            String pwd = scanner.next();
            System.out.println("请再次确认密码>>>>>");
            String pwd1 = scanner.next();
            if (pwd.equals(pwd1)) {
                PreparedStatement ps = Student_jdbc.conn.prepareStatement(adduser);
                ps.setString(1, user);
                ps.setString(2, pwd);
                if (ps.executeUpdate() > 0) {
                    System.out.println("注册成功！");
                    l1:
                    while (true) {
                        System.out.println("注册成功，请继续您要办理的业务！");
                        System.out.println("1.返回");
                        System.out.println("0.退出");
                        System.out.print("请选择>>>>>");
                        int input = scanner.nextInt();
                        switch (input) {
                            case 0:
                                System.out.println("退出成功！！！");
                                break;
                            case 1:
                                Login.loginIn();
                                break;
                            default:
                                System.out.println("您的选择有误，请重新选择！");
                                continue l1;
                        }
                        break;
                    }
                } else {
                    System.out.println("注册失败,请重试！");
                    continue;
                }
            } else {
                System.out.println("您的两次密码输入不一致，请重新注册！");
                continue;
            }
            break;
        }
    }
}
