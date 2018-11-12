package com.application;

import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DigitalGauge extends Parent {
	private final double boxHeight = 12;
	private final double boxWidth = boxHeight * 6 / 8;
	private final double scale = 5;
	private final Font font = new Font(12.8 * scale);
	private HBox hBox = new HBox();
	private Text[] digits;
	private Group[] digitsGroup;
	
	public DigitalGauge(int size) {
		digits = new Text[size];
		digitsGroup = new Group[size];
		configureDigits();
		configureHbox();
		getChildren().add(hBox);
	}
	
	private void configureHbox() {
		hBox.getChildren().addAll(digitsGroup);
		hBox.setSpacing(2);
	}
	
	private void configureDigits() {
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Text(" ");
			digits[i].setFont(font);
			digits[i].setTextOrigin(VPos.TOP);
			digits[i].setLayoutY(-5);
			digits[i].setLayoutX(1);
			Rectangle bg = null;
			bg = createBackground(Color.ANTIQUEWHITE, Color.BLACK);
			digits[i].setFill(Color.BLUE);
			digitsGroup[i] = new Group(bg, digits[i]);
		}
	}

	private Rectangle createBackground(Color fill, Color stroke) {
		Rectangle bg = new Rectangle(boxWidth * scale, boxHeight * scale, fill);
		bg.setStroke(stroke);
		bg.setStrokeWidth(5);
		bg.setEffect(new Lighting());
		return bg;
	}

	public void refreshDigits(String number) {
		if (number.length() == 1) {
			digits[digits.length-1].setText(number);
		} else if (number.length() == 2) {
			digits[digits.length-1].setText(number.substring(1, 2));
			digits[digits.length-2].setText(number.substring(0, 1));
		} else if (number.length() == 3) {
			digits[digits.length-1].setText(number.substring(2, 3));
			digits[digits.length-2].setText(number.substring(1, 2));
			digits[digits.length-3].setText(number.substring(0, 1));
		} else if (number.length() == 4) {
			digits[digits.length-1].setText(number.substring(3, 4));
			digits[digits.length-2].setText(number.substring(2, 3));
			digits[digits.length-3].setText(number.substring(1, 2));
			digits[digits.length-4].setText(number.substring(0, 1));
		} else {
			for (int i = 0; i < number.length(); i++) {
				digits[i].setText(" ");
			}
		}
	}
	
	public void resetDigits() {
		for (int i = 0; i < digits.length; i++) {
			digits[i].setText(" ");
		}
	}
}
