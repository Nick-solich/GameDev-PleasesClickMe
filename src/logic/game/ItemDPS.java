package logic.game;

import data.ItemDPSUtil;

public class ItemDPS extends Item {

	public ItemDPS() {
		super();
		setCurrentLevel(0);
		setTotalPrice();
		setTotalDamage();
		// TODO Auto-generated constructor stub
	}

	public ItemDPS(String name, int currentLevel, int initialPrice, int initialDamage, String imageName,
			String soundName) {
		super(name, currentLevel, initialPrice, initialDamage, imageName, soundName);
		setTotalPrice();
		setTotalDamage();
	}

	public ItemDPS(String name) {
		ItemDPSUtil.chooseItemDPS(this, name);
		setTotalPrice();
		setTotalDamage();
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		if (currentLevel < 0) {
			System.out.println("Level below 0 can't Upgrade");
			return;
		}
		setCurrentLevel(getCurrentLevel() + 1);
		setTotalPrice();
		setTotalDamage();
	}

	@Override
	public void downgrade() {
		// TODO Auto-generated method stub
		if (currentLevel < 1) {
			System.out.println("Level is on lowest level in the game");
			return;
		}
		setCurrentLevel(getCurrentLevel() - 1);
		setTotalPrice();
		setTotalDamage();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(DPS)" + getName() + "[LV." + getCurrentLevel() + "] DMG:" + getTotalDamage() + " Price:"
				+ getTotalPrice();
	}

	@Override
	public void setTotalPrice() {
		int totalPrice = getInitialPrice() + getCurrentLevel() * getInitialPrice() / 10;
		if (totalPrice < 0) {
			this.totalPrice = 0;
			System.out.println("Total Price Below 0 Fixed to 0");
			return;
		}
		this.totalPrice = totalPrice;
	}

	@Override
	public void setTotalDamage() {
		if (getCurrentLevel() <= 0) {
			this.totalDamage = 0;
			return;
		}
		this.totalDamage = getInitialDamage() * getCurrentLevel();

	}

}
