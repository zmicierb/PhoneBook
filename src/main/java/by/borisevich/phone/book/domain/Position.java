package by.borisevich.phone.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by BorisevichDA on 2016-04-19.
 */
@Entity
@Table(name = "POSITION", schema = "DICT")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Position extends AbstractPersistable<Long>{

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER, optional = false)
    private User user;
    @Column(insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER, optional = false)
    private DictPost post;
    @Column(insertable = false, updatable = false)
    private Long postId;
//
//    public Position(){
//
//    }
//
//    public Position(User user, Dict dict) {
//        this.user = user;
//        this.dict = dict;
//    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public DictPost getPost() {
        return post;
    }

    public void setPost(DictPost post) {
        this.post = post;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
