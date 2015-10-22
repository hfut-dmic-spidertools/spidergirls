package cn.edu.hfut.dmic.spidergirls.CrawlResults;

import cn.edu.hfut.dmic.spidergirls.SearchEngineResults.Results;
import cn.edu.hfut.dmic.spidergirls.Snippet.Snippets;
import cn.edu.hfut.dmic.spidergirls.io.SaveResults;

/**
 * Created by cds on 2015/10/22.
 */
public class CrawledSearchResults {
    private static Snippets snippets;

    public static void getAndSaveResults(String keyWord, int pageTotalNum) {
        snippets = Results.getEngineResults(keyWord, pageTotalNum);//获得结果
        SaveResults.writeResToFile(snippets);//保存结果
    }
}
