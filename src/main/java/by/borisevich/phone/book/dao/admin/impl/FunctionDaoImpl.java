package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.dao.admin.FunctionDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.domain.admin.Function;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 8/7/16.
 */
@Repository
public class FunctionDaoImpl extends GenericDaoImpl<Function, String> implements FunctionDao {
    public FunctionDaoImpl() {
        super(Function.class);
    }
}
