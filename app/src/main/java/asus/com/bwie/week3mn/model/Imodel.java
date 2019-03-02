package asus.com.bwie.week3mn.model;

import java.io.File;
import java.util.Map;

import asus.com.bwie.week3mn.callback.MyCallback;

public interface Imodel {
    //get
    void get(String urlData, Class clazz, MyCallback myCallBack);
    //post
    void postData(String urlData, Map<String, String> map, Class clazz, MyCallback myCallBack);
    //put
    void put(String urlData, Map<String, String> map, Class clazz, MyCallback myCallBack);
    //delete
    void delete(String urlData, Map<String, String> map, Class clazz, MyCallback myCallBack);

}
