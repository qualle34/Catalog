package com.senla.catalog.dao;

import com.senla.catalog.dao.basic.AbstractDao;
import com.senla.catalog.daoapi.ICategoryDao;
import com.senla.catalog.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryDao extends AbstractDao<Category, Integer> implements ICategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    public List<Category> getByTitle(String title) {
        Query query = entityManager.createQuery("SELECT c FROM Category c WHERE c.title LIKE :title ", Category.class);
        query.setParameter("title", "%" + title + "%");

        return query.getResultList();
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("DELETE FROM Category c WHERE c.id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
