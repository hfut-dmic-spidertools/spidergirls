package cn.edu.hfut.dmic.spidergirls.Snippet;

import java.io.Serializable;

/**
 * Created by Sam on 14-8-6.
 */
public class Snippet implements Serializable {
    private String title;
    private String content;
    private String link;

    public Snippet(String title, String link, String content) {
        this.title = title;
        this.content = content;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
