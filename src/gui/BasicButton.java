package gui;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class BasicButton extends Button {
	public BasicButton(String name, int width, int height) {
		this.setText(name);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setFont(new Font("Cambria", 20));
	}
}
