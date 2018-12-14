package com.application;

import java.util.ArrayList;
import java.util.List;

public class GearBox {
	@SuppressWarnings("serial")
	public static final List<String> gears = new ArrayList<String>() {{
		add("N");
		add("1");
		add("2");
		add("3");
		add("4");
		add("5");
		add("6");
		add("7");
	}};

	public static String getGear(String gear) {
		if (gears.contains(gear)) {
			return gear;
		}
		return "N";
	}

}
