package cn.edu.hfut.dmic.spidergirls;

import cn.edu.hfut.dmic.spidergirls.model.SearchItems;


/**
 * Created by cds on 2015/10/21.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {


        SearchItems items= SpiderGirls.search("中国", 3);
        System.out.println(items);
        //ileUtils.writeJsonFile(items, "result2.json");

    }
}
