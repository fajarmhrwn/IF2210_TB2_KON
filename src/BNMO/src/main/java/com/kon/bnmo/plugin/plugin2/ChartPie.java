package com.kon.bnmo.plugin.plugin2;


import javafx.scene.chart.PieChart;

import java.util.HashMap;

public class ChartPie {
    private PieChart chart;
    private String title;

    public ChartPie(){
        chart = new PieChart();
        chart.setTitle("");
    }

    public PieChart getChart(){
        return chart;
    }
    public void setTitle(String title){
        chart.setTitle(title);
    }
    public void AddData(String nation, double population){
        chart.getData().add(new PieChart.Data(nation, population));
    }

    public void ImportData(HashMap<String,Integer> map){
        for(String key : map.keySet()){
            AddData(key, map.get(key));
        }
    }

}
