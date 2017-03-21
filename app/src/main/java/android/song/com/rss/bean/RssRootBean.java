package android.song.com.rss.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by songhang on 2017/3/21.
 * RSS XML ROOT
 */
@Root(name = "rss", strict = false)
@SuppressWarnings("unchecked")
public class RssRootBean extends BaseBean {
    @Element(name = "channel")
    public RssChannelBean mChannelBean;

    @Override
    public String toString() {
        return mChannelBean != null ? mChannelBean.toString() : "";
    }
}
