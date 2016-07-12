package by.borisevich.phone.book.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by BorisevichDA on 2016-04-22.
 */
@Entity
@Table(name = "DICT_POST", schema = "DICT")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PostV2 extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "post")
    private String post;

    @OneToMany(mappedBy = "postV2", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<UserV2> user;

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public List<UserV2> getUser() {
        return user;
    }

    public void setUser(List<UserV2> user) {
        this.user = user;
    }
}
