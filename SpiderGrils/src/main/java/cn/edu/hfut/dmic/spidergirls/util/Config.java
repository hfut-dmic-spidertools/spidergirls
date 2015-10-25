package cn.edu.hfut.dmic.spidergirls.util;

import cn.edu.hfut.dmic.spidergirls.search.Rule;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by cds on 2015/10/23.
 */
public class Config {

    public static Rule defaultRule=null;

    static{

        InputStream is = Rule.class.getResourceAsStream("/rule.json");
        try {
            defaultRule=Rule.createFromInputStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
