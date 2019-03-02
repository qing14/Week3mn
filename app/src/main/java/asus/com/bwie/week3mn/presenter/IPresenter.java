package asus.com.bwie.week3mn.presenter;

import java.util.Map;

import asus.com.bwie.week3mn.callback.MyCallback;

public interface IPresenter {
    //get
    void get(String url, Class clazz);
    //post
    void post(String url, Map<String, String> map, Class clazz);
    //put
    void put(String url, Map<String, String> map, Class clazz);
    //delete
    void delete(String url, Map<String, String> map, Class clazz);

}
