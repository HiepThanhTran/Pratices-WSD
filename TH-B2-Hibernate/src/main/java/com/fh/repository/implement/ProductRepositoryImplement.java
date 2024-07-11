package com.fh.repository.implement;

import com.fh.pojo.Product;
import com.fh.repository.ProductRepository;
import com.fh.utils.Hibernate;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImplement implements ProductRepository {
    @Override
    public List<Product> getProducts(Map<String, String> params) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
            Root<Product> root = query.from(Product.class);
            query.select(root);

            if (params != null) {
                List<Predicate> predicates = new LinkedList<>();

                String kw = params.get("name");
                if (kw != null && !kw.isEmpty() && !kw.isBlank()) {
                    Predicate p1 = criteriaBuilder.like(root.get("name"), String.format("%%%s%%", kw));
                    predicates.add(p1);
                }

                String fromPrice = params.get("fromPrice");
                if (fromPrice != null && !fromPrice.isEmpty() && !fromPrice.isBlank()) {
                    Predicate p2 = criteriaBuilder.ge(root.get("price"), Double.parseDouble(fromPrice));
                    predicates.add(p2);
                }

                String toPrice = params.get("toPrice");
                if (toPrice != null && !toPrice.isEmpty() && !toPrice.isBlank()) {
                    Predicate p3 = criteriaBuilder.le(root.get("price"), Double.parseDouble(toPrice));
                    predicates.add(p3);
                }

                String categoryId = params.get("categoryId");
                if (categoryId != null && !categoryId.isEmpty() && !categoryId.isBlank()) {
                    Predicate p4 = criteriaBuilder.equal(root.get("category").get("id"), Integer.parseInt(categoryId));
                    predicates.add(p4);
                }

                query.where(predicates.toArray(Predicate[]::new));
            }

            Query q = session.createQuery(query);
            return q.getResultList();
        }
    }

    @Override
    public Product getProductById(int id) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }

    @Override
    public void addOrUpdate(Product product) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            if (product.getId() > 0) {
                session.merge(product);
            } else {
                session.persist(product);
            }
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteProduct(int id) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            Product product = this.getProductById(id);
            session.remove(product);
            session.getTransaction().commit();
        }
    }
}
