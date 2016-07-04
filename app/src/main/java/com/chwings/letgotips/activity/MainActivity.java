package com.chwings.letgotips.activity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.brianLin.download.DownloadRequest;
import com.chwings.letgotips.R;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private String url = "http://view.inews.qq.com/newsDownLoad?refer=biznew&src=kb_gov&ostype=android";
//    private String url = "http://down.qq.com/lol/dltools/LOL_V3.1.8.9_FULL_TDL_speeded_signed.exe";

    private String name = "kuaibao.apk";

    private String filePath = Environment.getExternalStorageDirectory().getAbsolutePath();

    private DownloadRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        request = new DownloadRequest.Builder()
                .setTitle(name)
                .setUri(url)
                .setFolder(new File(filePath))
                .build();
        Log.d(TAG , "progress = "+progressBar);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_download)
    public void onDownload(View view){
        //下载
        Log.d(TAG , "下载");
//        DownloadManager.getInstance().download(request, url, new CallBack() {
//            @Override
//            public void onStarted() {
//                Log.d(TAG , "onStarted");
//            }
//
//            @Override
//            public void onConnecting() {
//                Log.d(TAG , "onConnecting");
//            }
//
//            @Override
//            public void onConnected(long total, boolean isRangeSupport) {
//                Log.d(TAG , "onConnected" + total);
//                progressBar.setMax(100);
//            }
//
//            @Override
//            public void onProgress(long finished, long total, int progress) {
//                Log.d(TAG , "onProgress finished = "+ finished + " total = "+total + " progress = "+progress);
//                progressBar.setProgress(progress);
//            }
//
//            @Override
//            public void onCompleted() {
//                Log.d(TAG , "onCompleted");
//            }
//
//            @Override
//            public void onDownloadPaused() {
//                Log.d(TAG , "onDownloadPaused");
//            }
//
//            @Override
//            public void onDownloadCanceled() {
//                Log.d(TAG , "onDownloadCanceled");
//            }
//
//            @Override
//            public void onFailed(DownloadException e) {
//                Log.d(TAG , "onFailed e = "+e);
//            }
//        });
    }

    @OnClick(R.id.btn_pause)
    public void onPause(View view){
            Log.d(TAG , "暂停");
//        DownloadManager.getInstance().pause(url);
    }

    @OnClick(R.id.button)
    void onPlay(){
        Log.d(TAG , "打印");
    }



}
