package com.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import com.application.DigitalGauge;

public class MainController implements Initializable {
	@FXML
	private StackPane stackPaneGaugeKMH;
	@FXML
	private StackPane stackPaneGaugeRPM;
	@FXML
	private StackPane stackPaneGaugeGear;
	@FXML
	private StackPane stackPaneGaugeShift;
	
	private DigitalGauge gaugeKMH;
	private DigitalGauge gaugeRPM;
	private DigitalGauge gaugeGear;
	private DigitalGauge gaugeShift;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gaugeKMH = new DigitalGauge(3);
		gaugeRPM = new DigitalGauge(4);
		gaugeGear = new DigitalGauge(1);
		gaugeShift = new DigitalGauge(1);
		stackPaneGaugeKMH.getChildren().add(gaugeKMH);
		stackPaneGaugeRPM.getChildren().add(gaugeRPM);
		stackPaneGaugeGear.getChildren().add(gaugeGear);
		stackPaneGaugeShift.getChildren().add(gaugeShift);
	}

}
