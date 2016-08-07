package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.admin.Login;

/**
 * Created by dima on 8/7/16.
 */
public class LoginDto {

    private String username;
    private String password;
    private String name;
    private DepartmentDto department;
    private String[] authority;

    public LoginDto() {
    }

    public LoginDto(Login login, String[] authorities) {
        this.username = login.getId();
        this.name = login.getName();
        if (login.getDepartment() != null) {
            this.department = new DepartmentDto(login.getDepartment());
        }
        this.authority = authorities;
    }

    public LoginDto(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public LoginDto(String username, String password, String name, DepartmentDto departmentDto) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = departmentDto;
    }

    public LoginDto(String username, String password, String name, DepartmentDto departmentDto, String[] authority) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = departmentDto;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    public String[] getAuthority() {
        return authority;
    }

    public void setAuthority(String[] authority) {
        this.authority = authority;
    }
}
