package by.borisevich.phone.book.service.impl;

import by.borisevich.phone.book.dao.LoginDao;
import by.borisevich.phone.book.domain.Login;
import by.borisevich.phone.book.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loginService")
@Transactional
public class LoginServiceImpl extends GenericServiceImpl<Login, Integer> implements LoginService {

    @Autowired
    private LoginDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(LoginDao dao) {
        super(dao);
        this.dao = dao;
    }

    public Login findBySSO(String sso) {
        Login login = dao.findBySSO(sso);
        return login;
    }

    public void saveLogin(Login login) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        dao.createOrUpdate(login);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateLogin(Login login) {
        Login entity = dao.get(login.getId());
        if (entity != null) {
            entity.setSsoId(login.getSsoId());
            if (!login.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(login.getPassword()));
            }
            entity.setFirstName(login.getFirstName());
            entity.setLastName(login.getLastName());
            entity.setEmail(login.getEmail());
            entity.setLoginProfiles(login.getLoginProfiles());
        }
    }

    public void deleteLoginBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    public boolean isLoginSSOUnique(Integer id, String sso) {
        Login login = findBySSO(sso);
        return (login == null || ((id != null) && (login.getId() == id)));
    }

}
