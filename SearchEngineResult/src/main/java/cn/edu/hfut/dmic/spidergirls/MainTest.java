package cn.edu.hfut.dmic.spidergirls;

import cn.edu.hfut.dmic.spidergirls.CrawlResults.CrawledSearchResults;

/**
 * Created by cds on 2015/10/21.
 */
public class MainTest {
    public static void main(String[] args) {
        CrawledSearchResults.getAndSaveResults("中国",23);//中文有乱码问题

    }
}
