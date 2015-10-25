package cn.edu.hfut.dmic.spidergirls.search;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cds on 2015/10/23.
 */
public class Rule {

    public HashMap<String,ExtractRule> eRuleMap=new HashMap<String, ExtractRule>();
    public ArrayList<String> enables=new ArrayList<String>();

    public ExtractRule getExtractRule(String engineName){
        return eRuleMap.get(engineName);
    }
    public void addExtractRule(ExtractRule eRule){
        eRuleMap.put(eRule.name,eRule);
    }

    public void addEnable(String name){
        enables.add(name);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "eRuleMap=" + eRuleMap +
                '}';
    }

    public static class ExtractRule {
        public String baseURL;
        public String queryParam;
        public String pageParam;
        public int pageMulti;
        public int pageOffset;
        public String name;
        public String itemCSS;
        public String titleCSS;
        public String contentCSS;

        public ExtractRule() {

        }

        public ExtractRule(JSONObject jo){
            this.baseURL=jo.getString("baseURL");
            this.queryParam=jo.getString("queryParam");
            this.pageParam=jo.getString("pageParam");
            this.pageMulti=jo.getInt("pageMulti");
            this.pageOffset=jo.getInt("pageOffset");


            this.name=jo.getString("name");
            this.itemCSS=jo.getString("itemCSS");
            this.titleCSS=jo.getString("titleCSS");
            this.contentCSS=jo.getString("contentCSS");
        }

        @Override
        public String toString() {
            return "ExtractRule{" +
                    "name='" + name + '\'' +
                    ", itemCSS='" + itemCSS + '\'' +
                    ", titleCSS='" + titleCSS + '\'' +
                    ", contentCSS='" + contentCSS + '\'' +
                    '}';
        }
    }


    public static Rule createFromInputStream(InputStream is) throws FileNotFoundException {
        Rule rule=new Rule();
        JSONObject jo=new JSONObject(new JSONTokener(is));
        JSONArray ja=jo.getJSONArray("rules");

        JSONArray ja_enable=jo.getJSONArray("enable");
        for(int i=0;i<ja_enable.length();i++){
            rule.addEnable(ja_enable.getString(i));
        }

        for(int i=0;i<ja.length();i++){
            ExtractRule eRule=new ExtractRule(ja.getJSONObject(i));
            rule.addExtractRule(eRule);
        }
        return rule;
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = Rule.class.getResourceAsStream("/rule.json");
        Rule rule=createFromInputStream(is);
        System.out.println(rule);
    }



}
