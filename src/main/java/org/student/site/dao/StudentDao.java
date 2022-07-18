package org.student.site.dao;

import org.springframework.stereotype.Component;
import org.student.site.models.HibernateSessionFactory;
import org.student.site.models.Student;

import java.util.List;

@Component
public class StudentDao {
    public List<Student> getAllStudents(){
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Student").list();
    }
    public Student getStudentById(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }
}
