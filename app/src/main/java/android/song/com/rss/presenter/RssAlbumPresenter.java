package android.song.com.rss.presenter;

import android.song.com.rss.bean.RssRootBean;
import android.song.com.rss.http.HttpRequest;
import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by songhang on 2017/3/25.
 *
 */

public class RssAlbumPresenter {
    private IRssAlbumView mAlbumView;

    public RssAlbumPresenter(@NonNull IRssAlbumView albumView) {
        mAlbumView = albumView;
    }

    public void featchData(String url) {
        HttpRequest.getInstance().request(url, new HttpRequest.MyCallback<RssRootBean>() {

            @Override
            public void onResponse(Call<RssRootBean> call, Response<RssRootBean> response) {
                Log.i("songhang", response.body().toString());
                mAlbumView.loadSuccess(response.body());
            }

            @Override
            public void onFailure(Call<RssRootBean> call, Throwable t) {

            }
        });
    }

    public interface IRssAlbumView {
        void loadSuccess(RssRootBean bean);
    }
}
