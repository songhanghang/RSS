package android.song.com.rss.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.song.com.rss.R;
import android.song.com.rss.adapter.RssItemStackAdapter;
import android.song.com.rss.bean.RssRootBean;
import android.song.com.rss.presenter.RssAlbumPresenter;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopeer.cardstack.CardStackView;

/**
 * Created by songhang on 2017/3/26.
 *
 */

public class RssItemFragment extends Fragment implements RssAlbumPresenter.IRssAlbumView, CardStackView.ItemExpendListener{
    private static final String ARG_SECTION_NUMBER = "section_number";
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private CardStackView mStackView;
    private RssItemStackAdapter mAdapter;
    private RssAlbumPresenter mAlbumPresenter;

    public RssItemFragment() {
    }

    public static RssItemFragment newInstance(int sectionNumber) {
        RssItemFragment fragment = new RssItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rss_table, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mStackView = (CardStackView) view.findViewById(R.id.card_stack_view);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        mAdapter = new RssItemStackAdapter(getActivity());
        mStackView.setAdapter(mAdapter);
        mStackView.setItemExpendListener(this);
        mAlbumPresenter = new RssAlbumPresenter(this);
        Bundle args = getArguments();
        int pos = args.getInt(ARG_SECTION_NUMBER);
        switch (pos) {
            case 0:
                mAlbumPresenter.featchData("https://juejin.im/rss");
                break;
            case 1:
                mAlbumPresenter.featchData("http://www.androidweekly.cn/rss/");
                break;
            case 2:
                mAlbumPresenter.featchData("http://mobilefrontier.github.io/index.xml");
                break;
            default:
                break;
        }
    }

    @Override
    public void loadSuccess(RssRootBean bean) {
        mAdapter.updateData(bean.mChannelBean.mItems);
    }

    @Override
    public void onItemExpend(boolean expend) {

    }
}
