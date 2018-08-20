package  com.redoteam.tv.mvp.model.entity;

import com.redoteam.tv.app.AppCache;

import java.io.Serializable;

/**
 * 用户信息
 */
public class User implements Serializable {
    private String birthday;
    private String phone;
    private String sex;
    private String use_typeid;
    private String nickname;
    private String region_id;
    private String use_type;
    private String bind_regionname;
    private String photo;
    private String bind_status;
    private String id;
    private String region_name;
    private String bind_regionid;
    private String token;
    private String name;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUse_typeid() {
        return use_typeid;
    }

    public void setUse_typeid(String use_typeid) {
        this.use_typeid = use_typeid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRegion_id() {
        return region_id;
    }

    public void setRegion_id(String region_id) {
        this.region_id = region_id;
    }

    public String getUse_type() {
        return use_type;
    }

    public void setUse_type(String use_type) {
        this.use_type = use_type;
    }

    public String getBind_regionname() {
        return bind_regionname;
    }

    public void setBind_regionname(String bind_regionname) {
        this.bind_regionname = bind_regionname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBind_status() {
        return bind_status;
    }

    public void setBind_status(String bind_status) {
        this.bind_status = bind_status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getBind_regionid() {
        return bind_regionid;
    }

    public void setBind_regionid(String bind_regionid) {
        this.bind_regionid = bind_regionid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean saveUser(){
       return AppCache.getInstance().saveUser(this);
    }
}
