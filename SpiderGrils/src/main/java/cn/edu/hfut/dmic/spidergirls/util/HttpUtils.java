package cn.edu.hfut.dmic.spidergirls.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by cds on 2015/10/23.
 */
public class HttpUtils {
    public static Document fetchDoc(String url) throws Exception {
        Document doc=null;
        Exception ex =  new Exception();
        for (int i = 0; i <= 3; i++) {

            try {
                doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.93 Safari/537.36").get();
                return doc;
            } catch (IOException e) {
                ex=e;
            }

        }
        throw ex;
    }

}
