package android.song.com.rss.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by songhang on 2017/3/21.
 * RSS CHANNEL XML
 */
@Root(name = "channel", strict = false)
public class RssChannelBean extends BaseBean {
    @Element(name = "title")
    public String title;
    @Element(name = "description")
    public String description;
    @Element(name = "lastBuildDate")
    public String lastBuildDate;
    @ElementList(name = "item", inline = true)
    public List<RssItemBean> Items;

    @Override
    public String toString() {
        return "RssChannelBean{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", Items=" + Items +
                '}';
    }
}
