package com.redoteam.core.http;

import android.support.annotation.NonNull;

import com.redoteam.core.base.mvp.IView;
import com.redoteam.core.http.exception.ApiException;
import com.redoteam.core.http.exception.JsonException;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;


public abstract class RxSubscriber<D> {
    private static final String TAG = "RxSubscriber";
    private Disposable mSubscribe;

    public RxSubscriber(Observable<D> observable) {
        subscribe(observable, null);
    }

    public RxSubscriber(Observable<D> observable, IView view) {
        subscribe(observable, view);
    }

    private void subscribe(Observable<D> observable, final IView view) {
        mSubscribe = observable.switchIfEmpty(new ObservableSource<D>() {
            @Override
            public void subscribe(Observer<? super D> observer) {
                String code = HttpCode.CODE_30001.getCode();
                _onError(code, HttpCode.getMsg(code));
            }
        }).subscribe(new Consumer<D>() {
            @Override
            public void accept(@NonNull D d) throws Exception {
                if (view != null) {
//                    view.dismissDialog();
                }
                if (d != null) {
                    _onNext(d);
                } else {
                    String code = HttpCode.CODE_30002.getCode();
                    _onError(code, HttpCode.getMsg(code));
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                if (view != null) {
//                    view.dismissDialog();
                }
                throwable.printStackTrace();
                if (throwable instanceof HttpException
                        || throwable instanceof CompositeException
                        || throwable instanceof SocketTimeoutException
                        || throwable instanceof NoRouteToHostException
                        || throwable instanceof ConnectException
                        || throwable instanceof UnknownHostException) {
                    String code = HttpCode.CODE_30001.getCode();
                    _onError(code, HttpCode.getMsg(code));
                } else if (throwable instanceof ApiException) {
                    _onError(throwable.getMessage(), HttpCode.getMsg(throwable.getMessage()));
                } else if (throwable instanceof JsonException) {
                    String code = HttpCode.CODE_30003.getCode();
                    _onError(code, HttpCode.getMsg(code));
                } else {
//                    KLog.d(throwable.getMessage());
                    String code = HttpCode.CODE_30001.getCode();
                    _onError(code, HttpCode.getMsg(code));
                }
            }
        });
    }

    public Disposable getSubscribe() {
        return mSubscribe;
    }

    protected abstract void _onNext(D d);

    protected void _onError(String code, String msg) {
//        T.showShort(App.getInstance(), HttpCode.getMsg(code));
    }
}
