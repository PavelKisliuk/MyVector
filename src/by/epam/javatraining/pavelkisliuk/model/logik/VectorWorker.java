/*
 * By Pavel Kisliuk, 16.03.2019
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

package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;

/**
 * The {@code VectorWorker} class work with Vector as array
 *
 * <p>This class provides several methods for specify operations
 * on elements in Vector.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorWorker {
	// Suppresses default constructor, ensuring non-instantiability.
	private VectorWorker() {
	}

	/**
	 * @param N is Vector of double elements
	 * @return arithmetic average value
	 */
	public static double averageArithmetic(final Vector N) {
		double average = 0.0;
		for (int i = 0; i < N.size(); i++) {
			average += N.getElement(i);
		}
		return (average / N.size());
	}

	/**
	 * @param N is Vector of double elements
	 * @return geometric average value
	 */
	public static double averageGeometric(final Vector N) {
		double average = 1.0;
		for (int i = 0; i < N.size(); i++) {
			average *= N.getElement(i);
		}
		return Math.pow(average, 1.0 / N.size());
	}
}
