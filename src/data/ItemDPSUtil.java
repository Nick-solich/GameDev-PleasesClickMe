package data;

import logic.game.*;

public class ItemDPSUtil {
	public static void chooseItemDPS(ItemDPS itemdps, String name) {
		itemdps.setName(name);
		itemdps.setCurrentLevel(0);
		itemdps.setImageName(ClassLoader.getSystemResource("itemDPS/"+name+".png").toString());
		itemdps.setSoundName(ClassLoader.getSystemResource("sound/" + name + ".mp3").toString());
		switch (name) {
		case "GreenTwin":
			// 0.01 DPS/price
			itemdps.setInitialPrice(10);
			itemdps.setInitialDamage(1);
			break;
		case "PurpleTwin":
			// 0.0125 DPS/price
			itemdps.setInitialPrice(40);
			itemdps.setInitialDamage(5);
			break;
		case "Archer":
			// 0.015 DPS/price
			itemdps.setInitialPrice(160);
			itemdps.setInitialDamage(24);
			break;
		case "Bone":
			// 0.015625 DPS/price
			itemdps.setInitialPrice(640);
			itemdps.setInitialDamage(110);
			break;
		case "RedWizard":
			// 0.016 DPS/price
			itemdps.setInitialPrice(2560);
			itemdps.setInitialDamage(410);
			break;
		case "Cowboy":
			// 0.017 DPS/price
			itemdps.setInitialPrice(10240);
			itemdps.setInitialDamage(1740);
			break;
		case "Fighter":
			// 0.018 DPS/price
			itemdps.setInitialPrice(20480);
			itemdps.setInitialDamage(3690);
			break;
		case "Bodyguard":
			// 0.019 DPS/price
			itemdps.setInitialPrice(40218);
			itemdps.setInitialDamage(7645);
			break;
		case "FreezeWizard":
			// 0.020 DPS/price
			itemdps.setInitialPrice(80256);
			itemdps.setInitialDamage(16100);
			break;
		case "JackSparrow":
			// 0.050 DPS/price
			itemdps.setInitialPrice(456789);
			itemdps.setInitialDamage(65000);
			break;
		}
	}
}
