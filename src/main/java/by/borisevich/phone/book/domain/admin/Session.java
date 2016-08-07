package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.controller.dto.LoginDto;
import by.borisevich.phone.book.domain.AbstractPersistable;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.persistence.*;

/**
 * Created by dima on 6/5/16.
 */
@Entity
@Table(name = "SESSION", schema = "DICT")
public class Session extends AbstractPersistable<String> {
    @Id
    @Column(name = "id")
    private String id; // id http session
    @Column(name = "ip")
    private String ip;
    @Column(name = "user_id", insertable = false, updatable = false)
    private String userId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Login login;
//    private Lang lang = Lang.RU;
//    private SearchType searchType = SearchType.b;
//    private int debug = 0;          // 0 - 1 уровень логирования
//    private String application;     //?
//    private List<MenuDto> menu;      //пользовательское меню

    public Session() {

    }

    public Session(Authentication authentication) {
        String name = authentication.getName();
        String password = authentication.getCredentials() != null ? authentication.getCredentials().toString() : null;
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();

        this.id = details.getSessionId();
        this.ip = details.getRemoteAddress();
        this.login = new Login(name, password);
    }

    public Session(String userId, String id, String ip, Login login) {
        this.userId = userId;
        this.id = id;
        this.ip = ip;
        this.login = login;
    }

    //    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

