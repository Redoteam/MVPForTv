package com.redoteam.tv.http.gson;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.redoteam.core.http.HttpCode;
import com.redoteam.core.http.exception.ApiException;
import com.redoteam.core.http.exception.JsonException;
import com.redoteam.core.http.exception.TokenInvalidException;
import com.redoteam.core.utils.LogUtils;
import com.redoteam.tv.mvp.model.entity.BaseResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, Object> {

    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object convert(ResponseBody value) {
        try {
            String json = new String(value.bytes());
            LogUtils.warnInfo("json", json);
            JSONObject jsonObject = new JSONObject(json);
            int code = jsonObject.optInt("code");
            if (code == 0) {
                BaseResponse h = (BaseResponse) adapter.fromJson(json);
                if (h.getData() == null) {
                    throw new ApiException(HttpCode.CODE_30002.getCode());
                } else {
                    return h.getData();
                }
            } else if (code == 20005) {
                throw new TokenInvalidException();
            } else {
                throw new ApiException("" + code);
            }
        } catch (IOException e) {
            throw new ApiException(HttpCode.CODE_30002.getCode());
        } catch (JSONException e) {
            throw new ApiException(HttpCode.CODE_30002.getCode());
        } catch (JsonSyntaxException e) {
            throw new JsonException(HttpCode.CODE_30003.getCode());
        } finally {
            if (value != null) {
                value.close();
            }
        }
    }
}
