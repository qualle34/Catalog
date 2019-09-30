package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Advert;
import com.senla.catalog.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CommentDao extends AbstractDao<Comment, Integer> implements ICommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }


    @Override
    public List<Comment> getByAdvert(Advert advert) {

        try {
            Query query = entityManager.createQuery("from Comment where advert = :advert ");
            query.setParameter("advert", advert);

            return query.getResultList();

        } catch (RuntimeException e) {
            throw e;
        }
    }
}
