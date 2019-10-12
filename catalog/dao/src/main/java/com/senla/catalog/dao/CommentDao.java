package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICommentDao;
import com.senla.catalog.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CommentDao extends AbstractDao<Comment, Long> implements ICommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public List<Comment> getByAdvertId(long advertId) {
        Query query = entityManager.createQuery("SELECT c FROM Comment c WHERE c.advert.id = :advertId ", Comment.class);
        query.setParameter("advertId", advertId);

        return query.getResultList();
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM Comment c WHERE c.id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
