package by.borisevich.phone.book.dao.util;

import org.hibernate.criterion.Order;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
public class ListOrderAdapter {

    public static Order getHibernateOrder(ListOrder order) {
        if (order != null) {
            if (order.isAscending())
            {
                return Order.asc(order.getPropertyName());
            } else {
                return Order.desc(order.getPropertyName());
            }
        }
        return null;
    }
}
