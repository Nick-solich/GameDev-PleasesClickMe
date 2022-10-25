package gui.game;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameManager;

public class StageView extends GridPane {
	private VBox n;

	public StageView() {
		initiallizeStageView();
	}

	public void initiallizeStageView() {
		this.setMinWidth(250);
		this.setMinHeight(500);
	}
}
