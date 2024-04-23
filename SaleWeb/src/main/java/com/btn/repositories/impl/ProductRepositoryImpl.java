package com.btn.repositories.impl;

import com.btn.pojo.Category;
import com.btn.pojo.Product;
import com.btn.repositories.ProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Autowired
    private Environment env;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        Session s = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root<Product> r = q.from(Product.class);

        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("name"), String.format("%%%s%%", kw)));
        }

        String fromPrice = params.get("fromPrice");
        if (fromPrice != null && !fromPrice.isEmpty()) {
            predicates.add(b.greaterThanOrEqualTo(r.get("price"), Long.parseLong(fromPrice)));
        }

        String toPrice = params.get("toPrice");
        if (toPrice != null && !toPrice.isEmpty()) {
            predicates.add(b.lessThanOrEqualTo(r.get("price"), Long.parseLong(toPrice)));
        }

        String cateId = params.get("cateId");
        if (cateId != null && !cateId.isEmpty()) {
            predicates.add(b.equal(r.get("categoryId"), Integer.parseInt(cateId)));
        }

        q.where(predicates.toArray(Predicate[]::new));

        String orderBy = params.get("orderBy");
        String desc = params.get("desc");
        List<String> orderFields = List.of("id", "name", "price");
        if (orderBy != null && !orderBy.isEmpty() && orderFields.contains(orderBy)) {
            if (desc != null && desc.equals("true")) {
                q.orderBy(b.desc(r.get(orderBy)));
            } else {
                q.orderBy(b.asc(r.get(orderBy)));
            }
        }

        Query query = s.createQuery(q);

        // PHÂN TRANG
        String p = params.get("page");
        if( p!= null && !p.isEmpty()){
            int pagesize = Integer.parseInt(env.getProperty("products.pagesize").toString());
            int start = (Integer.parseInt(p) -1) * pagesize;

            // bắt đầu lấy từ đâu
            query.setFirstResult(start);
            query.setMaxResults(pagesize);
        }

        return (List<Product>) query.getResultList();
    }

    @Override
    public void createProduct(String name, String description, Long price, int cateId) {
        Session session = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();


        session.getTransaction().begin(); // bật transaction để tránh tranh chấp index
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        Category c = session.get(Category.class, cateId);
        p.setCategoryId(c);
        session.persist(p);
        session.getTransaction().commit();
    }

    @Override
    public void updateProduct(int prodId, Map<String, String> params) {
        Session session = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();

        session.getTransaction().begin();
        Product p = session.get(Product.class, prodId);

        String name = params.get("name");
        if (name != null && !name.isEmpty()) {
            p.setName(name);
        }

        String price = params.get("price");
        if (price != null && !price.isEmpty()) {
            p.setPrice(Long.parseLong(price));
        }

        String description = params.get("description");
        if (description != null && !description.isEmpty()) {
            p.setDescription(description);
        }

        String image = params.get("image");
        if (image != null && !image.isEmpty()) {
            p.setImage(image);
        }

        String active = params.get("active");
        if (active != null && !active.isEmpty()) {
            p.setActive(Boolean.parseBoolean(active));
        }

        String categoryId = params.get("categoryId");
        if (categoryId != null && !categoryId.isEmpty()) {
            Category c = session.get(Category.class, categoryId);
            p.setCategoryId(c);
        }
        session.update(p);
        session.getTransaction().commit();

    }

    @Override
    public void deleteProduct(int id) {
        Session session = Objects.requireNonNull(this.factoryBean.getObject()).getCurrentSession();

//        session.getTransaction().begin();
        Product p = session.get(Product.class, id);
        session.delete(p);
//        session.getTransaction().commit();
    }

    @Override
    public void addOrUpdate(Product p) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        if(p.getId() > 0) {
            s.update(p);
        }else {
            s.save(p);
        }
//        s.saveOrUpdate(p); // Sử dụng phương thức saveOrUpdate() với đối tượng Product p
    }

    @Override
    public Product getProductById(int id){
        Session s = this.factoryBean.getObject().getCurrentSession();
        return s.get(Product.class, id);
    }

}