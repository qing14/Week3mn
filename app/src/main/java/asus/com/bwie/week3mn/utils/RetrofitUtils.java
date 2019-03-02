package asus.com.bwie.week3mn.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import asus.com.bwie.week3mn.BaseApis;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils {

    public static RetrofitUtils retrofitUtils;
    private  BaseApis baseApis;
    private String BASE_URL="http://172.17.8.100/small/";

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (null==retrofitUtils){
                    retrofitUtils =new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public RetrofitUtils(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build();
        baseApis = retrofit.create(BaseApis.class);

    }
    /**
     * get
     * @param urlData
     * @param listener
     * @return
     */
    public RetrofitUtils get(String urlData,HttpListener listener){
        baseApis.get(urlData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }

    /**
     * 普通post请求
     */
    public RetrofitUtils post(String url,Map<String,String> map,HttpListener listener){
        if (map==null){
            map=new HashMap<>();
        }
        baseApis.post(url,map)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }
    /**
     * put
     */
    public RetrofitUtils put(String url,Map<String,String> map,HttpListener listener){

        baseApis.put(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }
    /**
     * del
     */
    public RetrofitUtils del(String url,Map<String,String> map,HttpListener listener){

        baseApis.delete(url,map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(getObserver(listener));
        return retrofitUtils;
    }



    /**
     * 观察者
     */
    private Observer getObserver(final HttpListener listener){
        Observer observer=new Observer<ResponseBody>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
                if (listener !=null){
                    listener.onFail(e.getMessage());
                }
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    String data = responseBody.string();
                    if (listener!=null){
                        listener.onSuccess(data);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    if (listener!=null){
                        listener.onFail(e.getMessage());
                    }
                }

            }

        };
        return observer;
    }

    private HttpListener listener;

    public void result(HttpListener listener){
        this.listener=listener;
    }


    public interface HttpListener{
        void onSuccess(String data);

        void onFail(String error);
    }




}
