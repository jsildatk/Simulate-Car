package com.application;

public class Engine {
	private int minRpm;
	private int rpm;
	private int maxRpm;
	private int kph;
	private int maxKph;
	private String activeGear;
	private boolean isTurnedOn;
	
	public Engine(int minRpm, int maxRpm, int maxKph) {
		this.minRpm = minRpm;
		this.maxRpm = maxRpm;
		this.maxKph = maxKph;
		this.rpm = 0;
		this.kph = 0;
		this.activeGear = "N";
		this.isTurnedOn = false;
	}
	
	public void turnOnEngine() {
		this.rpm = this.minRpm;
		this.kph = 0;
		this.activeGear = "1";
		this.isTurnedOn = true;
	}
	
	public void turnOffEngine() {
		this.rpm = 0;
		this.kph = 0;
		this.activeGear = " ";
		this.isTurnedOn = false;
	}

	public String getActiveGear() {
		return activeGear;
	}

	public void setActiveGear(String activeGear) {
		this.activeGear = activeGear;
	}

	public void setMaxRpm(int maxRpm) {
		this.maxRpm = maxRpm;
	}

	public int getMinRpm() {
		return minRpm;
	}

	public void setMinRpm(int minRpm) {
		this.minRpm = minRpm;
	}

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	public int getMaxRpm() {
		return maxRpm;
	}

	public void setMaxRPM(int maxRpm) {
		this.maxRpm = maxRpm;
	}

	public int getKph() {
		return kph;
	}

	public void setKph(int kph) {
		this.kph = kph;
	}

	public int getMaxKph() {
		return maxKph;
	}

	public void setMaxKph(int maxKph) {
		this.maxKph = maxKph;
	}

	public boolean isTurnedOn() {
		return isTurnedOn;
	}

	public void setTurnedOn(boolean isTurnedOn) {
		this.isTurnedOn = isTurnedOn;
	}
}
