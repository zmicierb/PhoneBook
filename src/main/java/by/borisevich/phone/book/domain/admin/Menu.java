package by.borisevich.phone.book.domain.admin;

import by.borisevich.phone.book.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dima on 8/6/16.
 */
@Entity
@Table(name = "MENU", schema = "DICT")
public class Menu extends AbstractPersistable<String> {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String css;

    @Column
    private String icon;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menuId", cascade = CascadeType.ALL)
    private List<SubMenu> subMenus;

    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }
}
