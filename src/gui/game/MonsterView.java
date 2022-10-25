package gui.game;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.GameManager;

public class MonsterView extends HBox {
	private PlayerView playerView;
	private MonsterInform monsterInform;
	private StageView stageView;

	public MonsterView() {
		initializeMonsterView();
		playerView = new PlayerView();
		monsterInform = new MonsterInform();
		stageView = new StageView();

		// Add all to MonsterView
		this.getChildren().addAll(playerView, monsterInform, stageView);

	}

	public void initializeMonsterView() {
		this.setMinWidth(1200);
		this.setMinHeight(500);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
