package by.borisevich.phone.book.dao.admin.impl;

import by.borisevich.phone.book.dao.admin.MenuDao;
import by.borisevich.phone.book.dao.impl.GenericDaoImpl;
import by.borisevich.phone.book.domain.admin.Menu;
import org.springframework.stereotype.Repository;

/**
 * Created by dima on 8/7/16.
 */
@Repository
public class MenuDaoImpl extends GenericDaoImpl<Menu, Long> implements MenuDao {

    public MenuDaoImpl() {
        super(Menu.class);
    }

}
