package by.borisevich.phone.book.controller.dto;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima on 6/5/16.
 */
public class Menu {
    private String id;
    private String value;
    private String color;

    private List<SubMenu> data = new ArrayList<SubMenu>();

    public Menu() {
    }

    public Menu(String id, String value, String color) {
        this.id = id;
        this.value = value;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<SubMenu> getData() {
        return data;
    }

    public void setData(List<SubMenu> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this, this.getClass());
    }

    public static class SubMenu {
        private String id;
        private String value;
        private String color;
        private String href;

        public SubMenu(String id, String value, String color, String href) {
            this.id = id;
            this.value = value;
            this.color = color;
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
