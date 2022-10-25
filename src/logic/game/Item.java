package logic.game;

public abstract class Item extends GameObject implements Upgradable {
	protected int initialPrice;
	protected int totalPrice;
	protected int totalDamage;
	protected int initialDamage;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
		setInitialPrice(0);
		setInitialDamage(0);
	}

	public Item(String name, int currentLevel, int initialPrice, int initialDamage, String imageName,
			String soundName) {
		super(name, currentLevel, imageName, soundName);
		// TODO Auto-generated constructor stub
		setInitialPrice(initialPrice);
		setInitialDamage(initialDamage);
	}

	// Each Items have their own Calculate Total Price Method
	public abstract void setTotalDamage();

	public abstract void setTotalPrice();

	// Getter & Setter
	public int getInitialDamage() {
		return initialDamage;
	}

	public void setInitialDamage(int initialDamage) {
		if (initialDamage < 0) {
			this.initialDamage = 0;
			System.out.println("Initial Damage Below 0 Fixed to 0");
			return;
		}
		this.initialDamage = initialDamage;
	}

	public int getTotalDamage() {
		return totalDamage;
	}

	public void setInitialPrice(int initialPrice) {
		if (initialPrice < 0) {
			this.initialPrice = 0;
			System.out.println("Initial Price Below 0 Fixed to 0");
			return;
		}
		this.initialPrice = initialPrice;
	}

	public int getInitialPrice() {
		return initialPrice;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}
}
