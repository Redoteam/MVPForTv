
package com.redoteam.tv.mvp.model.entity;

import com.redoteam.tv.mvp.model.api.ApiService;

import java.io.Serializable;


/**
 * ================================================
 * 如果你服务器返回的数据格式固定为这种方式(这里只提供思想,服务器返回的数据格式可能不一致,可根据自家服务器返回的格式作更改)
 * 指定范型即可改变 {@code data} 字段的类型, 达到重用 {@link BaseResponse}, 如果你实在看不懂, 请忽略
 * ================================================
 */
public class BaseResponse<T> implements Serializable {
    private T data;
    private String code;
    private String desc;

    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return desc;
    }

    /**
     * 请求是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        if (code.equals(ApiService.RequestSuccess)) {
            return true;
        } else {
            return false;
        }
    }
}
