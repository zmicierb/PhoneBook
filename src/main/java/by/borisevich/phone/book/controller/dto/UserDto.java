package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.UserV2;

/**
 * Created by BorisevichDA on 2016-04-26.
 */
public class UserDto {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String post;

    public UserDto(UserV2 user){
        this.id=user.getId();
        this.name=user.getName();
        this.phone=user.getPhone();
        this.address=user.getAddress();
        if (user.getPostV2() != null) {
            this.post = user.getPostV2().getPost();
        }
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
