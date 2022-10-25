package gui;

import data.BackgroundUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameManager;
import main.Main;

public class MainMenu extends StackPane {
	private VBox mainMenu;
	private VBox controlPanel;
	private VBox gameName;

	public MainMenu() {
		// Initialize Main scene
		initializeLabel();
		initializeAllButton();
		initializeMainMenu();
		initializeStackPane();
		// Selected Background
		ImageView background = new ImageView(new Image(BackgroundUtil.randomBackgroundUrl()));
		background.setFitHeight(600);
		background.setFitWidth(600);
		// Add All
		this.getChildren().addAll(background, mainMenu);
		this.setAlignment(Pos.CENTER);
	}

	public void initializeStackPane() {
		this.setPrefWidth(600);
		this.setPrefHeight(500);
		// this.setSpacing(35);
		this.setAlignment(Pos.CENTER);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	public void initializeMainMenu() {
		mainMenu = new VBox();
		mainMenu.setPrefWidth(600);
		mainMenu.setPrefHeight(500);
		// this.setSpacing(35);
		mainMenu.setAlignment(Pos.CENTER);
		mainMenu.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		mainMenu.getChildren().addAll(gameName, controlPanel);
	}

	public void initializeLabel() {
		gameName = new VBox();
		Label name = new Label("Please Click Me");
		name.setFont(new Font("Cambria", 50));
		Label gameVersion = new Label("Ver 0.1");
		gameVersion.setFont(new Font("Cambria", 15));
		gameName.setSpacing(0);
		gameName.setMaxWidth(330);
		gameName.setAlignment(Pos.CENTER_RIGHT);
		gameName.getChildren().addAll(name, gameVersion);
	}

	public void initializeAllButton() {
		controlPanel = new VBox();
		controlPanel.setPrefHeight(250);
		controlPanel.setPrefWidth(250);
		controlPanel.setSpacing(20);
		controlPanel.setAlignment(Pos.CENTER);
		// Go to GameMenu
		BasicButton startButton = new BasicButton("Start", 195, 50);
		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---MAIN GAME---");
				Main.mainStage.setScene(Main.gameMenu);
			}
		});
		// Go to Setting Menu
		BasicButton settingButton = new BasicButton("Setting", 195, 50);
		settingButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---SETTING MENU---");
				Main.mainStage.setScene(Main.settingMenu);
			}
		});
		// Exit Game
		BasicButton exitButton = new BasicButton("Exit", 195, 50);
		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("---EXIT GAME---");
				GameManager.startProgram = false; // Stop All Thread In Program
				Main.mainStage.close();
			}
		});
		controlPanel.getChildren().addAll(startButton, settingButton, exitButton);
	}
}
