package cn.edu.hfut.dmic.spidergirls.SearchEngineResults;

import cn.edu.hfut.dmic.spidergirls.Snippet.Snippet;
import cn.edu.hfut.dmic.spidergirls.Snippet.Snippets;

import java.util.ArrayList;

/**
 * Created by cds on 2015/10/22.
 */
public class Results {
    public static Snippets getEngineResults (String keyWord, int pageTotalNum) {
        ArrayList<Snippet> resOfkeyWord = new ArrayList<Snippet>();

        if(EngineChose.getChoseBing() == true && EngineChose.getChoseSouGou() == false) {
            resOfkeyWord = (new BingSearchEngineResults()).getBingSearchResults(keyWord, pageTotalNum);
        }
        if(EngineChose.getChoseSouGou() == true && EngineChose.getChoseBing() == false) {

        }

        Snippets snippets = new Snippets(keyWord, resOfkeyWord);

        return snippets;

    }
}
