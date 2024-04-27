package com.btn.repositories.impl;

import com.btn.pojo.User;
import com.btn.repositories.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean factoryBean;
    @Override
    public void addUser(User user) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        s.save(user);
        // Nhớ kiểm tra và xử lí lỗi ở đây thêm

    }

    @Override
    public User getUsersByUsername(String username) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        return (User) q.getSingleResult();
    }
}
