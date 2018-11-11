package com.application;

import java.util.ArrayList;
import java.util.List;

public class GearBox {
	private boolean isBroken;
	public static List<String> gears;
	
	public GearBox() {
		this.isBroken = false;
		GearBox.gears = new ArrayList<String>();
		gears.add("R");
		gears.add("N");
		gears.add("1");
		gears.add("2");
		gears.add("3");
		gears.add("4");
		gears.add("5");
		gears.add("6");
	}

	public boolean isBroken() {
		return isBroken;
	}

	public void setBroken(boolean isBroken) {
		this.isBroken = isBroken;
	}

	public static String getGear(String gear) {
		for (String g : gears) {
			if (g == gear) {
				return g;
			}
		}
		return "N";
	}

	public static void setGears(String gear, int index) {
		gears.set(index, gear);
	}
}
