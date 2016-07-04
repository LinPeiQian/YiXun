package com.brianLin.http.gson;


import com.google.gson.Gson;

/**
 * 获取gson对象 单例
 */
public class GsonInstance  {

    private static Gson mGson ;

    public static Gson getGson(){
        if(mGson == null){
            synchronized (GsonInstance.class){
                if(mGson == null){
                    mGson = new Gson();
                }
            }
        }
        return mGson ;
    }

}
