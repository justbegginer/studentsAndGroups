package org.student.site.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.student.site.models.*;

import java.util.List;

@Component
public class GroupDao {
    public List<Student> getAllGroups() {
        return HibernateSessionFactory.getSessionFactory().openSession().createQuery("FROM Group").list();
    }

    public Group getGroupById(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Group.class, id);
    }

    public void addGroup(Group group) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(group);
        transaction.commit();
        session.close();
    }

    public void deleteGroup(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getGroupById(id));
        transaction.commit();
        session.close();
    }

    public void updateGroup(Group group) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(group);
        transaction.commit();
        session.close();
    }

    public List<Group> searchById(int id) {
        Query query = HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Group WHERE id = :id or tutorId = :id");
        query.setParameter("id", id);
        return query.list();
    }

    public CompleteGroup getCompleteGroupById(int id) {
        CompleteGroup completeGroup = new CompleteGroup(getGroupById(id),
                new TutorDao().findTutorByGroupId(id), new StudentDao().findStudentByGroupNumber(id));
        return completeGroup;
    }
}
