package  com.redoteam.tv.mvp.model.entity;

import java.io.Serializable;

/**
 * 子栏目信息
 */
public class SubNode implements Serializable {
    private String id;
    private String node_code;
    private String name;
    private String icons;
    private String public_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_code() {
        return node_code;
    }

    public void setNode_code(String node_code) {
        this.node_code = node_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    public String getPublic_type() {
        return public_type;
    }

    public void setPublic_type(String public_type) {
        this.public_type = public_type;
    }
}
