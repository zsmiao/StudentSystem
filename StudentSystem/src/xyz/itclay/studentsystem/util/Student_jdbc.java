package xyz.itclay.studentsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Student_jdbc {
    public static Connection conn;
    static Scanner scanner = new Scanner(System.in);
    /**
     * 定义SQL语句
     */
    private static final String ADD_STUDENT = "insert  into StudentSystem(Student_Id,Student_Name,Student_Sex,Grade,Classe,Major_Name,Department_Name) values (?,?,?,?,?,?,?)";
    /**
     * 连接数据库的方法
     */
    public static void connectionDatabase() throws Exception {
        String driver = PropertiesUtil.drive().getProperty("DRIVER");
        String url = PropertiesUtil.drive().getProperty("URL");
        String user = PropertiesUtil.drive().getProperty("USER");
        String pwd = PropertiesUtil.drive().getProperty("PWD");
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, pwd);
        System.out.println("数据库连接成功！！！");

    }

    /**
     * 通过控制台向数据库中添加学生信息
     */
    public static void add() throws Exception {
        //学号、姓名、性别、年级、班级、专业、学校
        System.out.println("**********添加学生信息***********");
        System.out.print("请输入要添加学生的学号>>>>>");
        String stuId = scanner.next();
        System.out.print("请输入要添加学生的姓名>>>>>");
        String stuName = scanner.next();
        System.out.print("请输入要添加学生的性别>>>>>");
        String stuSex = scanner.next();
        System.out.print("请输入要添加学生的年级>>>>>");
        int stuGrade = scanner.nextInt();
        System.out.print("请输入要添加学生的班级>>>>>");
        int stuClass = scanner.nextInt();
        System.out.print("请输入要添加学生的专业>>>>>");
        String stuMajor = scanner.next();
        System.out.print("请输入要添加学生的学校>>>>>");
        String stuDepart = scanner.next();
        //通过SQL语句实现插入操作
        PreparedStatement ps=conn.prepareStatement(ADD_STUDENT);
        ps.setString(1,stuId);
        ps.setString(2,stuName);
        ps.setString(3,stuSex);
        ps.setInt(4,stuGrade);
        ps.setInt(5,stuClass);
        ps.setString(6,stuMajor);
        ps.setString(7,stuDepart);
        if(ps.executeUpdate()>0){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    public static void main(String[] args) throws Exception {
        Student_jdbc.connectionDatabase();
        Student_jdbc.add();
        conn.close();
    }
}
