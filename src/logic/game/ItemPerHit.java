package logic.game;

import java.lang.Math;

public class ItemPerHit extends Item {
	private final int MULTIPLY = 2;

	public ItemPerHit() {
		super();
		setTotalPrice();
		setTotalDamage();
		// TODO Auto-generated constructor stub
	}

	public ItemPerHit(String name, int currentLevel, int initialPrice, int initialDamage, String imageName,
			String soundName) {
		super(name, currentLevel, initialPrice, initialDamage, imageName, soundName);
		setTotalPrice();
		setTotalDamage();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		if (currentLevel < 0) {
			System.out.println("Level below or equal 0 can't Upgrade");
			return;
		}
		setCurrentLevel(getCurrentLevel() + 1);
		setTotalPrice();
		setTotalDamage();
	}

	@Override
	public void downgrade() {
		// TODO Auto-generated method stub
		if (currentLevel < 2) {
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
		return "(On hit item)" + getName() + "[LV." + getCurrentLevel() + "] DMG:" + getTotalDamage() + " Price:"
				+ getTotalPrice();
	}

	@Override
	public void setTotalPrice() {
		int totalPrice = (int) (getCurrentLevel() * getInitialPrice() * Math.pow(5, (getCurrentLevel() - 1)));
		if (totalPrice < 0) {
			this.totalPrice = 0;
			System.out.println("Total Price Below 0 Fixed to 0");
			return;
		}
		this.totalPrice = totalPrice;
	}

	// Multiply 2
	@Override
	public void setTotalDamage() {
		// TODO Auto-generated method stub
		if (getCurrentLevel() <= 0) {
			this.totalDamage = 0;
			return;
		}
		int totalDamage = (int) (getInitialDamage() * Math.pow(MULTIPLY, (getCurrentLevel() - 1)));
		if (totalDamage < 0) {
			this.totalDamage = 0;
			System.out.println("Total Damage Below 0 Fixed to 0");
			return;
		}
		this.totalDamage = totalDamage;
	}

	@Override
	public void setCurrentLevel(int currentLevel) {
		if (currentLevel < 1) {
			this.currentLevel = 1;
			System.out.println("Current Level Below 1 Fixed to 1");
			return;
		}
		this.currentLevel = currentLevel;
	}
}
