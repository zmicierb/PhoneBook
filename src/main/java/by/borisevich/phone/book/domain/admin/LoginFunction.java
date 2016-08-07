package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by dima on 8/6/16.
 */
@Entity
@IdClass(LoginFunctionPK.class)
@Table(name = "LOGIN_FUNCTIONS", schema = "DICT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LoginFunction extends AbstractPersistable<LoginFunctionPK> {

    @Id
    @Column(name = "login_id")
    private String loginId;
    @Id
    @Column(name = "function_id")
    private String functionId;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public LoginFunctionPK getId() {
        return new LoginFunctionPK(this.loginId, this.functionId);
    }

    @Override
    public void setId(LoginFunctionPK loginFunctionPK) {
        this.loginId = loginFunctionPK.getLoginId();
        this.functionId = loginFunctionPK.getFunctionId();
    }
}
