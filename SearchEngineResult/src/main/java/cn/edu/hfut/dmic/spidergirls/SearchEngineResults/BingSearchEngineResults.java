package cn.edu.hfut.dmic.spidergirls.SearchEngineResults;

import cn.edu.hfut.dmic.spidergirls.Snippet.Snippet;
import cn.edu.hfut.dmic.spidergirls.URL.BingURL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by cds on 2015/10/22.
 */
public class BingSearchEngineResults {

    private ArrayList<Snippet> snippetsRes = null;
    int lackNum = 0;

    public BingSearchEngineResults() {
        snippetsRes = new ArrayList<Snippet>();
    }

    public ArrayList<Snippet> getBingSearchResults(String keyWord, int pageTotalNum) {
        ArrayList<Snippet> snippets = new ArrayList<Snippet>();
        snippets = crawlSearchResults(keyWord,pageTotalNum);
        return snippets;
    }

    private ArrayList<Snippet> crawlSearchResults (String keyWord, int pageTotalNum) {
        int firstPageNum = pageTotalNum/10;
        int restNum = pageTotalNum%10;
        System.out.println("firstPageNum\t" + firstPageNum);
        System.out.println("restNum\t" + restNum);
        System.out.println();

        String url = null;

        for(int i = 0; i < firstPageNum; i++) {
            url = BingURL.createURL(keyWord, i * 10);
            getOnePageResults(url, 10);
        }

        System.out.println("lackNum\t" + lackNum);
        restNum = restNum + lackNum;
        System.out.println("lackNum + restNum\t" + restNum);
        if(restNum/10 > 0) {
            url = BingURL.createURL(keyWord, firstPageNum * 10);
            getOnePageResults(url, 10);
            restNum = restNum % 10;
            firstPageNum++;
        }

        if(restNum != 0) {
            url = BingURL.createURL(keyWord, firstPageNum*10);
            getOnePageResults(url, restNum);
        }

        return snippetsRes;

    }

    private void getOnePageResults(String url, int neededNum) {
        try {
            Document doc = Jsoup.connect(url).get();

            Element element1 = doc.select("div[id=b_content]").first();
            Element element2 = element1.select("ol[id=b_results]").first();
            Elements elements1 = element2.select("li[class=b_algo]");

            int resultNum = 0;

            for(Element element: elements1) {
                resultNum++;

                Element element_h2 = element.select("h2").first();
                if(element_h2 == null)
                    continue;
                Element element_a = element_h2.select("a[href]").first();

                String title = element_a.text().trim();

                String link = element_a.attr("href");

                String content = null;
                Element element_div = element.select("div[class^=b_caption]").first();
                if(element_div == null)
                    continue;
                Element element_p = element_div.select("p").first();
                content = element_p.text().trim();

                System.out.println(resultNum);
//                System.out.println("title\t" + title);
//                System.out.println("link\t" + link);
//                System.out.println("content\t" + content);
//                System.out.println();

                Snippet snippet = new Snippet(title, link, content);
                snippetsRes.add(snippet);

                if(resultNum == neededNum)
                    break;

            }

            if(resultNum < neededNum)
                lackNum =lackNum + (neededNum - resultNum);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String args[]) {//test
        //  createURL("jisuanji",10);
        ArrayList<Snippet> arr = new ArrayList<Snippet>();
        BingSearchEngineResults ser = new BingSearchEngineResults();

        arr = ser.getBingSearchResults("computer", 124);

        System.out.println("output:");
        Snippet sni = null;
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

