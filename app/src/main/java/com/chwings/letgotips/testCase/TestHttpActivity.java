package com.chwings.letgotips.testCase;

import android.os.Bundle;
import android.util.Log;

import com.brianLin.http.OkHttpUtils;
import com.brianLin.http.callback.StringCallback;
import com.chwings.letgotips.R;
import com.chwings.letgotips.activity.BaseActivity;

import okhttp3.Call;

public class TestHttpActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_http;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkHttpUtils.get().url("http://www.baidu.com").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.d(TAG , "Exception = " + e + " id = " + id );
            }

            @Override
            public void onResponse(String response, int id) {
                Log.d(TAG , " id = "+ id + "response = "+ response  );
            }
        });

    }
}
