package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label firstLabel = new Label("Monthly savings");
        Label secondLabel = new Label("Yearly interest rate");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setBlockIncrement(25);
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickLabels(true);
        Label savingSliderValueLabel = new Label(String.valueOf(savingsSlider.getValue()));
        Label interestSliderValueLabel = new Label(String.valueOf(interestSlider.getValue()));

        NumberAxis years = new NumberAxis();
        NumberAxis amount = new NumberAxis(0, 30, 1);
        LineChart chart = new LineChart(amount, years);
        chart.setTitle("Savings Calculator");

        BorderPane sceneLayout = new BorderPane();
        BorderPane firstLine = new BorderPane();
        firstLine.setPadding(new Insets(10, 10, 5, 10));
        BorderPane secondLine = new BorderPane();
        secondLine.setPadding(new Insets(10, 10, 5, 10));
        VBox topLayout = new VBox(10);
        firstLine.setLeft(firstLabel);
        firstLine.setCenter(savingsSlider);
        firstLine.setRight(savingSliderValueLabel);
        secondLine.setLeft(secondLabel);
        secondLine.setCenter(interestSlider);
        secondLine.setRight(interestSliderValueLabel);

        topLayout.getChildren().addAll(firstLine, secondLine);
        sceneLayout.setTop(topLayout);
        sceneLayout.setCenter(chart);

        XYChart.Series savingsData = new XYChart.Series();
        savingsData.setName("Savings");
        XYChart.Series interestData = new XYChart.Series();
        interestData.setName("Interest");

        savingsSlider.valueProperty().addListener((event) -> {
            savingsData.getData().clear();
            savingSliderValueLabel.setText(String.valueOf(savingsSlider.getValue()));
            double getSliderAmount = savingsSlider.getValue();
            int operation = 0;
            for (int i = 0; i < 30; i++) {
                operation += getSliderAmount*12;
                savingsData.getData().add(new XYChart.Data(i, operation));
            }
        });

        interestSlider.valueProperty().addListener((event) -> {
            interestData.getData().clear();
            interestSliderValueLabel.setText(String.valueOf(interestSlider.getValue()));
            double savingSliderData = savingsSlider.getValue();
            double  interestSliderData = interestSlider.getValue();
            double operation = 0;
            double interest =  interestSliderData /100; 
            for (int i = 0; i < 31; i++) {
                operation += savingSliderData*12 + (operation*interest);
                interestData.getData().add(new XYChart.Data(i, operation));
            }
        });
        chart.getData().add(savingsData);
        chart.getData().add(interestData);
        Scene scene = new Scene(sceneLayout);
        stage.setScene(scene);
        stage.show();

    }
    

}
