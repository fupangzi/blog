package com.piglet.blogapp.net;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * AndroidScheduler
 * 加入android线程
 * @author Administrator
 * @date 2019/1/15 0015
 */
public class AndroidScheduler implements Executor {
    private static AndroidScheduler instance;
    private final Scheduler mMainScheduler;
    private final Handler mHandler;

    private AndroidScheduler() {
        mHandler = new Handler(Looper.myLooper());
        mMainScheduler = Schedulers.from(this);
    }

    public static synchronized Scheduler mainThread() {
        if (instance == null) {
            instance = new AndroidScheduler();
        }
        return instance.mMainScheduler;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }

}
