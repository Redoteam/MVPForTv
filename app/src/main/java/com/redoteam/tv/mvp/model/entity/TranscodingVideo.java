package com.redoteam.tv.mvp.model.entity;

import java.io.Serializable;

/**
 * 视频转码
 */
public class TranscodingVideo implements Serializable {
    private String SktVodPlayUrl;
    private String advancedPlayUrl;
    private String androidPlayUrl;
    private String changhongPlayUrl;
    private String code;
    private String ipanelPlayUrl;
    private String ootWebTvCamUrl;

    public String getSktVodPlayUrl() {
        return SktVodPlayUrl;
    }

    public void setSktVodPlayUrl(String sktVodPlayUrl) {
        SktVodPlayUrl = sktVodPlayUrl;
    }

    public String getAdvancedPlayUrl() {
        return advancedPlayUrl;
    }

    public void setAdvancedPlayUrl(String advancedPlayUrl) {
        this.advancedPlayUrl = advancedPlayUrl;
    }

    public String getAndroidPlayUrl() {
        return androidPlayUrl;
    }

    public void setAndroidPlayUrl(String androidPlayUrl) {
        this.androidPlayUrl = androidPlayUrl;
    }

    public String getChanghongPlayUrl() {
        return changhongPlayUrl;
    }

    public void setChanghongPlayUrl(String changhongPlayUrl) {
        this.changhongPlayUrl = changhongPlayUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIpanelPlayUrl() {
        return ipanelPlayUrl;
    }

    public void setIpanelPlayUrl(String ipanelPlayUrl) {
        this.ipanelPlayUrl = ipanelPlayUrl;
    }

    public String getOotWebTvCamUrl() {
        return ootWebTvCamUrl;
    }

    public void setOotWebTvCamUrl(String ootWebTvCamUrl) {
        this.ootWebTvCamUrl = ootWebTvCamUrl;
    }
}
