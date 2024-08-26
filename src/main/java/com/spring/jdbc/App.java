package com.spring.jdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started...." );
        //for the xml file this implementation will be needed
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
//        JdbcTemplate template = (JdbcTemplate)context.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        String query = "insert into student(id,name,city) values(?,?,?)";
//        
//        int result = template.update(query,2,"Sahil Borole","Bhusawal");
//        System.out.println("No. of Rows affected "+result);
        
        StudentDao studentimp = (StudentDao)context.getBean("studentDao",StudentDao.class);
        
//        Student student = new Student(3,"karn surya","rajputra");
//        int r = studentimp.insert(student);
//        System.out.println(r);
        
//        Student student = new Student(3,"Arjun Abhimanyu","Rajputra");
//        int res = studentimp.change(student);
//        System.out.println(res);
        
//        Student stuent = new Student();
//        int res = studentimp.delete(3);
//        System.out.println(res);
        
//        Student student = studentimp.getStudent(2);
//        System.out.println(student);
//        
        List<Student>list = studentimp.getAllStudent();
        System.out.println(list);
        
    }
}
