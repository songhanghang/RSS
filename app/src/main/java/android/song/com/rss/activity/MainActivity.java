package android.song.com.rss.activity;

import android.os.Bundle;
import android.song.com.rss.R;
import android.song.com.rss.adapter.TestStackAdapter;
import android.song.com.rss.bean.RssRootBean;
import android.song.com.rss.presenter.RssAlbumPresenter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.loopeer.cardstack.CardStackView;

public class MainActivity extends AppCompatActivity
        implements RssAlbumPresenter.IRssAlbumView, CardStackView.ItemExpendListener {
    private CardStackView mStackView;
    private TestStackAdapter mAdapter;
    private RssAlbumPresenter mAlbumPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mStackView = (CardStackView) findViewById(R.id.card_stack_view);
        mAdapter = new TestStackAdapter(this);
        mStackView.setAdapter(mAdapter);
        mStackView.setItemExpendListener(this);
        mAlbumPresenter = new RssAlbumPresenter(this);
        mAlbumPresenter.featchData("https://juejin.im/rss");

    }


    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemExpend(boolean expend) {

    }

    @Override
    public void loadSuccess(RssRootBean bean) {
        mAdapter.updateData(bean.mChannelBean.mItems);
    }
}
