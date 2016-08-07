package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dima on 8/6/16.
 */
@Entity
@Table(name = "LOGIN_LOCKS", schema = "DICT")
public class LoginLock extends AbstractPersistable<Long> {

    @Id
    @Column(name = "username")
    private Long id;

    @Column
    private String reason;

    @Column
    private String loginId;

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
