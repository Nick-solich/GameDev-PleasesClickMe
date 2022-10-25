package data;

import java.util.Random;

import logic.GameManager;

public class MonsterUtil {

	private static Random rand = new Random();

	private static String[] monsterNameList = { "I'm Joking", "Monster The Duke", "Long Time Monster", "Dungeon slave",
			"Master Slave Fipfop", "JK slave master", "ALLgo designer", "SetterGamer", "GetterSamer",
			"Variable Constanst", "HIT ME", "HELL boundSS", "Export Runnable leg", "Time Space Strength", "Counter 666",
			"TRY Me", "ANDORNORXOR", "Mai D Flip Flop", "Present state/Next state/Input", "Heap", "Binary tree",
			"Binary tree Tree Tree", "Heap_split", "String_split", "List_split", "Vector_split", "Set_split",
			"Map_bst_split", "Map_avl_split", "Map_split", "Dict_split", "ArrayList_split", "ClassLoader",
			"Imporserter", "Carry", "Support", "Tank", "Fiter", "Assasin", "Mage", "Cars" };
	private static String[] monsterPictureNameList = { "monster/monster01.png", "monster/monster02.png",
			"monster/monster03.png", "monster/monster04.png", "monster/monster05.png", "monster/monster06.png",
			"monster/monster07.png", "monster/monster08.png", "monster/monster09.png", "monster/monster10.png",
			"monster/monster11.png", "monster/monster12.png", "monster/monster13.png", "monster/monster14.png",
			"monster/monster15.png", "monster/monster16.png", "monster/monster17.png", "monster/monster18.png",
			"monster/monster19.png", "monster/monster20.png", "monster/monster21.png", "monster/monster22.png",
			"monster/monster23.png", "monster/monster24.png", "monster/monster25.png", "monster/monster26.png",
			"monster/monster27.png", "monster/monster28.png", "monster/monster29.png", "monster/monster30.png",
			"monster/monster31.png", "monster/monster32.png", "monster/monster33.png" };

	public static String getRandomName() {
		return monsterNameList[rand.nextInt(monsterNameList.length)];
	}

	public static String getRandomMonsterPicture() {
		return monsterPictureNameList[rand.nextInt(monsterPictureNameList.length)];
	}

	public static int getRandomMaxHp() {
		int level = GameManager.worldMonsterLevel;
		int maxHp = level * (level + 1) * 5;
		int rangeHp = maxHp / 10 * GameManager.worldMonsterLevel;
		if (rangeHp <= 0)
			rangeHp = 1;
		return maxHp + rand.nextInt(rangeHp);
	}

	public static int getRandomDropPrice() {
		return getRandomMaxHp();
	}
}
