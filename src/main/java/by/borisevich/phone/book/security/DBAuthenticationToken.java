package by.borisevich.phone.book.security;

/**
 * Created by dima on 6/5/16.
 */

import by.borisevich.phone.book.domain.admin.Session;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class DBAuthenticationToken extends UsernamePasswordAuthenticationToken {

    // содержит инфу полученную из бд после аутентификации
    private Session sessionContext;


    public DBAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public DBAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public DBAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, Session sessionContext) {
        super(principal, credentials, authorities);

        this.sessionContext = sessionContext;
    }

    public Session getSessionContext() {
        return sessionContext;
    }
}
