package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.dao.admin.DepartmentDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.domain.admin.Department;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 6/5/16.
 */
@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Long> implements DepartmentDao {

    public DepartmentDaoImpl() {
        super(Department.class);
    }
}
