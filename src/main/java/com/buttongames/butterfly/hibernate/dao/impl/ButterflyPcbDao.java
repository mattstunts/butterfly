package com.buttongames.butterfly.hibernate.dao.impl;

import com.buttongames.butterfly.hibernate.dao.AbstractHibernateDao;
import com.buttongames.butterfly.model.ButterflyPcb;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * DAO for interacting with <code>ButterflyPcb</code> objects in the database.
 * @author skogaby (skogabyskogaby@gmail.com)
 */
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Repository
public class ButterflyPcbDao extends AbstractHibernateDao<ButterflyPcb> {

    @Autowired
    public ButterflyPcbDao(final SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(ButterflyPcb.class);
    }
}
