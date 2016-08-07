package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.admin.Department;

/**
 * Created by dima on 8/7/16.
 */
public class DepartmentDto {

    private Long id;
    private String name;
    private String address;

    public DepartmentDto() {
    }

    public DepartmentDto(Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.address = department.getAddress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
