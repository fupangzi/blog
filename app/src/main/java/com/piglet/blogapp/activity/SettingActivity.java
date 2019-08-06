package com.piglet.blogapp.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.piglet.blogapp.R;
import com.piglet.blogapp.base.BaseActivity;
import com.piglet.blogapp.utils.StatusBarUtil;

import java.io.File;
import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.gd)
    ImageView gd;
    @BindView(R.id.rl_t)
    RelativeLayout rlT;
    @BindView(R.id.setting_rl_feedback)
    RelativeLayout settingRlFeedback;
    @BindView(R.id.setting_rl_aboutus)
    RelativeLayout settingRlAboutus;
    @BindView(R.id.versoncode)
    TextView versoncode;
    @BindView(R.id.setting_rl_versioninfo)
    RelativeLayout settingRlVersioninfo;
    @BindView(R.id.setting_tv_cachesize)
    TextView settingTvCachesize;
    @BindView(R.id.setting_rl_clearcache)
    RelativeLayout settingRlClearcache;
    @BindView(R.id.back)
    Button back;

    /**
     * 清理app的缓存 其实是清除的getCacheDir 和getExternalCacheDir这两个文件
     *
     * @param context
     */
    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    /**
     * 删除一个文件夹
     *
     * @param dir
     * @return
     */
    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 计算文件夹的大小
     */
    public static long getFolderSize(File file) throws Exception {
        if (!file.exists()) {
            return 0;
        }
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return "0K";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "TB";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();

        //设置跟状态栏一样的高
        rlT.setPadding(0, StatusBarUtil.getStatusBarHeight(this), 0, 0);
        versoncode.setText(getLocalVersion(SettingActivity.this)+"");
    }

    private void initView() {
        try {
            settingTvCachesize.setText(getTotalCacheSize().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        settingRlClearcache.setOnClickListener(this);
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
    }

    /**
     * 计算app的缓存大小其实计算的是 getCacheDir()这个file和getExternalCacheDir()这个file大小的和
     */
    public String getTotalCacheSize() throws Exception {
        long cacheSize = getFolderSize(getCacheDir());

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheSize += getFolderSize(getExternalCacheDir());
        }
//        File cacheDir = StorageUtils.getOwnCacheDirectory(this, "universalimageloader/Cache");
        return getFormatSize(cacheSize);
    }

    private void showtotalSettingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("是否清除缓存");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //imageLoader清除缓存大小的放大
//                ImageLoader.getInstance().clearDiskCache();

                clearAllCache(SettingActivity.this);
                String totalCacheSize = null;
                try {
                    totalCacheSize = getTotalCacheSize();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                settingTvCachesize.setText(totalCacheSize);
            }
        });
        builder.create().show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_rl_clearcache:
                showtotalSettingDialog();
                break;
        }
    }

    @OnClick({R.id.gd, R.id.setting_rl_clearcache, R.id.back, R.id.setting_rl_feedback, R.id.setting_rl_aboutus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gd:
                finish();
                break;
            case R.id.setting_rl_clearcache:
                break;
            case R.id.back:
                SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
                sp.edit().remove("token").commit();
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.setting_rl_feedback:
                break;
            case R.id.setting_rl_aboutus:
                break;
        }
    }

    public static int getLocalVersion(Context ctx) {
        int localVersion = 0;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
            Log.d("TAG", "本软件的版本号。。" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

}
