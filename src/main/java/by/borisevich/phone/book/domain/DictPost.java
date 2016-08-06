package by.borisevich.phone.book.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by BorisevichDA on 2016-04-20.
 */
@Entity
@Table(name = "DICT_POST", schema = "DICT")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class DictPost extends AbstractPersistable<Long>{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "post")
    private String post;

    public DictPost(){

    }

    public DictPost(String post) {
        this.post = post;
    }

    @Override
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
}
