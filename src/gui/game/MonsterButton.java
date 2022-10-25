package gui.game;

import java.io.File;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import logic.GameManager;
import logic.Player;

public class MonsterButton extends Pane {
	public static ImageView monsterImage;

	public MonsterButton() {
		initializeMonsterButton();
		initializeImage();
		this.getChildren().add(monsterImage);
	}

	public void initializeMonsterButton() {
		this.setPrefHeight(360);
		this.setPrefWidth(360);
		this.setMaxWidth(360);
		this.setMaxHeight(360);
		// monsterCell.setPadding(new Insets(8));
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// TODO fill in this method
				onClickHandler();
			}
		});
	}

	public void initializeImage() {
		String image_path = GameManager.currentMonster.getImageName();
		monsterImage = new ImageView(new Image(image_path));
		monsterImage.setFitHeight(330);
		monsterImage.setFitWidth(330);
		monsterImage.setPreserveRatio(true);
	}

	public static void settingImage() {
		String image_path = GameManager.currentMonster.getImageName();
		monsterImage.setImage(new Image(image_path));
		if (GameManager.isBoss()) {
			monsterImage.setFitHeight(360);
			monsterImage.setFitWidth(360);
		} else {
			monsterImage.setFitHeight(340);
			monsterImage.setFitWidth(340);
		}
	}

	public void onClickHandler() {
		// Need To Insert Handler
		System.out.println("Monster No." + GameManager.getKillCount() + " ,Is Boss =" + GameManager.isBoss());

		String musicFile = "sound/click.wav"; // For example
		AudioClip sound = new AudioClip(ClassLoader.getSystemResource(musicFile).toString());
		sound.play();
		if (GameManager.currentMonster.getCurrentHp() <= 0) {
			Player.increasePlayerMoney(GameManager.currentMonster.getDropPrice());
			PlayerView.moneyLabel.setText(Player.displayMoney());
			System.out.println("Create New Monster");
			GameManager.setKillCount(GameManager.getKillCount() + 1);
			GameManager.createMonster();
			MonsterInform.setToCurrentMonster();
		} else {
			System.out.println("Do Damage");
			Player.doDamagePerHit();
			MonsterInform.monsterHp.setText("HP : " + GameManager.currentMonster.getCurrentHp() + " / "
					+ GameManager.currentMonster.getMaxHp());
			if (GameManager.currentMonster.getCurrentHp() <= 0)
				onClickHandler();
		}
	}

}
