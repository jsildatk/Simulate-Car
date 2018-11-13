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
	private Rectangle rectangleBrake;
	@FXML
	private Rectangle rectangleThrottle;
	@FXML
	private Circle circleEngine;
	
	private static DigitalGauge gaugeKph;
	private static DigitalGauge gaugeRpm;
	private static DigitalGauge gaugeGear;
	private static DigitalGauge gaugeShift;
	protected static Pedal clutch;
	private Pedal brake;
	private Pedal throttle;
	protected static Engine engine;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		engine = new Engine(1000, 9000, 200);
		clutch = new Pedal();
		brake = new Pedal();
		throttle = new Pedal();
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
			MotionController.clutched();
		}
		
		if (event.getCode() == KeyCode.DOWN) {
			brake.setPressed(true);
			rectangleBrake.setFill(Color.GREEN);
			MotionController.brake();
		}
		
		if (event.getCode() == KeyCode.UP) {
			throttle.setPressed(true);
			rectangleThrottle.setFill(Color.GREEN);
			MotionController.accelerate();
		}
		
		GearBoxController.changeGear(event);
		
		event.consume();
	}
	
	@FXML
	public void releasePedal(KeyEvent event) {
		if (event.getCode() == KeyCode.SPACE) {
			clutch.setPressed(false);
			rectangleClutch.setFill(Color.web("#d01515"));
		}
		
		if (event.getCode() == KeyCode.DOWN) {
			brake.setPressed(false);
			rectangleBrake.setFill(Color.web("#d01515"));
		}
		
		if (event.getCode() == KeyCode.UP) {
			throttle.setPressed(false);
			rectangleThrottle.setFill(Color.web("#d01515"));
		}
	
		event.consume();
	}
	
	@FXML
	public void startStopEngine() {
		if (clutch.isPressed() && !engine.isTurnedOn()) {
			engine.turnOnEngine();
			refreshGauges();
			circleEngine.setFill(Color.GREEN);
		} else if (engine.getKph() == 0 && engine.isTurnedOn()) {
			engine.turnOffEngine();
			resetGauges();
			circleEngine.setFill(Color.web("#d01515"));
		}
	}
	
	protected static void refreshGauges() {
		if (engine.getRpm() < engine.getMinRpm()) {
			engine.setRpm(engine.getMinRpm());
		}
		
		if (engine.getKph() <= 0) {
			engine.setKph(0);
		}
		
		gaugeRpm.refreshDigits(String.valueOf(engine.getRpm()));
		gaugeKph.refreshDigits(String.valueOf(engine.getKph()));
		gaugeGear.refreshDigits(engine.getActiveGear());
	}
	
	protected static void resetGauges() {
		gaugeRpm.resetDigits();
		gaugeKph.resetDigits();
		gaugeGear.resetDigits();
	}
	
}
