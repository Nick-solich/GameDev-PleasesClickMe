package logic;

import data.MonsterUtil;
import gui.GameMenu;
import gui.game.MonsterInform;
import gui.game.PlayerView;
import javafx.application.Platform;
import logic.game.BasicMonster;

public class GameManager {
	public static boolean startProgram = true;

	private static int killCount;
	private static boolean isBoss;
	public static BasicMonster currentMonster;
	public static int worldMonsterLevel;

	public static void setUpGame() {
		Player.setUpPlayer(0);
		setWorldMonsterLevel(1);
		setKillCount(0);
		setBoss();
		createMonster();
		Player.setCurrentDPS(0);
		Player.setCurrentDamagePerHit(1);
		startDealingDPS();
	}

	// About Monster and BossMonster
	public static void createMonster() {
		// Choose From MonsterUtilData
		String monsterName = MonsterUtil.getRandomName();
		int monsterMaxHp = MonsterUtil.getRandomMaxHp();
		int monsterDropPrice = MonsterUtil.getRandomDropPrice();
		String imageName = ClassLoader.getSystemResource(MonsterUtil.getRandomMonsterPicture()).toString();

		// Check There a Boss?
		if (GameManager.isBoss()) {
			monsterMaxHp = monsterMaxHp * 6;
			monsterDropPrice = monsterDropPrice * 6;
		}
		currentMonster = new BasicMonster(monsterName, worldMonsterLevel, monsterMaxHp, monsterDropPrice, imageName,
				"");
	}

	// Dealing DPS using Thread For Continue Game
	public static void startDealingDPS() {
		Thread dpsDamageThread = new Thread(() -> {
			while (GameManager.startProgram) {
				try {
					Thread.sleep(1000);
					// Do Damage DPS Method
					GameManager.doDamageDPSByPlayer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		dpsDamageThread.start();
	}

	// For Use In Thread
	public static void doDamageDPSByPlayer() {
		if (GameManager.currentMonster.getCurrentHp() <= 0) {
			Player.increasePlayerMoney(GameManager.currentMonster.getDropPrice());
			GameManager.setKillCount(GameManager.getKillCount() + 1);
			GameManager.createMonster();
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					MonsterInform.setToCurrentMonster();
					PlayerView.moneyLabel.setText(Player.displayMoney());
				}
			});
		} else {
			System.out.println("Do Damage DPS");
			Player.doDamageDPS();
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					MonsterInform.monsterHp.setText("HP : " + GameManager.currentMonster.getCurrentHp() + " / "
							+ GameManager.currentMonster.getMaxHp());
				}
			});
			if (GameManager.currentMonster.getCurrentHp() <= 0)
				doDamageDPSByPlayer();
		}
	}

	// Level Game Setter Getter
	public static int getKillCount() {
		return killCount;
	}

	public static void setKillCount(int killCount) {
		if (killCount < 0) {
			GameManager.killCount = 0;
			System.out.println("Kill Count can't below 0");
			return;
		}
		if (getKillCount() > getWorldMonsterLevel() * 10) {
			setWorldMonsterLevel(getWorldMonsterLevel() + 1);
			setKillCount(0);
		}
		GameManager.killCount = killCount;
	}

	public static int getWorldMonsterLevel() {
		return worldMonsterLevel;
	}

	public static void setWorldMonsterLevel(int worldMonsterLevel) {
		if (worldMonsterLevel < 0) {
			GameManager.worldMonsterLevel = 0;
			System.out.println("World Monster Level can't below 0");
			return;
		}
		GameManager.worldMonsterLevel = worldMonsterLevel;
	}

	// Boss Setting
	public static boolean isBoss() {
		setBoss();
		return isBoss;
	}

	public static void setBoss() {
		if (getKillCount() <= getWorldMonsterLevel() * 10) {
			GameManager.isBoss = false;
			return;
		}
		GameManager.isBoss = true;
	}

}
