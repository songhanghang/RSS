package android.song.com.rss.http;

import android.song.com.rss.bean.RssRootBean;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

/**
 * Created by songhang on 2017/3/21.
 * 网络请求
 */

public class HttpRequest {
    private static class Holder {
        public final static HttpRequest request = new HttpRequest();
    }

    public static HttpRequest getInstance() {
        return Holder.request;
    }

    public void request(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mobilefrontier.github.io/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        IGet get = retrofit.create(IGet.class);
        Call<RssRootBean> call = get.get();
        call.enqueue(new Callback<RssRootBean>() {
            @Override
            public void onResponse(Call<RssRootBean> call, Response<RssRootBean> response) {
                Log.i("songhang", response.body().toString());
            }

            @Override
            public void onFailure(Call<RssRootBean> call, Throwable t) {

            }
        });
    }

    public interface IGet {
        @GET("index.xml")
        Call<RssRootBean> get();
    }
}
