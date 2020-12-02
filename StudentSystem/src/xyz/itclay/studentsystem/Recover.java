package xyz.itclay.studentsystem;

import xyz.itclay.studentsystem.util.Student_jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Recover {
    public static void recover() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] code = new int[4];
        String findUserName = "select * from tb_User where username=?";
        System.out.println("**********密码找回**********");
        System.out.print("请输入用户名>>>>>>");
        String username = scanner.next();
        String s = "";
        for (int i = 0; i < code.length; i++) {
            int i1 = random.nextInt(9);
            code[i] = i1;
        }
        for (int i = 0; i < code.length; i++) {
            int b = code[i];
            s = s + s.valueOf(b);
        }
        System.out.println("验证码:" + s);
        System.out.print("请输入验证码>>>>>");
        String codes = scanner.next();
        if (!s.equals(codes)) {
            System.out.println("您的输入有误！");
        } else {
            PreparedStatement ps = Student_jdbc.conn.prepareStatement(findUserName);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println("您的密码为:" + resultSet.getString(2));
            }
            resultSet.close();
            lo:
            while (true) {
                System.out.println("您的密码找回成功，请继续您要办理的业务！");
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
                        continue lo;
                }
                break ;
            }
        }
    }
}
