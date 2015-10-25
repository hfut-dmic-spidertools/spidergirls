package cn.edu.hfut.dmic.spidergirls.model;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Sam on 14-8-6.
 */
public class SearchItem{
    private String title;
    private String content;
    private String url;

    public SearchItem(String title, String url, String content) {
        this.title = title;
        this.content = content;
        this.url = url;
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
        return url;
    }

    public void setLink(String link) {
        this.url = link;
    }

    public JSONObject toJSON(){
        JSONObject jo=new JSONObject();
        jo.put("title",title);
        jo.put("url",url);
        jo.put("content",content);

        return jo;
    }


    @Override
    public String toString() {
       return "TITLE:"+title+"\n"
               +"URL:"+url+"\n"
                +"CONTENT:"+content+"\n";
    }

    public static void main(String[] args) {
        System.out.println(new SearchItem("a","b","c"));
    }

}
