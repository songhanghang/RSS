package android.song.com.rss.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.song.com.rss.R;
import android.song.com.rss.bean.RssItemBean;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;

public class TestStackAdapter extends StackAdapter<RssItemBean> {

    private Context mContext;

    public TestStackAdapter(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void bindView(RssItemBean data, int position, CardStackView.ViewHolder holder) {
        if (holder instanceof ColorItemViewHolder) {
            ColorItemViewHolder h = (ColorItemViewHolder) holder;
            h.onBind(data, position);
        }
    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        return new ColorItemViewHolder(getLayoutInflater().inflate(R.layout.list_card_item, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.list_card_item;
    }

    static class ColorItemViewHolder extends CardStackView.ViewHolder {
        View mLayout;
        View mContainerContent;
        TextView mTextTitle;
        TextView mTextContent;
        ObjectAnimator mAnimator;

        public ColorItemViewHolder(View view) {
            super(view);
            mLayout = view.findViewById(R.id.frame_list_card_item);
            mContainerContent = view.findViewById(R.id.container_list_content);
            mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
            mTextContent = (TextView) view.findViewById(R.id.text_list_card_content);
            mAnimator = ObjectAnimator.ofFloat(mLayout, "RotationX", -5, 0);
        }

        @Override
        public void onItemExpand(boolean b) {
            if (b) {
                mAnimator.start();
            } else {
                mAnimator.reverse();
            }
            mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
        }

        public void onBind(RssItemBean data, int position) {
            mTextTitle.setText(String.valueOf(position) + ": " + data.title);
            mTextContent.setText(Html.fromHtml(data.description));
            mTextContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }


}
