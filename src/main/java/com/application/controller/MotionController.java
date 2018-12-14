package com.application.controller;

import java.util.concurrent.ThreadLocalRandom;

public class MotionController extends MainController {
	private static int randomNumber;
	
	static void accelerate() {
		if (engine.isTurnedOn()) {
			if (clutch.isPressed() || engine.getActiveGear() == "N") {
				randomNumber = ThreadLocalRandom.current().nextInt(120, 141);
				engine.setRpm(engine.getRpm() + randomNumber);
			} else if (engine.getRpm() >= engine.getMaxRpm()) {
				engine.setKph(engine.getKph());
			} else {
				randomNumber = ThreadLocalRandom.current().nextInt(1, 4);
				engine.setKph(engine.getKph() + randomNumber);
			}
			resetGauges();
			refreshGauges();
		}
	}

	static void brake() {
		if (engine.isTurnedOn()) {
			randomNumber = ThreadLocalRandom.current().nextInt(4, 7);
			engine.setKph(engine.getKph() - randomNumber);
			resetGauges();
			refreshGauges();
		}
	}

	public static void engineBrake() {
		if (engine.isTurnedOn()) {
			if (!throttle.isPressed() && !brake.isPressed() && !clutch.isPressed() && engine.getActiveGear() != "N") {
				randomNumber = ThreadLocalRandom.current().nextInt(1, 4);
				engine.setKph(engine.getKph() - randomNumber);
				resetGauges();
				refreshGauges();
			}
		}
	}
}
