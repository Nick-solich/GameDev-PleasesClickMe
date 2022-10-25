package logic.game;

public abstract class GameObject {
	protected String name;
	protected int currentLevel;
	protected String imageName;
	protected String soundName;

	public GameObject() {
		super();
		setName("Nameless");
		setCurrentLevel(0);

		setImageName(null);
	}

	public GameObject(String name, int currentLevel, String imageName, String soundName) {
		super();
		setName(name);
		setCurrentLevel(currentLevel);
		setImageName(imageName);
		setSoundName(soundName);
	}

	// Each GameObject has Each setTotalPrice Method
	@Override
	public abstract String toString();

	// Setter and Getter for each GameObject
	public void setCurrentLevel(int currentLevel) {
		if (currentLevel < 0) {
			this.currentLevel = 0;
			System.out.println("Current Level Below 0 Fixed to 0");
			return;
		}
		this.currentLevel = currentLevel;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSoundName() {
		return soundName;
	}

	public void setSoundName(String soundName) {
		this.soundName = soundName;
	}

}
