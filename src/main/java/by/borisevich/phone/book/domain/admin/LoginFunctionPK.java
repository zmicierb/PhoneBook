package by.borisevich.phone.book.domain.admin;

import java.io.Serializable;

/**
 * Created by dima on 8/6/16.
 */
public class LoginFunctionPK implements Serializable {
    protected String loginId;
    protected String functionId;

    public LoginFunctionPK() {

    }

    public LoginFunctionPK(String loginId, String functionId) {
        this.loginId = loginId;
        this.functionId = functionId;
    }

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

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += getLoginId() != null ? getLoginId().hashCode() : 0;
        result += getFunctionId() != null ? getFunctionId().hashCode() : 0;
        return result;
    }

}