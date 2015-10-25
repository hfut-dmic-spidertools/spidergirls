package cn.edu.hfut.dmic.spidergirls.util;

import cn.edu.hfut.dmic.spidergirls.model.SearchItem;
import cn.edu.hfut.dmic.spidergirls.model.SearchItems;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

/**
 * Created by cds on 2015/10/23.
 */
public class FileUtils {


    public static void writeJsonFile(SearchItem item,String fileName) throws Exception {
        FileOutputStream fos=new FileOutputStream(fileName,false);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos,"utf-8"));
        JSONObject jo=item.toJSON();
        bw.write(jo.toString());
        bw.close();
    }

    public static void writeJsonFile(SearchItems items,String fileName) throws Exception {
        FileOutputStream fos=new FileOutputStream(fileName,false);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos,"utf-8"));
        JSONArray ja=items.toJSON();
        bw.write(ja.toString());
        bw.close();
    }

}
