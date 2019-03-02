package asus.com.bwie.week3mn.presenter;

import java.util.Map;

import asus.com.bwie.week3mn.callback.MyCallback;
import asus.com.bwie.week3mn.model.ModelImpl;
import asus.com.bwie.week3mn.view.IView;

public class PresenterImpl implements IPresenter {

    private ModelImpl model;
    private IView iView;

    public PresenterImpl( IView iView) {
        this.model = new ModelImpl();
        this.iView = iView;
    }

    @Override
    public void get(String url, Class clazz) {
        model.get(url, clazz, new MyCallback() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFails(Exception e) {
                iView.onFailsData(e);
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> map, Class clazz) {
        model.postData(url, map,clazz, new MyCallback() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFails(Exception e) {
                iView.onFailsData(e);
            }
        });
    }

    @Override
    public void put(String url, Map<String, String> map, Class clazz) {
        model.put(url, map,clazz, new MyCallback() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFails(Exception e) {
                iView.onFailsData(e);
            }
        });
    }

    @Override
    public void delete(String url, Map<String, String> map, Class clazz) {
        model.delete(url, map,clazz, new MyCallback() {
            @Override
            public void onSuccess(Object data) {
                iView.onSuccessData(data);
            }

            @Override
            public void onFails(Exception e) {
                iView.onFailsData(e);
            }
        });
    }
    public void detach(){
        model=null;
        iView=null;
    }
}

