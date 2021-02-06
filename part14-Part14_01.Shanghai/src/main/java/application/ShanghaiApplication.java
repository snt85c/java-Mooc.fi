package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class ShanghaiApplication extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0,100,10);
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        LineChart <Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");
        XYChart.Series HUData = new XYChart.Series<>();
        HUData.setName("Helsinki U Rating");
        
        HUData.getData().add(new XYChart.Data(2007,73));
        HUData.getData().add(new XYChart.Data(2008,68));
        HUData.getData().add(new XYChart.Data(2009,72));
        HUData.getData().add(new XYChart.Data(2010,72));
        HUData.getData().add(new XYChart.Data(2011,74));
        HUData.getData().add(new XYChart.Data(2012,73));
        HUData.getData().add(new XYChart.Data(2013,76));
        HUData.getData().add(new XYChart.Data(2014,73));
        HUData.getData().add(new XYChart.Data(2015,67));
        HUData.getData().add(new XYChart.Data(2016,56));
        HUData.getData().add(new XYChart.Data(2017,56));
        
        lineChart.getData().add(HUData);
        
         Scene scene = new Scene(lineChart, 640, 480);
         stage.setScene(scene);
         stage.show();
        
        
    }
    
        public static void main(String[] args) {
        launch(args);
    }

}
