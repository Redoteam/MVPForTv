package com.redoteam.tv.mvp.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 有图征询
 */
public class ConsultPic implements Serializable {
    private String id;
    private String title;
    private String content;
    private String picture;
    private List<Consult> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Consult> getData() {
        return data;
    }

    public void setData(List<Consult> data) {
        this.data = data;
    }
}
