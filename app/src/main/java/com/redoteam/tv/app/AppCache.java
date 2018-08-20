package com.redoteam.tv.app;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.redoteam.core.utils.DataHelper;
import com.redoteam.core.utils.Preconditions;
import com.redoteam.tv.mvp.model.entity.User;

/**
 * Created by 寻水的鱼 on 2018/8/15.
 */
public class AppCache
{
    private static final String USER_KEY = "User";
    private static final String TOKEN_KEY = "Token";

    String mToken = "";
    User mUser;
    Context mContext;

    private AppCache(Context context)
    {
        mContext = context;
    }

    static AppCache appCache;


    public static AppCache getInstance()
    {
        appCache = Preconditions.checkNotNull(AppCache.appCache, AppCache.class.getCanonicalName() + "is null;");
        return AppCache.appCache;
    }

    /**
     *
     * @param context: Applicition Context
     *
     */
    public static void  initialize(Application context){
        if (appCache == null)
        {
            appCache = new AppCache(context);
        }
    }


    public User getUser()
    {
        if (mUser == null)
        {
            mUser = DataHelper.getDeviceData(mContext, USER_KEY);
        }
        return mUser;
    }

    public boolean saveUser(User user)
    {
        mUser = user;
        return DataHelper.saveDeviceData(mContext, USER_KEY, mUser);
    }

    public void saveToken(String token)
    {
        mToken = token;
        DataHelper.setStringSF(mContext, TOKEN_KEY, mToken);
    }

    public String getToken()
    {
        if (TextUtils.isEmpty(mToken))
        {
            mToken = DataHelper.getStringSF(mContext, TOKEN_KEY);
        }
        return mToken;
    }


}
