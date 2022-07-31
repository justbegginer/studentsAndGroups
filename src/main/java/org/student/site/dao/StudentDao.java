package org.student.site.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.student.site.models.Group;
import org.student.site.models.HibernateSessionFactory;
import org.student.site.models.Student;

import java.util.List;

@Component
public class StudentDao {
    public List<Student> getAllStudents() {
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Student").list();
    }

    public Student getStudentById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }

    public void addStudent(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void deleteStudent(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getStudentById(id));
        transaction.commit();
        session.close();
    }

    public void updateStudent(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public List<Student> searchByString(String string) {
        return HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Student student WHERE  student.name = '" + string + "' or student.surname = '" + string + "'")
                .list();
    }
}
