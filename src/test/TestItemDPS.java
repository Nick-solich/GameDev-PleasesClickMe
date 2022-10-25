package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.*;
import logic.*;
import logic.game.ItemDPS;
import logic.game.ItemPerHit;

import org.junit.jupiter.api.Test;

class TestItemDPS {
	ItemDPS[] t;

	@BeforeEach
	public void setUp() throws Exception {
		ItemDPS t1 = new ItemDPS();
		ItemDPS t2 = new ItemDPS("Mom", 1, 500, 1, null, null);
		ItemDPS t3 = new ItemDPS("Dad", 0, 500, 1, null, null);
		t = new ItemDPS[] { t1, t2, t3 };

	}

	@Test
	void testConstructorAllDPS() {
		// greenTwin test
		ItemDPS greenTwin = new ItemDPS("GreenTwin");
		ItemDPS purpleTwin = new ItemDPS("PurpleTwin");
		ItemDPS archer = new ItemDPS("Archer");
		ItemDPS bone = new ItemDPS("Bone");
		ItemDPS redWizard = new ItemDPS("RedWizard");
		ItemDPS cowboy = new ItemDPS("Cowboy");
		ItemDPS fighter = new ItemDPS("Fighter");
		ItemDPS bodyguard = new ItemDPS("Bodyguard");
		ItemDPS freezeWizard = new ItemDPS("FreezeWizard");
		ItemDPS jacksparrow = new ItemDPS("JackSparrow");

		assertEquals("GreenTwin", greenTwin.getName());
		assertEquals(10, greenTwin.getInitialPrice());
		assertEquals(10, greenTwin.getTotalPrice());
		assertEquals(1, greenTwin.getInitialDamage());
		assertEquals(0, greenTwin.getTotalDamage());
		assertEquals(0, greenTwin.getCurrentLevel());

		// purpleTwin test
		assertEquals("PurpleTwin", purpleTwin.getName());
		assertEquals(40, purpleTwin.getInitialPrice());
		assertEquals(40, purpleTwin.getTotalPrice());
		assertEquals(5, purpleTwin.getInitialDamage());
		assertEquals(0, purpleTwin.getTotalDamage());
		assertEquals(0, purpleTwin.getCurrentLevel());

		// Bone test
		assertEquals("Bone", bone.getName());
		assertEquals(640, bone.getInitialPrice());
		assertEquals(640, bone.getTotalPrice());
		assertEquals(110, bone.getInitialDamage());
		assertEquals(0, bone.getTotalDamage());
		assertEquals(0, bone.getCurrentLevel());

		// redWizard test
		assertEquals("RedWizard", redWizard.getName());
		assertEquals(2560, redWizard.getInitialPrice());
		assertEquals(2560, redWizard.getTotalPrice());
		assertEquals(410, redWizard.getInitialDamage());
		assertEquals(0, redWizard.getTotalDamage());
		assertEquals(0, redWizard.getCurrentLevel());

		// Cowboy test
		assertEquals("Cowboy", cowboy.getName());
		assertEquals(10240, cowboy.getInitialPrice());
		assertEquals(10240, cowboy.getTotalPrice());
		assertEquals(1740, cowboy.getInitialDamage());
		assertEquals(0, cowboy.getTotalDamage());
		assertEquals(0, cowboy.getCurrentLevel());

		// Archer test
		assertEquals("Archer", archer.getName());
		assertEquals(160, archer.getInitialPrice());
		assertEquals(160, archer.getTotalPrice());
		assertEquals(24, archer.getInitialDamage());
		assertEquals(0, archer.getTotalDamage());
		assertEquals(0, archer.getCurrentLevel());

		// Fighter test
		assertEquals("Fighter", fighter.getName());
		assertEquals(20480, fighter.getInitialPrice());
		assertEquals(20480, fighter.getTotalPrice());
		assertEquals(3690, fighter.getInitialDamage());
		assertEquals(0, fighter.getTotalDamage());
		assertEquals(0, fighter.getCurrentLevel());

		// Bodyguard test
		assertEquals("Bodyguard", bodyguard.getName());
		assertEquals(40218, bodyguard.getInitialPrice());
		assertEquals(40218, bodyguard.getTotalPrice());
		assertEquals(7645, bodyguard.getInitialDamage());
		assertEquals(0, bodyguard.getTotalDamage());
		assertEquals(0, bodyguard.getCurrentLevel());

		// freezeWizard test
		assertEquals("FreezeWizard", freezeWizard.getName());
		assertEquals(80256, freezeWizard.getInitialPrice());
		assertEquals(80256, freezeWizard.getTotalPrice());
		assertEquals(16100, freezeWizard.getInitialDamage());
		assertEquals(0, freezeWizard.getTotalDamage());
		assertEquals(0, freezeWizard.getCurrentLevel());

		// JackSparrow test
		assertEquals("JackSparrow", jacksparrow.getName());
		assertEquals(456789, jacksparrow.getInitialPrice());
		assertEquals(456789, jacksparrow.getTotalPrice());
		assertEquals(65000, jacksparrow.getInitialDamage());
		assertEquals(0, jacksparrow.getTotalDamage());
		assertEquals(0, jacksparrow.getCurrentLevel());

	}

	@Test
	void testConstructor() {
		// For Empty Constructor
		assertEquals("Nameless", t[0].getName());
		assertEquals(0, t[0].getInitialPrice());
		assertEquals(0, t[0].getInitialDamage());
		assertEquals(0, t[0].getCurrentLevel());
		assertEquals(0, t[0].getTotalPrice());
		assertEquals(0, t[0].getTotalDamage());
		// For Constructor
		assertEquals("Mom", t[1].getName());
		assertEquals(500, t[1].getInitialPrice());
		assertEquals(550, t[1].getTotalPrice());
		assertEquals(1, t[1].getInitialDamage());
		assertEquals(1, t[1].getTotalDamage());
		assertEquals(1, t[1].getCurrentLevel());
		// For Constructor LV.0
		assertEquals("Dad", t[2].getName());
		assertEquals(500, t[2].getInitialPrice());
		assertEquals(500, t[2].getTotalPrice());
		assertEquals(1, t[2].getInitialDamage());
		assertEquals(0, t[2].getTotalDamage());
		assertEquals(0, t[2].getCurrentLevel());

	}

	@Test
	void testUpgrade() {
		// For Empty Constructor
		t[0].upgrade();
		assertEquals("Nameless", t[0].getName());
		assertEquals(0, t[0].getInitialPrice());
		assertEquals(0, t[0].getInitialDamage());
		assertEquals(1, t[0].getCurrentLevel());
		assertEquals(0, t[0].getTotalPrice());
		assertEquals(0, t[0].getTotalDamage());
		// For Constructor
		t[1].upgrade();
		t[1].upgrade();
		t[1].upgrade();
		assertEquals("Mom", t[1].getName());
		assertEquals(500, t[1].getInitialPrice());
		assertEquals(700, t[1].getTotalPrice());
		assertEquals(1, t[1].getInitialDamage());
		assertEquals(4, t[1].getTotalDamage());
		assertEquals(4, t[1].getCurrentLevel());
		// Level 0 up
		t[2].upgrade();
		t[2].upgrade();
		t[2].upgrade();
		t[2].upgrade();
		t[2].upgrade();
		assertEquals("Dad", t[2].getName());
		assertEquals(500, t[2].getInitialPrice());
		assertEquals(750, t[2].getTotalPrice());
		assertEquals(1, t[2].getInitialDamage());
		assertEquals(5, t[2].getTotalDamage());
		assertEquals(5, t[2].getCurrentLevel());
	}

	@Test
	void testDowngrade() {
		// For Empty Constructor LV. 3
		t[0].upgrade();
		t[0].upgrade();
		t[0].upgrade();
		t[0].downgrade();
		assertEquals("Nameless", t[0].getName());
		assertEquals(0, t[0].getInitialPrice());
		assertEquals(0, t[0].getInitialDamage());
		assertEquals(2, t[0].getCurrentLevel());
		assertEquals(0, t[0].getTotalPrice());
		assertEquals(0, t[0].getTotalDamage());
//		// For Mom
		t[1].upgrade();
		t[1].upgrade();
		t[1].upgrade();
		t[1].downgrade();
		t[1].downgrade();
		assertEquals("Mom", t[1].getName());
		assertEquals(500, t[1].getInitialPrice());
		assertEquals(600, t[1].getTotalPrice());
		assertEquals(1, t[1].getInitialDamage());
		assertEquals(2, t[1].getTotalDamage());
		assertEquals(2, t[1].getCurrentLevel());
		// For Dad
		t[2].upgrade();
		t[2].upgrade();
		t[2].downgrade();
		t[2].downgrade();
		assertEquals("Dad", t[2].getName());
		assertEquals(500, t[2].getInitialPrice());
		assertEquals(500, t[2].getTotalPrice());
		assertEquals(1, t[2].getInitialDamage());
		assertEquals(0, t[2].getTotalDamage());
		assertEquals(0, t[2].getCurrentLevel());

	}

	@Test
	void testToString() {
		// For Empty Constructor
		assertEquals("(DPS)Nameless[LV.0] DMG:0 Price:0", t[0].toString());
		t[0].upgrade();
		t[0].upgrade();
		t[0].upgrade();
		assertEquals("(DPS)Nameless[LV.3] DMG:0 Price:0", t[0].toString());
		// For Mom
		assertEquals("(DPS)Mom[LV.1] DMG:1 Price:550", t[1].toString());
		t[1].upgrade();
		assertEquals("(DPS)Mom[LV.2] DMG:2 Price:600", t[1].toString());
		t[1].upgrade();
		t[1].upgrade();
		t[1].upgrade();
		assertEquals("(DPS)Mom[LV.5] DMG:5 Price:750", t[1].toString());
		// For Dad
		assertEquals("(DPS)Dad[LV.0] DMG:0 Price:500", t[2].toString());
		t[2].upgrade();
		assertEquals("(DPS)Dad[LV.1] DMG:1 Price:550", t[2].toString());
		t[2].upgrade();
		t[2].upgrade();
		t[2].downgrade();
		assertEquals("(DPS)Dad[LV.2] DMG:2 Price:600", t[2].toString());
	}

	@Test
	void testUpgradeBug() {
		ItemDPS forUpgradeBug = new ItemDPS("Book Of Nothing", -5, 500, 1, null, null);
		assertEquals("(DPS)Book Of Nothing[LV.0] DMG:0 Price:500", forUpgradeBug.toString());
		forUpgradeBug.upgrade();
		forUpgradeBug.downgrade();
		assertEquals("(DPS)Book Of Nothing[LV.0] DMG:0 Price:500", forUpgradeBug.toString());
		forUpgradeBug.upgrade();
		forUpgradeBug.upgrade();
		assertEquals("(DPS)Book Of Nothing[LV.2] DMG:2 Price:600", forUpgradeBug.toString());
	}

	@Test
	void testDowngradeBug() {
		// For Empty Constructor
		assertEquals("(DPS)Nameless[LV.0] DMG:0 Price:0", t[0].toString());
		t[0].upgrade();
		t[0].upgrade();
		t[0].downgrade();
		t[0].downgrade();
		t[0].downgrade();
		t[0].downgrade();
		t[0].downgrade();
		assertEquals("(DPS)Nameless[LV.0] DMG:0 Price:0", t[0].toString());
	}

}
