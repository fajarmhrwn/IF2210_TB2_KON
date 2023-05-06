package com.kon.bnmo.plugin.plugin1;

import javafx.scene.chart.*;

import java.util.HashMap;

public class ChartLine {
    private LineChart<String,Number> lineChart;
    private String title;

    public ChartLine(){
        lineChart = new LineChart<String,Number>(new CategoryAxis(),new NumberAxis());
        lineChart.setTitle("");
    }

    public LineChart getLineChart(){
        return lineChart;
    }



    public void setTitle(String title){
        lineChart.setTitle(title);
    }

    public void AddDataLineChart(String nation, double population){
        XYChart.Series series = new XYChart.Series();
        series.setName(nation);
        series.getData().add(new XYChart.Data(nation, population));
        lineChart.getData().add(series);
    }


    public void ImportData(HashMap<String,Integer> map){
        for(String key : map.keySet()){
            AddDataLineChart(key, map.get(key));
        }
    }

}
