package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Repository
public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    @Autowired
    private Session session;

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public Chat getWithMessagesById(int id) {

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Chat> query = cb.createQuery(Chat.class);
            Root<Chat> root = query.from(Chat.class);

            root.fetch("messageList", JoinType.LEFT);
            query.select(root).where(cb.equal(root.get("id"), id));

            return session.createQuery(query).getSingleResult();

        } catch (HibernateException e) {
            throw e;
        }
    }
}
