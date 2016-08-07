package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.admin.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by dima on 8/6/16.
 */
public class LoginPlainDto extends LoginInfoDto {

    private List<LoginFunctionDto> loginFunctions;

    private List<LoginLock> loginLocks;

    public LoginPlainDto() {
    }

    public LoginPlainDto(Login login, List<LoginFunction> loginFunctions, List<Function> allFunctions) {
        super(login);
        List<LoginFunctionDto> loginFunctionDtos = new ArrayList<LoginFunctionDto>();
        for (Function function : allFunctions) {
            LoginFunction found = null;
            for (LoginFunction loginFunction : loginFunctions) {
                if (function.getId().equals(loginFunction.getFunctionId())) {
                    found = loginFunction;
                    break;
                }
            }
            this.loginLocks = new ArrayList<LoginLock>();
            login.getLoginLocks();
            for (LoginLock loginLock : login.getLoginLocks()) {
                LoginLock newLoginLock = new LoginLock();
                newLoginLock.setId(loginLock.getId());
                newLoginLock.setLoginId(this.getId());
                newLoginLock.setReason(loginLock.getReason());
                this.loginLocks.add(newLoginLock);
            }
            if (found != null) {
                loginFunctionDtos.add(new LoginFunctionDto(found, function));
            } else {
                loginFunctionDtos.add(new LoginFunctionDto(null, function));
            }
        }
        this.loginFunctions = loginFunctionDtos;
    }

    public Login asLogin() {
        Login login = new Login();
        login.setId(this.getId());
        login.setDeptId(this.getDeptId());
        login.setName(this.getName());
        login.setPassword(this.getPassword());
        login.setLoginLocks(new HashSet<LoginLock>());
        for (LoginLock userLock : this.loginLocks) {
            userLock.setLoginId(this.getId());
            login.getLoginLocks().add(userLock);

        }
        return login;
    }

    public List<LoginFunction> asLoginFunctionList() {
        List<LoginFunction> loginFunctionList = new ArrayList<LoginFunction>();
        for (LoginFunctionDto loginFunctionDto : this.loginFunctions) {
            if (loginFunctionDto.getHasFunction() == true) {
                LoginFunction loginFunction = new LoginFunction();
                LoginFunctionPK loginFunctionPK = new LoginFunctionPK(this.getId(), loginFunctionDto.getAppFunctionId());
                loginFunction.setId(loginFunctionPK);
                loginFunction.setLoginId(this.getId());
                loginFunction.setFunctionId(loginFunctionDto.getAppFunctionId());
                loginFunctionList.add(loginFunction);
            }
        }
        return loginFunctionList;
    }

    public List<LoginFunctionDto> getLoginFunctions() {
        return loginFunctions;
    }

    public void setLoginFunctions(List<LoginFunctionDto> loginFunctions) {
        this.loginFunctions = loginFunctions;
    }

    public List<LoginLock> getLoginLocks() {
        return loginLocks;
    }

    public void setLoginLocks(List<LoginLock> loginLocks) {
        this.loginLocks = loginLocks;
    }
}
