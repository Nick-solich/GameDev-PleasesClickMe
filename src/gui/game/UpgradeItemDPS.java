package gui.game;

import javafx.geometry.Insets;

import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.Player;
import logic.game.Item;
import logic.game.ItemDPS;

public class UpgradeItemDPS extends VBox {

	private Tooltip tooltip;
	private Item item;
	private Text nameText = new Text();
	private Text levelText = new Text();
	private Text totalDamage = new Text();
	private Text priceText = new Text();

	public UpgradeItemDPS(String itemName) {
		item = new ItemDPS(itemName);
		this.setPrefHeight(450);
		this.setPrefWidth(200);
		this.setImage();
		this.setText();
		this.setPadding(new Insets(8));
		this.setUpTooltip();
		this.getChildren().addAll(nameText, levelText, totalDamage, priceText);
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.web("#ffffe6"), CornerRadii.EMPTY, Insets.EMPTY)));

	}

	private void setImage() {
		Image img = new Image(item.getImageName());
		ImageView imageView = new ImageView(img);
		imageView.setFitHeight(200);
		imageView.setFitWidth(100);
		imageView.setPreserveRatio(true);
		this.getChildren().add(imageView);
	}

	public void setText() {
		nameText.setText(item.getName());
		nameText.setStyle("-fx-font-size: 18px;");
		levelText.setText("Current Level : " + item.getCurrentLevel());
		totalDamage.setText("Total DPS : " + item.getTotalDamage());
		priceText.setText("Upgrade Price : " + item.getTotalPrice());
	}

	private void setUpTooltip() {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText(item.getName() + "\n" + "Can Deal \nDamage \"" + item.getInitialDamage() + "\"");
		if (item.getTotalPrice() >= Player.getPlayerMoney()) {
			this.setOnMouseMoved((MouseEvent e) -> {
				tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
			});
		}

		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});

	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
