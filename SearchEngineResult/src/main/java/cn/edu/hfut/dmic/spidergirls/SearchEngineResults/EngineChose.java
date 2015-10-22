package cn.edu.hfut.dmic.spidergirls.SearchEngineResults;

/**
 * Created by cds on 2015/10/22.
 */
public class EngineChose {
    private static Boolean choseBing = true;//Ä¬ÈÏÎªBingËÑË÷
    private static Boolean choseSouGou = false;

    public static void ChoseBingEngine() {
        choseBing = true;
        choseSouGou = false;
    }

    public static void ChoseSougouEngine() {
        choseSouGou = true;
        choseBing = false;
    }

    public static Boolean getChoseBing() {
        return choseBing;
    }

    public static Boolean getChoseSouGou() {
        return choseSouGou;
    }
}
