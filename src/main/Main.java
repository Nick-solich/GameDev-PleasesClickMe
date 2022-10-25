package main;

import gui.GameMenu;
import gui.MainMenu;
import gui.SettingMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logic.GameManager;

public class Main extends Application {
	public static Stage mainStage;
	public static Scene mainMenu, settingMenu, gameMenu;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Main.mainStage = primaryStage;
		// Set Up Game Logic
		GameManager.setUpGame();

		// Set Up Scene
		MainMenu mainMenu = new MainMenu();
		SettingMenu settingMenu = new SettingMenu();
		GameMenu gameMenu = new GameMenu();

		Main.mainMenu = new Scene(mainMenu, 600, 500);
		Main.settingMenu = new Scene(settingMenu, 600, 500);
		Main.gameMenu = new Scene(gameMenu, 1300, 750);

		Main.mainStage.setScene(Main.mainMenu);
		Main.mainStage.setTitle("Please Click Me");
		Main.mainStage.setResizable(false);
		Main.mainStage.getIcons().add(new Image("icon.png"));
		Main.mainStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
