package  com.redoteam.tv.mvp.model.entity;

import java.io.Serializable;

/**
 * 无图征询
 */
public class Consult implements Serializable {
    private String id;
    private String opt;
    private String vote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
}
