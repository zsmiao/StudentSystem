package xyz.itclay.studentsystem;

import xyz.itclay.studentsystem.util.Student_jdbc;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import static xyz.itclay.studentsystem.Options.*;

public class Login {
    public static void loginIn() throws Exception {
        Student_jdbc.connectionDatabase();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] vc = new int[4];
        int count = 3;
        String USER_LOGIN = " select  * from  tb_User WHERE username=? and pwd=?";
        while (true) {
            if (count == 0) {
                break;
            } else {
                System.out.println("********User login********");
                System.out.print("login as:");
                String user = scanner.next();
                System.out.print("password:");
                String pwd = scanner.next();
                String s = "";
                for (int i = 0; i < vc.length; i++) {
                    int i1 = random.nextInt(9);
                    vc[i] = i1;
                }
                for (int i = 0; i < vc.length; i++) {
                    int b = vc[i];
                    s = s + s.valueOf(b);
                }
                System.out.println("验证码:" + s);
                System.out.print("请输入验证码:");
                String s1 = scanner.next();
                PreparedStatement ps = Student_jdbc.conn.prepareStatement(USER_LOGIN);
                ps.setString(1, user);
                ps.setString(2, pwd);
                ResultSet resultSet = ps.executeQuery();
                if (s.equals(s1) && resultSet.next()) {
                    System.out.println("登录成功！");
                    Options.options();
                    break;
                } else {
                    System.out.println("登录失败，您还有" + (count - 1) + "次登录机会！");
                    count--;
                }
            }
        }
    }
}
