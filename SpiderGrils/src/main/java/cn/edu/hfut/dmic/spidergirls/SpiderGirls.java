package cn.edu.hfut.dmic.spidergirls;

import cn.edu.hfut.dmic.spidergirls.model.SearchItems;
import cn.edu.hfut.dmic.spidergirls.search.Search;
import cn.edu.hfut.dmic.spidergirls.util.Config;

import java.io.UnsupportedEncodingException;

/**
 * Created by cds on 2015/10/22.
 */
public class SpiderGirls {


    public static SearchItems search(String keyword,int pageTotalNum,String... engineNames) throws UnsupportedEncodingException {
        SearchItems totalItems = new SearchItems();

        for(String engineName:engineNames){
            totalItems.addAll(Search.search(keyword, engineName, pageTotalNum));
        }

        return totalItems;
    }

    public static SearchItems search(String keyWord, int pageTotalNum) throws UnsupportedEncodingException {
        String[] enables=Config.defaultRule.enables.toArray(new String[Config.defaultRule.enables.size()]);

            return search(keyWord, pageTotalNum, enables);

    }
}
