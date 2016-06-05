package by.borisevich.phone.book.domain;

/**
 * Created by dima on 6/5/16.
 */

/**
 * Типы поиска
 * (p)  precise     - точный поиск
 * (b)  from begin  - по началу
 * (f)  substring   - полный поиск
 * По умолчанию используется "b"
 * Используется как глобальная переменная на уровне пользовательской сессии??
 */
public enum SearchType {
    p,
    b,
    f
}
