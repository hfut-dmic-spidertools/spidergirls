package cn.edu.hfut.dmic.spidergirls.search;

import cn.edu.hfut.dmic.spidergirls.model.SearchItem;
import cn.edu.hfut.dmic.spidergirls.model.SearchItems;
import cn.edu.hfut.dmic.spidergirls.util.Config;
import cn.edu.hfut.dmic.spidergirls.util.HttpUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by cds on 2015/10/22.
 */
public class Search{

    public static Logger LOG=LoggerFactory.getLogger(Search.class);

    public static SearchItems search(String keyword,String engineName,int pageCount) throws UnsupportedEncodingException {
        SearchItems results=new SearchItems();
        Rule.ExtractRule eRule=Config.defaultRule.getExtractRule(engineName);

        for(int pageNum=1;pageNum<=pageCount;pageNum++){
            StringBuilder sb=new StringBuilder();
            int pageCode=pageNum*eRule.pageMulti+eRule.pageOffset;
            sb.append(eRule.baseURL)
            .append(eRule.queryParam)
            .append("=")
            .append(URLEncoder.encode(keyword,"utf-8"))
            .append("&")
            .append(eRule.pageParam)
            .append("=")
            .append(pageCode);

            String url=sb.toString();
            try {
                Document doc= HttpUtils.fetchDoc(url);
                Elements itemEls=doc.select(eRule.itemCSS);
                int resultNum = 0;

                for(Element element: itemEls) {
                    resultNum++;

                    Element element_a = element.select(eRule.titleCSS).first();
                    if(element_a == null)
                        continue;
                    String title = element_a.text().trim();

                    String link = element_a.attr("href");

                    String content = null;
                    Element element_p = element.select(eRule.contentCSS).first();
                    if(element_p == null)
                        continue;
                    content = element_p.text().trim();

                    System.out.println(resultNum);
//                System.out.println("title\t" + title);
//                System.out.println("link\t" + link);
//                System.out.println("content\t" + content);
//                System.out.println();

                    SearchItem searchItem = new SearchItem(title, link, content);

                    results.add(searchItem);
//                if(resultNum == neededNum)
//                    break;



                }

//            if(resultNum < neededNum)
//                lackNum =lackNum + (neededNum - resultNum);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return results;
    }



    public static void main(String args[]) throws UnsupportedEncodingException {//test
        //  createURL("jisuanji",10);
        ArrayList<SearchItem> arr = new ArrayList<SearchItem>();


        arr = Search.search("computer", "bing", 2);

        System.out.println("output:");
        SearchItem sni = null;
        for(int i = 0; i < arr.size(); i++) {
            sni = arr.get(i);
            System.out.println("result\t" + (i + 1));
            System.out.println("title\t" + sni.getTitle());
            System.out.println("link\t" + sni.getLink());
            System.out.println("content\t" + sni.getContent());
            System.out.println();
        }
    }


}

