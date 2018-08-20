package  com.redoteam.tv.mvp.model.entity;

import java.io.Serializable;

/**
 * 监控转码
 */
public class TranscodingMonitor implements Serializable {
    private String code;
    private String androidWebcamUrl;
    private String rtspCHStbCmaUrl;
    private String rtspStbCmaUrl;
    private String oTTRtspPlayUrl;
    private String vlcRtspPlayUrl;

    public String getVlcRtspPlayUrl() {
        return vlcRtspPlayUrl;
    }

    public void setVlcRtspPlayUrl(String vlcRtspPlayUrl) {
        this.vlcRtspPlayUrl = vlcRtspPlayUrl;
    }

    public String getoTTRtspPlayUrl() {
        return oTTRtspPlayUrl;
    }

    public void setoTTRtspPlayUrl(String oTTRtspPlayUrl) {
        this.oTTRtspPlayUrl = oTTRtspPlayUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAndroidWebcamUrl() {
        return androidWebcamUrl;
    }

    public void setAndroidWebcamUrl(String androidWebcamUrl) {
        this.androidWebcamUrl = androidWebcamUrl;
    }

    public String getRtspCHStbCmaUrl() {
        return rtspCHStbCmaUrl;
    }

    public void setRtspCHStbCmaUrl(String rtspCHStbCmaUrl) {
        this.rtspCHStbCmaUrl = rtspCHStbCmaUrl;
    }

    public String getRtspStbCmaUrl() {
        return rtspStbCmaUrl;
    }

    public void setRtspStbCmaUrl(String rtspStbCmaUrl) {
        this.rtspStbCmaUrl = rtspStbCmaUrl;
    }
}
