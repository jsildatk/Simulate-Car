package com.application.controller;

import com.application.GearBox;

import javafx.scene.input.KeyEvent;

public class GearBoxController extends MainController {
	static void changeGear(KeyEvent event) {
		if (engine.isTurnedOn() && clutch.isPressed() && !GearBox.isBroken()) {
			switch(event.getCode()) {
			case DIGIT1:
				engine.setActiveGear(GearBox.getGear("1"));
				break;
			
			case DIGIT2:
				engine.setActiveGear(GearBox.getGear("2"));
				break;
				
			case DIGIT3:
				engine.setActiveGear(GearBox.getGear("3"));
				break;
				
			case DIGIT4:
				engine.setActiveGear(GearBox.getGear("4"));
				break;
				
			case DIGIT5:
				engine.setActiveGear(GearBox.getGear("5"));
				break;
				
			case DIGIT6:
				engine.setActiveGear(GearBox.getGear("6"));
				break;
				
			case DIGIT7:
				engine.setActiveGear(GearBox.getGear("7"));
				break;
				
			case N:
				engine.setActiveGear(GearBox.getGear("N"));
				break;
				
			default:
				break;
			}
			
			resetGauges();
			refreshGauges();
		}
	}
}
