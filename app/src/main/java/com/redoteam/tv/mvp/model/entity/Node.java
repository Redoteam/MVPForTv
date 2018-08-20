package com.redoteam.tv.mvp.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 栏目信息
 * Created by Administrator on 2018/5/28.
 */
public class Node implements Serializable{
    private List<SubNode> nodelists;
    private List<NodeContent>items;

    public List<SubNode> getNodelists() {
        return nodelists;
    }

    public void setNodelists(List<SubNode> nodelists) {
        this.nodelists = nodelists;
    }

    public List<NodeContent> getItems() {
        return items;
    }

    public void setItems(List<NodeContent> items) {
        this.items = items;
    }
}
