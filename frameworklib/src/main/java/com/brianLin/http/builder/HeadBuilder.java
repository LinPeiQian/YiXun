package com.brianLin.http.builder;

import com.brianLin.http.OkHttpUtils;
import com.brianLin.http.request.OtherRequest;
import com.brianLin.http.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
