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
	public static final double RANDOM_LOWER_BOUND;
	public static final double RANDOM_UPPER_BOUND;

	static {
		RANDOM_LOWER_BOUND = -100.0;
		RANDOM_UPPER_BOUND = 100.0;
	}

	// Suppresses default constructor, ensuring non-instantiability.
	private VectorInitializer() {
	}

	/**
	 * Init {@param N} random values
	 *
	 * @param N is Vector
	 */
	private void init(Vector N) {
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < N.size(); i++) {
			N.setElement(((secureRandom.nextDouble() *
					(RANDOM_UPPER_BOUND - RANDOM_LOWER_BOUND)) + RANDOM_LOWER_BOUND), i);
		}
	}

	/**
	 * Init {@param N} random values
	 *
	 * @param N           is Vector
	 * @param LOWER_BOUND lower bound of random elements
	 * @param UPPER_BOUND upper bound of random elements
	 */
	private void init(Vector N, final double LOWER_BOUND, final double UPPER_BOUND) {
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < N.size(); i++) {
			N.setElement(((secureRandom.nextDouble() *
					(UPPER_BOUND - LOWER_BOUND)) + LOWER_BOUND), i);
		}
	}

	/**
	 * Init {@param N} random values
	 *
	 * @param N     is Vector
	 * @param VALUE is specify element
	 */
	private void init(Vector N, final double VALUE) {
		for (int i = 0; i < N.size(); i++) {
			N.setElement(VALUE, i);
		}
	}

	/**
	 * Init {@param N} specify values
	 *
	 * @param N           is Vector
	 * @param VALUE_ARRAY is array of double
	 */
	private void init(Vector N, final double... VALUE_ARRAY) {
		for (int i = 0; i < N.size(); i++) {
			N.setElement(VALUE_ARRAY[i], i);
		}
	}
}

