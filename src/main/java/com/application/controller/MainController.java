package com.application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import com.application.DigitalGauge;
import com.application.Engine;
import com.application.GearBox;
import com.application.Pedal;

public class MainController implements Initializable {
	@FXML
	private StackPane stackPaneGaugeKMH;
	@FXML
	private StackPane stackPaneGaugeRPM;
	@FXML
	private StackPane stackPaneGaugeGear;
	@FXML
	private StackPane stackPaneGaugeShift;
	@FXML
	private Rectangle rectangleClutch;
	@FXML
	private Circle circleEngine;
	
	private DigitalGauge gaugeKph;
	private DigitalGauge gaugeRpm;
	private DigitalGauge gaugeGear;
	private DigitalGauge gaugeShift;
	private Pedal clutch;
	private Engine engine;
	private GearBox gearBox;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gearBox = new GearBox();
		engine = new Engine(1000, 9000, 200);
		clutch = new Pedal();
		gaugeKph = new DigitalGauge(3);
		gaugeRpm = new DigitalGauge(4);
		gaugeGear = new DigitalGauge(1);
		gaugeShift = new DigitalGauge(1);
		stackPaneGaugeKMH.getChildren().add(gaugeKph);
		stackPaneGaugeRPM.getChildren().add(gaugeRpm);
		stackPaneGaugeGear.getChildren().add(gaugeGear);
		stackPaneGaugeShift.getChildren().add(gaugeShift);
	}
	
	@FXML
	public void pushPedal(KeyEvent event) {
		if (event.getCode() == KeyCode.SPACE) {
			clutch.setPressed(true);
			rectangleClutch.setFill(Color.GREEN);
		}
		
		event.consume();
	}
	
	@FXML
	public void releasePedal(KeyEvent event) {
		if (event.getCode() == KeyCode.SPACE) {
			clutch.setPressed(false);
			rectangleClutch.setFill(Color.web("#d01515"));
		}
		
		event.consume();
	}
	
	@FXML
	public void startStopEngine() {
		if (clutch.isPressed() && !engine.isTurnedOn()) {
			engine.setTurnedOn(true);
			engine.setRpm(engine.getMinRpm());
			engine.setKph(0);
			engine.setActiveGear(GearBox.getGear("N"));
			gaugeRpm.refreshDigits(String.valueOf(engine.getRpm()));
			gaugeKph.refreshDigits(String.valueOf(engine.getKph()));
			gaugeGear.refreshDigits(engine.getActiveGear());
			circleEngine.setFill(Color.GREEN);
		} else if (engine.getKph() == 0 && engine.isTurnedOn()) {
			engine.turnOfEngine();
			gaugeRpm.resetDigits();
			gaugeKph.resetDigits();
			gaugeGear.resetDigits();
			circleEngine.setFill(Color.web("#d01515"));
		}
	}
}
