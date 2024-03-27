/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btn.repositories.impl;

import com.btn.pojo.Category;
import com.btn.repositories.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Category> getCates(){
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Category.findAll");
        
        return q.getResultList();
    }
}
