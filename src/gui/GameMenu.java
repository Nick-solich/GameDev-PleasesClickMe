package gui;

import gui.game.MonsterView;
import gui.game.UpgradeControlPanel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameManager;
import main.Main;

public class GameMenu extends VBox {
	private MonsterView monsterView;
	private UpgradeControlPanel upgradeControlPanel;

	public GameMenu() {
		initializeGameMenu();
		monsterView = new MonsterView();
		upgradeControlPanel = new UpgradeControlPanel();
//		// Add To GameMenu
		this.getChildren().addAll(monsterView, upgradeControlPanel);
	}

	public void initializeGameMenu() {
		this.setMinSize(1200, 800);
		this.setPrefSize(1200, 800);
		this.setMaxSize(1200, 800);
		this.setAlignment(Pos.TOP_CENTER);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
	}

}
