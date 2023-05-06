package com.kon.bnmo.plugin.plugin1;

import javafx.scene.chart.*;

import java.util.HashMap;

public class ChartBar {
    private BarChart<String,Number> barChart;
    private String title;

    public ChartBar(){
        barChart = new BarChart<String,Number>(new CategoryAxis(),new NumberAxis());
        barChart.setTitle("");
    }


    public BarChart getBarChart(){
        return barChart;
    }

    public void setTitle(String title){
        barChart.setTitle(title);
    }

    public void AddDataBarChart(String nation, double population){
        XYChart.Series series = new XYChart.Series();
        series.setName(nation);
        series.getData().add(new XYChart.Data(nation, population));
        barChart.getData().add(series);
    }

    public void ImportData(HashMap<String,Integer> map){
        for(String key : map.keySet()){
            AddDataBarChart(key, map.get(key));
        }
    }

}
