package com.application;

import java.util.ArrayList;
import java.util.List;

public class GearBox {
	private static boolean isBroken = false;
	
	@SuppressWarnings("serial")
	public static final List<String> gears = new ArrayList<String>() {{
		add("R");
		add("N");
		add("1");
		add("2");
		add("3");
		add("4");
		add("5");
		add("6");
		add("7");
	}};
	
	public static boolean isBroken() {
		return isBroken;
	}

	public static void setBroken(boolean isBroken) {
		GearBox.isBroken = isBroken;
	}

	public static String getGear(String gear) {
		if (gears.contains(gear)) {
			return gear;
		}
		return "N";
	}

}
