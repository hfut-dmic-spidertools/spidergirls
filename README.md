# SpiderGirls
SpiderGirls is an open source web crawler framework based on Java.It provides
  some simple interfaces for crawling the results from kinds of Search Engine. 


##HomePage
[https://github.com/hfut-dmic-spidertools/spidergirls](https://github.com/hfut-dmic-spidertools/spidergirls)


##Installation

SpiderGirls jars are available on the [HomePage](https://github.com/hfut-dmic-spidertools/spidergirls)

+ __spidergirls-0.1-betaq-bin.zip__ contains core jars.


##interface introduce
Search.search(String keyword,String engineName,int pageCount),
+ keyword--search kyword
+　engineName--the name of engine which you want to use,for now we can use bing and sougou search engine
+ pageCount-- the page count of search enginge results


##Demo
  public static void main(String args[]) throws UnsupportedEncodingException {

        ArrayList<SearchItem> arr = new ArrayList<SearchItem>();


        arr = Search.search("computer", "bing", 2);//search engine is bing

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

##Version 
0.1