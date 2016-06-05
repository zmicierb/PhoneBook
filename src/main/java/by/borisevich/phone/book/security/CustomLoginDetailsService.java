package by.borisevich.phone.book.security;

import java.util.ArrayList;
import java.util.List;

import by.borisevich.phone.book.domain.Login;
import by.borisevich.phone.book.domain.LoginProfile;
import by.borisevich.phone.book.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customLoginDetailsService")
public class CustomLoginDetailsService implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(CustomLoginDetailsService.class);

    @Autowired
    private LoginService loginService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        Login login = loginService.findBySSO(ssoId);
        logger.info("User : {}", login);
        if (login == null) {
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(login.getSsoId(), login.getPassword(),
                true, true, true, true, getGrantedAuthorities(login));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Login login) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (LoginProfile loginProfile : login.getLoginProfiles()) {
            logger.info("UserProfile : {}", loginProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + loginProfile.getType()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }

}