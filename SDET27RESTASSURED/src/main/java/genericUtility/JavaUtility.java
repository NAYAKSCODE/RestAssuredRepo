package genericUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author ASHUTOSH NAYAK
 *
 */

public class JavaUtility {
	/**
	 * This method will generate a random value for every time use
	 * @return
	 */
	public int getRandomnum() {
		Random ran= new Random();
		int randomnum = ran.nextInt(100);
		return randomnum;
	}

}
