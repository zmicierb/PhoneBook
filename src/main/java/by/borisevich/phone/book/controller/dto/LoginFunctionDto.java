package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.admin.Function;
import by.borisevich.phone.book.domain.admin.LoginFunction;

/**
 * Created by dima on 8/6/16.
 */
public class LoginFunctionDto {
    private String appFunctionId;
    private String description;

    private Boolean hasFunction;

    public LoginFunctionDto() {
    }

    public LoginFunctionDto(LoginFunction loginFunction, Function appFunction) {
        this.appFunctionId = appFunction.getId();
        this.description = appFunction.getDescription();
        if (loginFunction != null) {
            this.hasFunction = true;
        } else {
            this.hasFunction = false;
        }
    }

    public String getAppFunctionId() {
        return appFunctionId;
    }

    public void setAppFunctionId(String appFunctionId) {
        this.appFunctionId = appFunctionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasFunction() {
        return hasFunction;
    }

    public void setHasFunction(Boolean hasFunction) {
        this.hasFunction = hasFunction;
    }
}
