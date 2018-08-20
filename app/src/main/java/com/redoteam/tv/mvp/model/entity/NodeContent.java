package com.redoteam.tv.mvp.model.entity;

import java.util.List;

/**
 * 栏目信息
 */
public class NodeContent {
    private String id;
    private String title;
    private String contents;
    private String type;
    private String typeid;
    private String videopath;
    private String click_num;
    private String commentsnum;
    private String icon_path;
    private Object name;
    private Object nickname;
    private List<String>imglists;
    private List<Consult> consult;
    private List<ConsultPic> consultPic;

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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath;
    }

    public String getClick_num() {
        return click_num;
    }

    public void setClick_num(String click_num) {
        this.click_num = click_num;
    }

    public String getCommentsnum() {
        return commentsnum;
    }

    public void setCommentsnum(String commentsnum) {
        this.commentsnum = commentsnum;
    }

    public String getIcon_path() {
        return icon_path;
    }

    public void setIcon_path(String icon_path) {
        this.icon_path = icon_path;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getNickname() {
        return nickname;
    }

    public void setNickname(Object nickname) {
        this.nickname = nickname;
    }

    public List<String> getImglists() {
        return imglists;
    }

    public void setImglists(List<String> imglists) {
        this.imglists = imglists;
    }

    public List<Consult> getConsult() {
        return consult;
    }

    public void setConsult(List<Consult> consult) {
        this.consult = consult;
    }

    public List<ConsultPic> getConsultPic() {
        return consultPic;
    }

    public void setConsultPic(List<ConsultPic> consultPic) {
        this.consultPic = consultPic;
    }
}
