package gui.game;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import logic.GameManager;
import logic.Player;

public class MonsterInform extends VBox {
	public static Label monsterName;
	public static MonsterButton monsterButton;
	public static Label monsterHp;

	public MonsterInform() {
		initiallizeMonsterInform();
		settingMonsterName();
		monsterButton = new MonsterButton();
		settingMonsterHp();
		setToCurrentMonster();
		this.getChildren().addAll(monsterName, monsterButton, monsterHp);
	}

	public void settingMonsterName() {
		monsterName = new Label();
		monsterName.setPrefHeight(50);
		monsterName.setPrefWidth(800);
		monsterName.setAlignment(Pos.CENTER);
		monsterName.setStyle("-fx-font-size: 20px;");
	}

	public void settingMonsterHp() {
		monsterHp = new Label();
		monsterHp.setPrefHeight(50);
		monsterHp.setPrefWidth(800);
		monsterHp.setAlignment(Pos.CENTER);
		monsterHp.setStyle("-fx-font-size: 20px;");
	}

	public void initiallizeMonsterInform() {
		this.setSpacing(10);
		this.setMinWidth(700);
		this.setMinHeight(500);
		this.setMaxWidth(700);
		this.setMaxHeight(500);
		this.setAlignment(Pos.BASELINE_CENTER);

	}

	// For Calling By GameManager
	public static void setToCurrentMonster() {
		if (GameManager.isBoss()) {
			monsterName.setTextFill(Color.web("#780be6"));
			monsterName.setStyle("-fx-font-size: 24px;");
			monsterName.setText("Boss " + GameManager.currentMonster.toString());
			MonsterButton.settingImage();
			monsterHp.setTextFill(Color.web("#780be6"));
			monsterHp.setStyle("-fx-font-size: 24px;");
			monsterHp.setText("HP : " + GameManager.currentMonster.getCurrentHp() + " / "
					+ GameManager.currentMonster.getMaxHp());
		} else {
			monsterName.setTextFill(Color.web("#00995c"));
			monsterName.setStyle("-fx-font-size: 20px;");
			monsterName.setText(GameManager.currentMonster.toString());
			MonsterButton.settingImage();
			monsterHp.setTextFill(Color.web("#9e1d03"));
			monsterHp.setStyle("-fx-font-size: 20px;");
			monsterHp.setText("HP : " + GameManager.currentMonster.getCurrentHp() + " / "
					+ GameManager.currentMonster.getMaxHp());
		}
	}
}
