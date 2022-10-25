package gui.game;

import gui.BasicButton;
import javafx.geometry.Insets;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import logic.Player;
import main.Main;

public class PlayerView extends GridPane {
	public static Label moneyLabel;
	private BasicButton backButton;
	private UpgradeItemPerHit upgradeItemPerHit;

	public PlayerView() {
		initializePlayerView();
		initializeMoneyLabel();
		initializeBackButton();
		initializeUpgradeItemPerHit();
		this.add(PlayerView.moneyLabel, 0, 1);
		this.add(backButton, 0, 0);
		this.add(upgradeItemPerHit, 0, 2);
	}

	public void initializeMoneyLabel() {
		// Label for show total
		moneyLabel = new Label(Player.displayMoney());
		moneyLabel.setPrefHeight(50);
		moneyLabel.setPrefWidth(200);
//		moneyLabel.setBorder(new Border(
//				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		// moneyLabel.setBackground(new Background(new BackgroundFill(Color.WHEAT,
		// CornerRadii.EMPTY, Insets.EMPTY)));
		moneyLabel.setStyle("-fx-font-size: 22px;");
	}

	public void initializeBackButton() {
		// Back Button
		backButton = new BasicButton("Back", 200, 50);
		backButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("---MAIN MENU----");
				Main.mainStage.setScene(Main.mainMenu);
			}
		});
	}

	public void initializeUpgradeItemPerHit() {
		upgradeItemPerHit = new UpgradeItemPerHit();
		upgradeItemPerHit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				UpgradeItemPerHitHandler(upgradeItemPerHit);
			}
		});
	}

	private void UpgradeItemPerHitHandler(UpgradeItemPerHit upgradeItemPerHit) {
		if (Player.getPlayerMoney() >= upgradeItemPerHit.getItemPerHit().getTotalPrice()) {
			Player.takePlayerMoney(upgradeItemPerHit.getItemPerHit().getTotalPrice());// Decrease Player Money = Total
																						// Price
			PlayerView.getMoneyLabel().setText(Player.displayMoney());
			upgradeItemPerHit.getItemPerHit().upgrade();
			Player.setCurrentDamagePerHit(upgradeItemPerHit.getItemPerHit().getTotalDamage());// Damage Per Hit Equal to
																								// Display
			upgradeItemPerHit.setText();
			String musicFile = upgradeItemPerHit.getItemPerHit().getSoundName(); // For example
			AudioClip sound2 = new AudioClip(ClassLoader.getSystemResource(musicFile).toString());
			sound2.play();
		} else {
			System.out.println("Money not Enough to Upgrade This Item");
		}
	}

	public void initializePlayerView() {
		this.setMinWidth(250);
		this.setMinHeight(500);
		this.setMaxWidth(250);
		this.setMaxHeight(500);
		this.setPadding(new Insets(15));
//		this.setBorder(new Border(
//				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//		this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public static Label getMoneyLabel() {
		return moneyLabel;
	}

}
