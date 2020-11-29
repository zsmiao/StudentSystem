package xyz.itclay.studentsystem.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties drive() throws Exception{
        File file=new File("E:\\IdeaProject\\StudentSystem\\StudentSystem\\src\\xyz\\itclay\\studentsystem\\util\\database.properties");
        FileInputStream fileInputStream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(fileInputStream);
        return properties;
    }
}
