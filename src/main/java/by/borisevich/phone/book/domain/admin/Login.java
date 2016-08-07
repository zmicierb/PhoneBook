package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "dept_id")
    private Department department;
    @Column(name = "dept_id", insertable = false, updatable = false)
    private Long deptId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loginId", cascade = CascadeType.ALL)
    private Set<LoginLock> loginLocks = new HashSet<LoginLock>();

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

    public Set<LoginLock> getLoginLocks() {
        return loginLocks;
    }

    public void setLoginLocks(Set<LoginLock> loginLocks) {
        this.loginLocks = loginLocks;
    }
}
