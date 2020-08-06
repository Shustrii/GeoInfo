package edu.kursova.general;

import edu.kursova.panels.*;

public class ReferencesBroker {
    private static SettingsPanel1 sp1;
    private static SettingsPanel2 sp2;

    private static ButtonsPanel1 bp1;
    private static FiguresPanel fp;
    private static StatisticsPanel st;
    private static secondStatPanel st2;

    public static void setSettingsPanel1Ref(SettingsPanel1 s){
        sp1 = s;
    }

    public static SettingsPanel1 getSettingsPanel1Ref(){
        return sp1;
    }
    public static void setSettingsPanel2Ref(SettingsPanel2 s){
        sp2 = s;
    }

    public static SettingsPanel2 getSettingsPanel2Ref(){
        return sp2;
    }


    public static void setFiguresPanelRef(FiguresPanel f){
        fp = f;
    }

    public static FiguresPanel getFiguresPanelRef(){
        return fp;
    }
    public static void setStatisticsPanel(StatisticsPanel s){
        st = s;
    }

    public static StatisticsPanel getStatisticsPanel(){
        return st;
    }
    public static void  setStatisticsPanel2(secondStatPanel s){
        st2 = s;
    }
    public  static secondStatPanel getStatisticsPanel2(){
        return st2;
    }


}
