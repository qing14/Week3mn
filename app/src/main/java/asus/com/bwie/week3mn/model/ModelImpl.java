package asus.com.bwie.week3mn.model;

import android.util.Log;

import com.google.gson.Gson;

import java.util.Map;

import asus.com.bwie.week3mn.callback.MyCallback;
import asus.com.bwie.week3mn.utils.RetrofitUtils;

public class ModelImpl implements Imodel {
    /**
     * get
     * @param urlData
     * @param clazz
     * @param myCallBack
     */
    @Override
    public void get(String urlData, final Class clazz, final MyCallback myCallBack) {
        RetrofitUtils.getRetrofitUtils().get(urlData, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if(myCallBack != null){
                        myCallBack.onSuccess(o);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if(myCallBack != null){
                        myCallBack.onFails(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {
            Log.i("1111111",error.toString());
            }
        });
    }

    @Override
    public void postData(String urlData, Map<String, String> map, final Class clazz, final MyCallback myCallBack) {
        RetrofitUtils.getRetrofitUtils().post(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data,clazz);
                    if(myCallBack != null){
                        myCallBack.onSuccess(o);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if(myCallBack != null){
                        myCallBack.onFails(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }


    @Override
    public void put(String urlData,Map<String,String> map,  final Class clazz, final MyCallback myCallBack) {
        RetrofitUtils.getRetrofitUtils().put(urlData,map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if(myCallBack != null){
                        myCallBack.onSuccess(o);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if(myCallBack != null){
                        myCallBack.onFails(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

    @Override
    public void delete(String urlData, Map<String, String> map, final Class clazz, final MyCallback myCallBack) {
        RetrofitUtils.getRetrofitUtils().del(urlData, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String data) {
                try {
                    Object o = new Gson().fromJson(data, clazz);
                    if(myCallBack != null){
                        myCallBack.onSuccess(o);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    if(myCallBack != null){
                        myCallBack.onFails(e);
                    }
                }
            }

            @Override
            public void onFail(String error) {

            }
        });
    }

}
