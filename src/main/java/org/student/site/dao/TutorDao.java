package org.student.site.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.student.site.models.HibernateSessionFactory;
import org.student.site.models.Student;
import org.student.site.models.Tutor;

import java.util.List;

@Component
public class TutorDao {
    public List<Tutor> getAllTutors(){
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Tutor").list();
    }
    public Tutor getTutorById(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Tutor.class, id);
    }
    public void addTutor(Tutor tutor){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(tutor);
        transaction.commit();
        session.close();
    }
}
