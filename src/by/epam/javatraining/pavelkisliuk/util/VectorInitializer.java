/*
 * By Pavel Kisliuk, 17.03.2019
 * This is class for education and nothing rights don't reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by.epam.javatraining.pavelkisliuk.util;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import java.security.SecureRandom;

/**
 * The {@code VectorInitializer} init Vector by values
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorInitializer {
	/**
	 * Init {@param N} random values
	 * @param N
	 */
	private void init(Vector N)
	{
		SecureRandom secureRandom = new SecureRandom();
		for(int i = 0; i < N.size(); i++) {
			N.setElement((secureRandom.nextDouble() * 200 - 100), i);
		}
	}

	/**
	 * Init {@param N} specify values
	 * @param N
	 */
	private void init(Vector N, final double...VALUE_ARRAY)
	{
		for(int i = 0; i < N.size(); i++) {
			N.setElement(VALUE_ARRAY[i], i);
		}
	}
}
