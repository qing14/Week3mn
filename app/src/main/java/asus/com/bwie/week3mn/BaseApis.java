package asus.com.bwie.week3mn;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface BaseApis<T> {

    @GET
    Observable<ResponseBody> get(@Url String url);
    @POST
    Observable<ResponseBody> post(@Url String url, @QueryMap Map<String,String> map);
    @PUT
    Observable<ResponseBody> put(@Url String url, @QueryMap Map<String,String> map);

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @DELETE
    Observable<ResponseBody> delete(@Url String url, @QueryMap Map<String,String> map);




}
