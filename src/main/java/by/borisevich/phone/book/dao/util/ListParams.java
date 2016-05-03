package by.borisevich.phone.book.dao.util;

/**
 * Created by BorisevichDA on 2016-04-21.
 */
public class ListParams {
    public static final ListParams EMPTY = new ListParams(0, Integer.MAX_VALUE, false);
    public static final ListParams ONLY_ONE = new ListParams(0, 1, true);
    private int offset;
    private int count;
    private boolean usePagination;
    private ListOrder[] orders;

    public ListParams(int offset, int count, boolean usePagination) {
        this.offset = offset;
        this.count = count;
        this.usePagination = usePagination;
    }

    public ListParams(ListOrder... orders) {
        this(0, Integer.MAX_VALUE, false, orders);
    }

    public ListParams(int offset, int count, ListOrder... orders) {
        this(offset, count, true, orders);
    }

    public ListParams(int offset, int count, boolean usePagination, ListOrder... orders) {
        this.offset = offset;
        this.count = count;
        this.usePagination = usePagination;
        this.orders = orders;
    }

    public ListParams(int offset, int count) {
        this(offset, count, true);
    }

    public static ListParams getEMPTY() {
        return EMPTY;
    }

    public static ListParams getOnlyOne() {
        return ONLY_ONE;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isUsePagination() {
        return usePagination;
    }

    public void setUsePagination(boolean usePagination) {
        this.usePagination = usePagination;
    }

    public ListOrder[] getOrders() {
        return orders;
    }

    public void setOrders(ListOrder[] orders) {
        this.orders = orders;
    }
}
