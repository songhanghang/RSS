package android.song.com.rss.http;

import android.song.com.rss.bean.RssRootBean;
import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by songhang on 2017/3/21.
 * 网络请求
 */

public class HttpRequest {
    private static class Holder {
        private final static HttpRequest sRequest = new HttpRequest();
        private final static Retrofit.Builder sBuilder = new Retrofit.Builder()
                .baseUrl("http://host")
                .addConverterFactory(SimpleXmlConverterFactory.create());
    }

    public static HttpRequest getInstance() {
        return Holder.sRequest;
    }

    public void request(@NonNull String url, MyCallback<RssRootBean> httpCallback) {
        Retrofit retrofit = Holder.sBuilder.build();
        IGet get = retrofit.create(IGet.class);
        Call<RssRootBean> call = get.get(url);
        call.enqueue(httpCallback);
    }

    private interface IGet {
        @GET()
        Call<RssRootBean> get(@Url String url);
    }

    public abstract static class MyCallback<T> implements Callback<T>{

    }
}
