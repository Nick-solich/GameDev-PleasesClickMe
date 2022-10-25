package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.Main;

public class SettingMenu extends VBox {
	public SettingMenu() {
		initializeSettingMenu();
		BasicButton backButton = new BasicButton("Back", 200, 50);
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---MAIN MENU---");
				Main.mainStage.setScene(Main.mainMenu);
			}
		});
		this.getChildren().add(backButton);
	}

	public void initializeSettingMenu() {
		this.setPrefWidth(600);
		this.setPrefHeight(500);
		this.setAlignment(Pos.CENTER);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.web("#99f5ff"), CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
