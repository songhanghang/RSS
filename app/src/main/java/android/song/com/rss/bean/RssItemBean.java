package android.song.com.rss.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Random;

/**
 * Created by songhang on 2017/3/21.
 * RSS ITEM XML
 */
@Root(name = "item", strict = false)
public class RssItemBean extends BaseBean {
    public static final Random random = new Random();
    @Element(name = "title")
    public String title;
    @Element(name = "link")
    public String link;
    @Element(name = "description")
    public String description;

    @Override
    public String toString() {
        return "\nRssItemBean{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}' + "\n";
    }
}
