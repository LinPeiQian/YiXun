package com.chwings.letgotips.testCase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.brianLin.http.OkHttpUtils;
import com.brianLin.http.callback.StringCallback;
import com.chwings.letgotips.R;
import com.chwings.letgotips.activity.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class TestZhuJieActivity extends BaseActivity {

    @BindView(R.id.tv_hello)
    TextView tv_hello;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_zhu_jie;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG , "textview = "+tv_hello);
    }

    @OnClick(R.id.btn_click)
    public void onTestClick(View view){
        Log.d(TAG , "click");
    }

    @OnClick(R.id.textview)
    void onTextView(){
        Toast.makeText(this , "textview" , Toast.LENGTH_LONG).show();
        OkHttpUtils.get().url("").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
            }

            @Override
            public void onResponse(String response, int id) {

            }
        });
    }
}
