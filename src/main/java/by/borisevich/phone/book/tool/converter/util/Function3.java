package by.borisevich.phone.book.tool.converter.util;

/**
 * Created by dima on 10/7/16.
 */
@FunctionalInterface
public interface Function3<A, B, C, R> {
    //R is like Return, but doesn't have to be last in the list nor named R.
    R apply(A a, B b, C c);
}
