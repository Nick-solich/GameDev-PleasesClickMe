package logic.game;

public class BasicMonster extends GameObject {
	protected int maxHp;
	protected int currentHp;
	protected int dropPrice;

	public BasicMonster() {
		super();
		// TODO Auto-generated constructor stub
		setDropPrice(0);
		setMaxHp(1);
		setCurrentHp(getMaxHp());
	}

	public BasicMonster(String name, int currentLevel, int maxHp, int dropPrice, String imageName, String soundName) {
		super(name, currentLevel, imageName, soundName);
		// TODO Auto-generated constructor stub
		setDropPrice(dropPrice);
		setMaxHp(maxHp);
		setCurrentHp(getMaxHp());
	}

	// From Super Class
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " LV." + getCurrentLevel();
	}

	// Getter Setter Field
	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		if (maxHp < 0) {
			this.maxHp = 1;
			System.out.println("Max HP below 1 Fixed to 1");
			return;
		}
		this.maxHp = maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		if (currentHp > getMaxHp()) {
			this.currentHp = getMaxHp();
			System.out.println("Current HP higher than maxHP fixed to maxHP");
			return;
		}
		if (currentHp < 0) {
			this.currentHp = 0;
			System.out.println("Current HP Drop Below 0 fixed to 0");
			return;
		}
		this.currentHp = currentHp;
	}

	public int getDropPrice() {
		return dropPrice;
	}

	public void setDropPrice(int dropPrice) {
		if (dropPrice < 0) {
			this.dropPrice = 0;
			System.out.println("Drop Price can not be negative Fixed to 0");
			return;
		}
		this.dropPrice = dropPrice;
	}

}
