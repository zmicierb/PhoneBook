package by.borisevich.phone.book.service;

import by.borisevich.phone.book.domain.admin.Session;
import org.springframework.security.core.Authentication;

/**
 * Created by dima on 6/5/16.
 */
public interface SessionManagerService {

    /**
     * Аутентификация пользователя в БД
     *
     * @param authentication
     */
//    Session authentication(Authentication authentication);

    Session get(Authentication authentication);

    /**
     * Авторизация пользователя в БД
     * Необходима для использования процедур и логирования
     *
     * @param authentication объект аутентификации в системе
     * @return
     */
    void login(Authentication authentication);

    /**
     * Завершение сеанса работы текущего пользователя с БД
     */
//    void logout();

    /**
     * Завершение сеанса работы пользователя с БД
     *
     * @param session
     */
    void kill(Session session);

}
