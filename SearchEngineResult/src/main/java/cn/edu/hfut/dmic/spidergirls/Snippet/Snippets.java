package cn.edu.hfut.dmic.spidergirls.Snippet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sam on 14-10-9.
 */
public class Snippets implements Serializable {
    public Snippets(String name, ArrayList<Snippet> snippets) {
        this.name = name;
        this.snippets = snippets;
    }
    public String name="";
    public ArrayList<Snippet> snippets;

}
