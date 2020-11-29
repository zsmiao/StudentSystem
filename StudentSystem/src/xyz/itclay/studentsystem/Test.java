package xyz.itclay.studentsystem;

import xyz.itclay.studentsystem.util.Student_jdbc;

public class Test {
    public static void main(String[] args) throws Exception {
        Student_jdbc.connectionDatabase();
        Student_jdbc.add();
        Student_jdbc.conn.close();
    }
}
