package com.application.controller;

public class MotionController extends MainController {
	static void clutched() {
		if (engine.isTurnedOn()) {
			if (clutch.isPressed() || engine.getActiveGear() == "N") {
				engine.setRpm(engine.getMinRpm());
			}
			resetGauges();
			refreshGauges();
		}
	}
	
	static void accelerate() {
		if (engine.isTurnedOn()) {
			if (clutch.isPressed() || engine.getActiveGear() == "N") {
				engine.setRpm(engine.getRpm() + 130);
			} else {
				engine.setKph(engine.getKph() + 3);
				engine.setRpm(engine.getMinRpm() + (engine.getKph() * 7));
			}
			resetGauges();
			refreshGauges();
		}
	}
	
	static void brake() {
		if (engine.isTurnedOn()) {
			if (clutch.isPressed()) {
				engine.setRpm(engine.getMinRpm());
			} else {
				engine.setRpm(engine.getMinRpm() + (engine.getKph() * 7));
			}
			engine.setKph(engine.getKph() - 7);
			resetGauges();
			refreshGauges();
		}
	}
}
