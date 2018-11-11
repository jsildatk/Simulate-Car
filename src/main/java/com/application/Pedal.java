package com.application;

public class Pedal {
	private boolean isPressed;
	
	public Pedal() {
		this.isPressed = false;
	}

	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}
	
}
