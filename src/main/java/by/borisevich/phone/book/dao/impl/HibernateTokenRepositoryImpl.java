package by.borisevich.phone.book.dao.impl;

import java.util.Date;
import java.util.List;

import by.borisevich.phone.book.dao.util.ListParams;
import by.borisevich.phone.book.domain.PersistentLogin;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends GenericDaoImpl<PersistentLogin, String>
        implements PersistentTokenRepository {

    static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

    public HibernateTokenRepositoryImpl() {
        super(PersistentLogin.class);
    }

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {}", token.getUsername());
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setId(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        create(persistentLogin);

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            DetachedCriteria dc = getDetachedCriteria();
            dc.add(Restrictions.eq("id", seriesId));

            List<PersistentLogin> persistentLogins = (List<PersistentLogin>) getResultList(dc, ListParams.EMPTY);

            PersistentLogin persistentLogin = persistentLogins.get(0);

            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getId(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }

    @Override
    public void removeUserTokens(String username) {
        logger.info("Removing Token if any for user : {}", username);
        DetachedCriteria dc = getDetachedCriteria();
        dc.add(Restrictions.eq("username", username));
        List<PersistentLogin> persistentLogins = (List<PersistentLogin>) getResultList(dc, ListParams.EMPTY);

        if (persistentLogins.size() == 0)
            return;
        PersistentLogin persistentLogin = persistentLogins.get(0);
        if (persistentLogin != null) {
            logger.info("rememberMe was selected");
            delete(persistentLogin);
        }

    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("Updating Token for seriesId : {}", seriesId);
        PersistentLogin persistentLogin = get(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        update(persistentLogin);
    }

}