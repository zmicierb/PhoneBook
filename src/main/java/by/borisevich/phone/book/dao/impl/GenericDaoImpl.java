package by.borisevich.phone.book.dao.impl;

import by.borisevich.phone.book.dao.GenericDao;
import by.borisevich.phone.book.dao.util.ListOrder;
import by.borisevich.phone.book.dao.util.ListOrderAdapter;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.dao.util.PagedList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public GenericDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public GenericDaoImpl(Class<T> persistentClass, SessionFactory sessionFactory) {
        this(persistentClass);
        this.sessionFactory = sessionFactory;
    }

    public static long getTotalCount(Criteria criteria) {
        //TODO желательно клонировать переданную критерию и делать с ней что угодно,
        Projection p = null;
        ResultTransformer rt = Criteria.ROOT_ENTITY;
        if (criteria instanceof CriteriaImpl) {
            p = ((CriteriaImpl) criteria).getProjection();
            rt = ((CriteriaImpl) criteria).getResultTransformer();
        }
        criteria.setProjection(Projections.rowCount());
        long totalCount = (Long) criteria.uniqueResult();
        criteria.setProjection(p);
        criteria.setResultTransformer(rt);

        return totalCount;
    }

    public static Criteria applyListParams(Criteria criteria, ListParams params) {
        criteria.setFirstResult(params.getOffset());
        criteria.setMaxResults(params.getCount());
        applyListOrders(criteria, params.getOrders());
        return criteria;
    }

    public static void applyListOrders(Criteria criteria, ListOrder[] orders) {
        if (orders == null)
            return;
        for (ListOrder lo : orders) {
            criteria.addOrder(ListOrderAdapter.getHibernateOrder(lo));
        }
    }

    public static void applyListOrders(DetachedCriteria criteria, ListOrder[] orders) {
        if (orders == null)
            return;
        for (ListOrder lo : orders) {
            criteria.addOrder(ListOrderAdapter.getHibernateOrder(lo));
        }
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ID create(Object entity) {
        return (ID) sessionFactory.getCurrentSession().save(entity);

    }

    public void update(Object entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Object entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void createOrUpdate(Object entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public Object merge(Object entity) {
        return sessionFactory.getCurrentSession().merge(entity);
    }

    public T get(ID id) {
        return (T) sessionFactory.getCurrentSession().get(persistentClass, id);
    }

    public void refresh(Object entity) {
        sessionFactory.getCurrentSession().refresh(entity);
    }

    public List<T> findAll() {
        return findAll(ListParams.EMPTY);
    }

    public List<T> findAll(ListParams params){
        return getResultList(getDetachedCriteria(), params);
    }

    protected DetachedCriteria getDetachedCriteria() {
        return DetachedCriteria.forClass(getPersistentClass());
    }

    @SuppressWarnings("unchecked")
    protected List getResultList(Criteria criteria, ListParams params) {
        List result;
        if (!ListParams.EMPTY.equals(params)) {

            if (params.isUsePagination()) {

                long totalCount = getTotalCount(criteria);

                result = new PagedList(applyListParams(criteria, params).list(), totalCount);
            } else {
                result = applyListParams(criteria, params).list();
            }
        } else {
            result = criteria.list();
        }
        return result;

    }

    protected List getResultList(DetachedCriteria criteria, ListParams params) {
        return getResultList(getExecutableCriteria(criteria), params);
    }

    protected Criteria getExecutableCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(sessionFactory.getCurrentSession());
    }

    public Long count() {
        return getTotalCount(getExecutableCriteria(getDetachedCriteria()));
    }
}
