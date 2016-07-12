package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * Created by dima on 6/5/16.
 */
@Entity
@Table(name = "LOGIN", schema = "DICT")
public class Login extends AbstractPersistable<String> {

    @Id
    @Column(name = "username")
    private String id;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "dept_id")
    private Department department;
    @Column(name = "dept_id", insertable = false, updatable = false)
    private Long deptId;

    public Login() {

    }

    public Login(String username, String password) {
        this.id = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
