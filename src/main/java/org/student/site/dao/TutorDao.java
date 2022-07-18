package org.student.site.dao;

import org.springframework.stereotype.Component;
import org.student.site.models.HibernateSessionFactory;
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
}
