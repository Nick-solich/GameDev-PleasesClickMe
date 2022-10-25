package gui.game;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import logic.Player;

public class UpgradeControlPanel extends HBox {

	public UpgradeControlPanel() {
		super();
		initializeDPS();

	}

	public void initializeDPS() {
		UpgradeItemDPS greenTwin = new UpgradeItemDPS("GreenTwin");
		UpgradeItemDPS purpleTwin = new UpgradeItemDPS("PurpleTwin");
		UpgradeItemDPS archer = new UpgradeItemDPS("Archer");
		UpgradeItemDPS bone = new UpgradeItemDPS("Bone");
		UpgradeItemDPS redWizard = new UpgradeItemDPS("RedWizard");
		UpgradeItemDPS cowboy = new UpgradeItemDPS("Cowboy");
		UpgradeItemDPS fighter = new UpgradeItemDPS("Fighter");
		UpgradeItemDPS bodyguard = new UpgradeItemDPS("Bodyguard");
		UpgradeItemDPS freezeWizard = new UpgradeItemDPS("FreezeWizard");
		UpgradeItemDPS jacksparrow = new UpgradeItemDPS("JackSparrow");
		this.addEventForUnitCellDPS(greenTwin);
		this.addEventForUnitCellDPS(purpleTwin);
		this.addEventForUnitCellDPS(archer);
		this.addEventForUnitCellDPS(bone);
		this.addEventForUnitCellDPS(redWizard);
		this.addEventForUnitCellDPS(cowboy);
		this.addEventForUnitCellDPS(fighter);
		this.addEventForUnitCellDPS(bodyguard);
		this.addEventForUnitCellDPS(freezeWizard);
		this.addEventForUnitCellDPS(jacksparrow);
		this.getChildren().addAll(greenTwin, purpleTwin, archer, bone, redWizard, cowboy, fighter, bodyguard,
				freezeWizard, jacksparrow);

	}

	private void addEventForUnitCellDPS(UpgradeItemDPS unitCell) {
		unitCell.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// TODO fill in this method
				onClickHandler(unitCell);
			}
		});
	}

	private void onClickHandler(UpgradeItemDPS unitCell) {
		System.out.println(Player.getCurrentDPS());
		if (Player.getPlayerMoney() >= unitCell.getItem().getTotalPrice()) {
			Player.takePlayerMoney(unitCell.getItem().getTotalPrice());
			PlayerView.getMoneyLabel().setText(Player.displayMoney());
			unitCell.getItem().upgrade();
			Player.increaseDPS(unitCell.getItem().getInitialDamage());
			unitCell.setText();
			String musicFile = unitCell.getItem().getSoundName();
			AudioClip sound = new AudioClip(musicFile);
			sound.play();
		}
	}
}
