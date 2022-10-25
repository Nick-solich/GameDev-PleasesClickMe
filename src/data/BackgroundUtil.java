package data;

import java.util.Random;

public class BackgroundUtil {

	private static Random rand = new Random();

	private static String[] backgroundUrl = { "background/background00.gif" };

	public static String randomBackgroundUrl() {
		return backgroundUrl[rand.nextInt(backgroundUrl.length)];
	}
}
