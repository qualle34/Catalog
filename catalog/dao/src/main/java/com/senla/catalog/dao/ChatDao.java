package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.IChatDao;
import com.senla.catalog.entity.Chat;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

@Repository
public class ChatDao extends AbstractDao<Chat, Integer> implements IChatDao {

    private static final Logger logger = LoggerFactory.getLogger(ChatDao.class);

    @Autowired
    private Session session;

    @Override
    protected Class getChildClass() {
        return ChatDao.class;
    }

    @Override
    protected Class<Chat> getEntityClass() {
        return Chat.class;
    }

    @Override
    protected Session getSession() {
        return session;
    }

    @Override
    public Chat getWithMessagesById(int id) {

        Chat chat;
        CriteriaBuilder cb;
        CriteriaQuery query;
        Root root;

        try {
            cb = session.getCriteriaBuilder();
            query = cb.createQuery(Chat.class);
            root = query.from(Chat.class);

            root.fetch("messageList", JoinType.LEFT);
            query.select(root)
                    .where(cb.equal(root.get("id"), id));

            chat = (Chat) this.session.createQuery(query).getSingleResult();

        } catch (RuntimeException e) {
            logger.error("" + e.getMessage());
            throw e;
        }
        return chat;
    }

    @Bean
    public ChatDao getInstance() {
        return new ChatDao();
    }
}
