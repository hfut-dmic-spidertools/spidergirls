package cn.edu.hfut.dmic.spidergirls.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sam on 14-10-9.
 */
public class SearchItems extends  ArrayList<SearchItem>{

    public JSONArray toJSON(){

        JSONArray ja=new JSONArray();
        for(SearchItem si:this){
            ja.put(si.toJSON());
        }
        return ja;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(SearchItem search:this){
            sb.append(search+"\n");
        }
        return sb.toString();
    }
}
