package android.song.com.rss.adapter;

import android.song.com.rss.fragment.RssItemFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by songhang on 2017/3/26.
 */

public class RssPageAdapter extends FragmentStatePagerAdapter {


        public RssPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return RssItemFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "掘金";
                case 1:
                    return "android周报";
                case 2:
                    return "移动开发前线";
            }
            return null;
        }
}
