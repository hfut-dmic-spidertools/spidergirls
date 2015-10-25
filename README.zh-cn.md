# SpiderGirls
SpiderGirls是一个java的搜索引擎爬取框架，可以用来爬取不同搜索引擎的查询结果。


##主页
[https://github.com/hfut-dmic-spidertools/spidergirls](https://github.com/hfut-dmic-spidertools/spidergirls)


##安装

SpiderGirls jars可以在主页上获得。 [主页](https://github.com/hfut-dmic-spidertools/spidergirls)

+ __spidergirls-0.1-betaq-bin.zip__ contains core jars.


##接口介绍
Search.search(String keyword,String engineName,int pageCount)
+ keyword -- 搜索的关键词
+ engineName -- 搜索引擎的名字，即是选择获取结果的搜索引擎，现在支持Bing搜索和SouGou搜索
+ pageCount -- 获取搜索引擎结果的页数


##举例
获取Bing搜索关键词computer的两页结果
    public static void main(String args[]) {
       
        SearchItems arr = new SearchItems();


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


##版本号 
0.1

