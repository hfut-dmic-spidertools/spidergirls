package cn.edu.hfut.dmic.spidergirls.URL;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by cds on 2015/10/22.
 */
public class BingURL {

    public static String createURL(String keyWord, int firstPageNum) {
        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("http")
                    .setHost("cn.bing.com")
                    .setPath("/search")
                    .setParameter("q", keyWord)
                    .setParameter("first", String.valueOf(firstPageNum))
                    .build();

            System.out.println("searchUEL\t" + uri.toString());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return uri.toString();

    }
}