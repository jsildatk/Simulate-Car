package com.application.controller;

import java.util.concurrent.ThreadLocalRandom;

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

	public static void engineBrake() {
		if (!throttle.isPressed() && engine.isTurnedOn()) {
			int randomNumber = ThreadLocalRandom.current().nextInt(1, 6);
			engine.setKph(engine.getKph() - randomNumber);
			resetGauges();
			refreshGauges();
		}
	}
}
