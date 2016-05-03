package by.borisevich.phone.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
@Entity
@Table(name = "USER", schema = "DICT")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserV2 extends AbstractPersistable<Long>{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
//    @JsonManagedReference
    @JoinTable(name = "POSITION", joinColumns = @JoinColumn(name = "USER_ID",unique = true), inverseJoinColumns = @JoinColumn(name = "POST_ID",unique = true))
    private PostV2 postV2;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PostV2 getPostV2() {
        return postV2;
    }

    public void setPostV2(PostV2 postV2) {
        this.postV2 = postV2;
    }

}