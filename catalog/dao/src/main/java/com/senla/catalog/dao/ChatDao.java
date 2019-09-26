package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Repository
public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    public Chat getWithMessagesById(int id) {

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Chat> query = cb.createQuery(Chat.class);
            Root<Chat> root = query.from(Chat.class);

            root.fetch("messageList", JoinType.LEFT);
            query.select(root).where(cb.equal(root.get("id"), id));

            return entityManager.createQuery(query).getSingleResult();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
