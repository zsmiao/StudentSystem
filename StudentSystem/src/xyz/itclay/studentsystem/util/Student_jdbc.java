package xyz.itclay.studentsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private static final String ADD_STUDENT = "insert  into tb_Student(Student_Id,Student_Name,Student_Sex,Grade,Classe,Major_Name,Department_Name) values (?,?,?,?,?,?,?)";
    private static final String DELETE_STUDENT = "delete from tb_Student where Student_Id=?";
    private static final String UPDATE_STUDENT = "update tb_Student set Student_Name=?,Student_Sex=?,Grade=?,Classe=?,Major_Name=?,Department_Name=? where Student_Id=?";
    private static final String SHOW_STUDENT = " select  * from  tb_Student WHERE Student_Id=?";
    private static final String SHOWALL_STUDENT = "select * from tb_Student;";

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
        PreparedStatement ps = conn.prepareStatement(ADD_STUDENT);
        ps.setString(1, stuId);
        ps.setString(2, stuName);
        ps.setString(3, stuSex);
        ps.setInt(4, stuGrade);
        ps.setInt(5, stuClass);
        ps.setString(6, stuMajor);
        ps.setString(7, stuDepart);
        if (ps.executeUpdate() > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    /**
     * 删除学生信息
     */
    public static void remove() throws Exception {
        System.out.println("**********删除学生信息***********");
        System.out.print("请输入要删除学生的学号>>>>>");
        String stuID = scanner.next();
        PreparedStatement ps = conn.prepareStatement(DELETE_STUDENT);
        ps.setString(1, stuID);
        if (ps.executeUpdate() > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    /**
     * 更改学生信息
     */
    public static void updata() throws Exception {
        System.out.println("**********更改学生信息***********");
        System.out.println("请输入要更改学生的学号>>>>>");
        String stuId = scanner.next();
        System.out.print("请输入要更改学生的姓名>>>>>");
        String stuName = scanner.next();
        System.out.print("请输入要更改学生的性别>>>>>");
        String stuSex = scanner.next();
        System.out.print("请输入要更改学生的年级>>>>>");
        int stuGrade = scanner.nextInt();
        System.out.print("请输入要更改学生的班级>>>>>");
        int stuClass = scanner.nextInt();
        System.out.print("请输入要更改学生的专业>>>>>");
        String stuMajor = scanner.next();
        System.out.print("请输入要更改学生的学校>>>>>");
        String stuDepart = scanner.next();
        PreparedStatement ps = conn.prepareStatement(UPDATE_STUDENT);
        ps.setString(7, stuId);
        ps.setString(1, stuName);
        ps.setString(2, stuSex);
        ps.setInt(3, stuGrade);
        ps.setInt(4, stuClass);
        ps.setString(5, stuMajor);
        ps.setString(6, stuDepart);
        if (ps.executeUpdate() > 0) {
            System.out.println("更改成功！");
        } else {
            System.out.println("更改失败！");
        }

    }

    public static void show() throws Exception {
        System.out.println("**********查询学生信息***********");
        System.out.print("请输入要查询学生的学号>>>>>");
        String stuId = scanner.next();
        PreparedStatement ps = conn.prepareStatement(SHOW_STUDENT);
        ps.setString(1, stuId);
        ResultSet resultSet = ps.executeQuery();
        System.out.println("**********查询结果***********");
        System.out.println("学号\t\t  姓名\t性别\t 年级\t班级\t 专业\t\t学校");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "  " +
                    resultSet.getString(2) + " \t" +
                    resultSet.getString(3) + " \t " +
                    resultSet.getString(4) + " \t " +
                    resultSet.getString(5) + " \t " +
                    resultSet.getString(6) + "\t" +
                    resultSet.getString(7));
        }
        resultSet.close();
    }

    public static void showAll() throws Exception {
        System.out.println("**********所有学生信息***********");
        PreparedStatement ps = conn.prepareStatement(SHOWALL_STUDENT);
        ResultSet resultSet = ps.executeQuery();
        System.out.println("**********查询结果***********");
        System.out.println("学号\t\t  姓名\t性别\t 年级\t班级\t 专业\t\t学校");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "  " +
                    resultSet.getString(2) + " \t" +
                    resultSet.getString(3) + " \t " +
                    resultSet.getString(4) + " \t " +
                    resultSet.getString(5) + " \t " +
                    resultSet.getString(6) + "\t" +
                    resultSet.getString(7));
        }
        resultSet.close();
    }
}
