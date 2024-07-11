package com.fh.repository.implement;

//package com.fh.repository.implement;
//
//import com.fh.pojo.OrderDetail;
//import com.fh.pojo.Product;
//import com.fh.repository.StatsRepository;
//import com.fh.utils.Hibernate;
//import jakarta.persistence.Query;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//import org.hibernate.Session;
//
//import java.util.List;
//
//public class StatsRepositoryImplement implements StatsRepository {
//    @Override
//    public List<Object[]> statsRevenueByProduct() {
//        try (Session session = Hibernate.getSessionFactory().openSession()) {
//            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
//
//            Root<Product> rP = query.from(Product.class);
//            Root<OrderDetail> rD = query.from(OrderDetail.class);
//
//            query.where(criteriaBuilder.equal(rP.get("id"), rD.get("product").get("id")));
//            query.multiselect(rP.get("id"), rP.get("name"), criteriaBuilder.sum(criteriaBuilder.prod(rD.get("quantity"), rD.get("unitPrice"))));
//            query.groupBy(rP.get("id"));
//
//            Query q = session.createQuery(query);
//
//            return q.getResultList();
//        }
//    }
//}
