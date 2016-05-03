package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.GenericDao;
import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.Persistable;
import by.borisevich.phone.book.service.GenericService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
public class GenericServiceImpl<T extends Persistable<ID>, ID extends Serializable> implements GenericService<T, ID> {
    protected GenericDao<T, ID> dao;

    public GenericServiceImpl(GenericDao<T, ID> dao) {
        this.dao = dao;
    }

    protected GenericDao<T, ID> getDao() {
        return dao;
    }

    @Transactional(readOnly = true)
    public T get(ID id) {
        if (id == null)
            return null;
        return getDao().get(id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Transactional(readOnly = true)
    public List<T> findAll(ListParams params) {
        return getDao().findAll(params);
    }

    @Transactional(readOnly = true)
    public void refresh(T... entities) {
        for (T e : entities) {
            getDao().refresh(e);
        }
    }

    @Transactional
    public void delete(ID... ids) {
        for (ID id : ids) {
            T e = getDao().get(id);
            if (e != null)
                getDao().delete(e);
        }
    }

    @Transactional
    public void delete(T... entities) {
        for (T e : entities) {
            getDao().delete(e);
        }
    }


    @Transactional
    public T createOrUpdate(T entity) {
        getDao().createOrUpdate(entity);
        return entity;
    }

    @Transactional
    public T create(T entity) {
        getDao().create(entity);
        return entity;
    }
}
