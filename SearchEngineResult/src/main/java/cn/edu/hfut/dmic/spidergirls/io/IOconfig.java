package cn.edu.hfut.dmic.spidergirls.io;

/**
 * Created by cds on 2015/10/22.
 */
public class IOconfig {
    private static String dic = "E:/searchEngineResults/";

    public static void setIOconfigDic(String dictionary) {
        dic = dictionary;
    }

    public static String getIOconfigDic() {
        return dic;
    }
}
