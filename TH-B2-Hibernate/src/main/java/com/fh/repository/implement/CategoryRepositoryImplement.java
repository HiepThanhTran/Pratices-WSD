package com.fh.repository.implement;

import com.fh.pojo.Category;
import com.fh.repository.CategoryRepository;
import com.fh.utils.Hibernate;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepositoryImplement implements CategoryRepository {
    @Override
    public List<Category> getCategories() {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            Query q = session.createQuery("from Category", Category.class);

            return q.getResultList();
        }
    }
}
