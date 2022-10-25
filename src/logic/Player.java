package logic;

public class Player {
	private static int playerMoney;
	private static int currentDPS;
	private static int currentDamagePerHit;

	public static void setUpPlayer(int money) {
		setPlayerMoney(money);
	}

	// Display Money By Developer Logic EX. 1000 = 1K
	public static String displayMoney() {
		return "Money : " + Player.playerMoney;
	}

	// DPS Setting
	public static void doDamageDPS() {
		GameManager.currentMonster.setCurrentHp(GameManager.currentMonster.getCurrentHp() - getCurrentDPS());
	}

	public static void increaseDPS(int count) {
		setCurrentDPS(Player.getCurrentDPS() + count);
	}

	public static void setCurrentDPS(int count) {
		Player.currentDPS = count;
	}

	public static int getCurrentDPS() {
		return Player.currentDPS;
	}

	// Damage Per Hit Setting
	public static void doDamagePerHit() {
		GameManager.currentMonster.setCurrentHp(GameManager.currentMonster.getCurrentHp() - getCurrentDamagePerHit());
	}

	public static void increaseDamagePerHit(int count) {
		setCurrentDPS(Player.getCurrentDamagePerHit() + count);
	}

	public static void setCurrentDamagePerHit(int count) {
		Player.currentDamagePerHit = count;
	}

	public static int getCurrentDamagePerHit() {
		return Player.currentDamagePerHit;
	}

	// Getter Setter
	public static void setPlayerMoney(int playerMoney) {
		if (playerMoney < 0) {
			System.out.println("Money Can't Below 0 Fixed To 0");
			Player.playerMoney = 0;
			return;
		}
		Player.playerMoney = playerMoney;
	}

	public static int getPlayerMoney() {
		return Player.playerMoney;
	}

	public static void increasePlayerMoney(int money) {
		setPlayerMoney(getPlayerMoney() + money);
	}

	public static boolean takePlayerMoney(int money) {
		if (money < 0) {
			System.out.println("Can't Upgrade Item That Below 0");
			return false;
		}
		if (money > getPlayerMoney()) {
			System.out.println("Player not have enough Money to Upgrade!!!");
			return false;
		}
		setPlayerMoney(getPlayerMoney() - money);
		return true;
	}

}
