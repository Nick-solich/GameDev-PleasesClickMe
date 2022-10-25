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

class TestItemPerHit {
	ItemPerHit[] t;

	@BeforeEach
	public void setUp() throws Exception {
		ItemPerHit t1 = new ItemPerHit();
		ItemPerHit t2 = new ItemPerHit("Sword of Justice", 1, 100, 1, null, null);
		t = new ItemPerHit[] { t1, t2 };
	}

	@Test
	void testConstructor() {
		// For Empty Constructor
		assertEquals("Nameless", t[0].getName());
		assertEquals(0, t[0].getInitialPrice());
		assertEquals(0, t[0].getInitialDamage());
		assertEquals(1, t[0].getCurrentLevel());
		assertEquals(0, t[0].getTotalPrice());
		assertEquals(0, t[0].getTotalDamage());
		// For Constructor
		assertEquals("Sword of Justice", t[1].getName());
		assertEquals(100, t[1].getInitialPrice());
		assertEquals(100, t[1].getTotalPrice());
		assertEquals(1, t[1].getInitialDamage());
		assertEquals(1, t[1].getTotalDamage());
		assertEquals(1, t[1].getCurrentLevel());

	}

	@Test
	void testUpgrade() {
		// For Empty Constructor
		t[0].upgrade();
		assertEquals("Nameless", t[0].getName());
		assertEquals(0, t[0].getInitialPrice());
		assertEquals(0, t[0].getInitialDamage());
		assertEquals(2, t[0].getCurrentLevel());
		assertEquals(0, t[0].getTotalPrice());
		assertEquals(0, t[0].getTotalDamage());
		// For Constructor
		t[1].upgrade();
		t[1].upgrade();
		t[1].upgrade();
		assertEquals("Sword of Justice", t[1].getName());
		assertEquals(100, t[1].getInitialPrice());
		assertEquals(1600, t[1].getTotalPrice());
		assertEquals(1, t[1].getInitialDamage());
		assertEquals(8, t[1].getTotalDamage());
		assertEquals(4, t[1].getCurrentLevel());

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
		assertEquals(3, t[0].getCurrentLevel());
		assertEquals(0, t[0].getTotalPrice());
		assertEquals(0, t[0].getTotalDamage());
		// For Constructor LV. 2
		t[1].upgrade();
		t[1].upgrade();
		t[1].upgrade();
		t[1].downgrade();
		t[1].downgrade();
		assertEquals("Sword of Justice", t[1].getName());
		assertEquals(100, t[1].getInitialPrice());
		assertEquals(400, t[1].getTotalPrice());
		assertEquals(1, t[1].getInitialDamage());
		assertEquals(2, t[1].getTotalDamage());
		assertEquals(2, t[1].getCurrentLevel());

	}

	@Test
	void testToString() {
		// For Empty Constructor
		assertEquals("(On hit item)Nameless[LV.1] DMG:0 Price:0", t[0].toString());
		t[0].upgrade();
		t[0].upgrade();
		t[0].upgrade();
		assertEquals("(On hit item)Nameless[LV.4] DMG:0 Price:0", t[0].toString());
		// For Constructor
		assertEquals("(On hit item)Sword of Justice[LV.1] DMG:1 Price:100", t[1].toString());
		t[1].upgrade();
		assertEquals("(On hit item)Sword of Justice[LV.2] DMG:2 Price:400", t[1].toString());
		t[1].upgrade();
		t[1].upgrade();
		t[1].upgrade();
		assertEquals("(On hit item)Sword of Justice[LV.5] DMG:16 Price:2500", t[1].toString());
	}

	@Test
	void testUpgradeBug() {
		ItemPerHit forUpgradeBug = new ItemPerHit("Sword of Justice", -5, 100, 1, null, null);
		assertEquals("(On hit item)Sword of Justice[LV.1] DMG:1 Price:100", forUpgradeBug.toString());
		forUpgradeBug.upgrade();
		forUpgradeBug.downgrade();
		assertEquals("(On hit item)Sword of Justice[LV.1] DMG:1 Price:100", forUpgradeBug.toString());
		forUpgradeBug.downgrade();
		assertEquals("(On hit item)Sword of Justice[LV.1] DMG:1 Price:100", forUpgradeBug.toString());
	}

	@Test
	void testDowngradeBug() {
		// For Empty Constructor
		assertEquals("(On hit item)Nameless[LV.1] DMG:0 Price:0", t[0].toString());
		t[0].upgrade();
		t[0].upgrade();
		t[0].downgrade();
		t[0].downgrade();
		t[0].downgrade();
		t[0].downgrade();
		t[0].downgrade();
		assertEquals("(On hit item)Nameless[LV.1] DMG:0 Price:0", t[0].toString());
	}

}
