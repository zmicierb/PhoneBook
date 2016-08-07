package by.borisevich.phone.book.controller.dto;

import by.borisevich.phone.book.domain.admin.Menu;
import by.borisevich.phone.book.domain.admin.SubMenu;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 6/5/16.
 */
public class MenuDto {
    private String id;
    private String name;
    private String css;
    private String icon;

    private List<SubMenuDto> data = new ArrayList<SubMenuDto>();

    public MenuDto() {
    }

    public MenuDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.css = menu.getCss();
        this.icon = menu.getIcon();
        if (menu.getSubMenus().size() > 0) {
            for (SubMenu subMenu : menu.getSubMenus()) {
                data.add(new SubMenuDto(subMenu));
            }
        }
    }

    public String getId() {
        return id;
    }

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

    public List<SubMenuDto> getData() {
        return data;
    }

    public void setData(List<SubMenuDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this, this.getClass());
    }

    public static class SubMenuDto {
        private String id;
        private String name;
        private String css;
        private String icon;
        private String href;

        public SubMenuDto(SubMenu subMenu) {
            this.id = subMenu.getId();
            this.name = subMenu.getName();
            this.css = subMenu.getCss();
            this.icon = subMenu.getIcon();
            this.href = subMenu.getHref();
        }

        public String getId() {
            return id;
        }

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

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
