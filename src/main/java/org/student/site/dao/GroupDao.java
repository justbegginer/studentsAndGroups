package org.student.site.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.student.site.models.Group;
import org.student.site.models.HibernateSessionFactory;
import org.student.site.models.Student;

import java.util.List;

@Component
public class GroupDao {
    public List<Student> getAllGroups(){
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Group").list();
    }
    public Group getGroupById(int id){
        return HibernateSessionFactory.getSessionFactory().openSession().get(Group.class, id);
    }
    public void addGroup(Group group){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(group);
        transaction.commit();
        session.close();
    }
}
