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

import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Scanner;

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
	public static void init(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}

		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < N.size(); i++) {
			N.setElement(((secureRandom.nextDouble() *
					(RANDOM_UPPER_BOUND - RANDOM_LOWER_BOUND)) + RANDOM_LOWER_BOUND), i);
		}
	}

	/**
	 * Init {@param N} random values
	 *
	 * @param N          is Vector
	 * @param lowerBound lower bound of random elements
	 * @param upperBound upper bound of random elements
	 */
	public static void init(Vector N, double lowerBound, double upperBound) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < N.size(); i++) {
			N.setElement(((secureRandom.nextDouble() *
					(upperBound - lowerBound)) + lowerBound), i);
		}
	}

	/**
	 * Init {@param N} random values
	 *
	 * @param N is Vector
	 * @param v is specify element
	 */
	public static void init(Vector N, double v) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		for (int i = 0; i < N.size(); i++) {
			N.setElement(v, i);
		}
	}

	/**
	 * Init {@param N} specify values
	 *
	 * @param N          is Vector
	 * @param valueArray is array of double
	 */
	public static void init(Vector N, double... valueArray) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		for (int i = 0; i < N.size(); i++) {
			N.setElement(valueArray[i], i);
		}
	}

	/**
	 * fill from file
	 *
	 * @param path to file
	 */
	public static void init(Vector N, String path) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		try (Scanner input = new Scanner(Paths.get(path))) {
			int i = 0;
			while ((input.hasNext()) && (i < N.size())) {
				N.setElement(input.nextDouble(), i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

