package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dima on 6/5/16.
 */
@Entity
@Table(name = "DEPT", schema = "DICT")
public class Department extends AbstractPersistable<Long> {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
//    private String payDept;
//    private String payUnp;
//    private String payBank;
//    private String payNum;
//    private String payPNum;
//    private String payDoc;


    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    public String getPayDept() {
//        return payDept;
//    }
//
//    public void setPayDept(String payDept) {
//        this.payDept = payDept;
//    }
//
//    public String getPayUnp() {
//        return payUnp;
//    }
//
//    public void setPayUnp(String payUnp) {
//        this.payUnp = payUnp;
//    }
//
//    public String getPayBank() {
//        return payBank;
//    }
//
//    public void setPayBank(String payBank) {
//        this.payBank = payBank;
//    }
//
//    public String getPayNum() {
//        return payNum;
//    }
//
//    public void setPayNum(String payNum) {
//        this.payNum = payNum;
//    }
//
//    public String getPayDoc() {
//        return payDoc;
//    }
//
//    public void setPayDoc(String payDoc) {
//        this.payDoc = payDoc;
//    }
//
//    public String getPayPNum() {
//        return payPNum;
//    }
//
//    public void setPayPNum(String payPNum) {
//        this.payPNum = payPNum;
//    }
}
