package gui.game;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.game.ItemPerHit;

public class UpgradeItemPerHit extends VBox {
	private ItemPerHit itemPerHit;
	private Text nameText = new Text();
	private Text levelText = new Text();
	private Text totalDamageText = new Text();
	private Text priceText = new Text();

	public UpgradeItemPerHit() {
		super();
		initializeUpgradeItemPerHit();
		initializeItemPerhit();
		setText();
		setImage();
		this.getChildren().addAll(nameText, levelText, totalDamageText, priceText);

	}

	public void initializeUpgradeItemPerHit() {
		this.setPadding(new Insets(8));
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setSpacing(5);
	}

	public void initializeItemPerhit() {
		String imageName = ClassLoader.getSystemResource("itemOnClick/Onclick.jpg").toString();
		itemPerHit = new ItemPerHit("ItemPerHit", 1, 10, 1, imageName, "sound/click.wav");

	}

	private void setImage() {
		Image img = new Image(itemPerHit.getImageName());
		ImageView imageView = new ImageView(img);
		imageView.setFitHeight(200);
		imageView.setFitWidth(200);
		imageView.setPreserveRatio(true);
		this.getChildren().add(imageView);
	}

	public void setText() {
		nameText.setText(itemPerHit.getName());
		nameText.setStyle("-fx-font-size: 20px;");
		levelText.setText("Current Level : " + itemPerHit.getCurrentLevel());
		totalDamageText.setText("Total Damage : " + itemPerHit.getTotalDamage());
		priceText.setText("Upgrade Price : " + itemPerHit.getTotalPrice());
	}

	public ItemPerHit getItemPerHit() {
		return itemPerHit;
	}

	public void setItemPerHit(ItemPerHit itemPerHit) {
		this.itemPerHit = itemPerHit;
	}

}
