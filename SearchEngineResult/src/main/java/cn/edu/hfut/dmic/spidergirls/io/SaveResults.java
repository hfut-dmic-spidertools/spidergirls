package cn.edu.hfut.dmic.spidergirls.io;

import cn.edu.hfut.dmic.spidergirls.Snippet.Snippet;
import cn.edu.hfut.dmic.spidergirls.Snippet.Snippets;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by cds on 2015/10/22.
 */
public class SaveResults {
    public static void writeResToFile(Snippets snippets) {

        File file = null;
        try {
                file = new File(IOconfig.getIOconfigDic() + snippets.name + ".txt");
                if(!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        ArrayList<Snippet> arrSni = snippets.snippets;

        try {
            FileWriter fileWriter = new FileWriter(file,true);//²»¸²¸Ç

            for(int i = 0; i < arrSni.size(); i++) {
                fileWriter.write(String.valueOf(i));
                fileWriter.write("\r\n");
                fileWriter.write("title\t" + arrSni.get(i).getTitle());
                fileWriter.write("\r\n");
                fileWriter.write("link\t" + arrSni.get(i).getLink());
                fileWriter.write("\r\n");
                fileWriter.write("content\t" + arrSni.get(i).getContent());
                fileWriter.write("\r\n");
                fileWriter.write("\r\n");

            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
