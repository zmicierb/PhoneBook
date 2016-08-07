package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.admin.Login;

/**
 * Created by dima on 8/6/16.
 */
public class LoginInfoDto {
    private String id;
    private Long deptId;
    private String deptName;
    private String deptAddress;
    private String name;
    private String password;

    public LoginInfoDto() {
    }

    public LoginInfoDto(Login login) {
        this.id = login.getId();
        if (login.getDepartment() != null) {
            this.deptId = login.getDepartment().getId();
            this.deptName = login.getDepartment().getName();
            this.deptAddress = login.getDepartment().getAddress();
        }
        this.password = null;//user.getPassword();
        this.name = login.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

