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
 * <p>This class provides several methods for determination
 * specify condition of the Vector
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorChecker {
	// Suppresses default constructor, ensuring non-instantiability.
	private VectorChecker() {
	}

	/**
	 * @param N is Vector of double elements
	 * @return {@code true} if vector sorted in ascending, otherwise false
	 */
	public static boolean isSortedIncrease(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		if (N.size() > 1) {
			for (int i = 0; i < (N.size() - 1); i++) {
				if (Double.compare(N.getElement(i), N.getElement(i + 1)) > 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param N is Vector of double elements
	 * @return {@code true} if vector sorted in descending, otherwise false
	 */
	public static boolean isSortedDecrease(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		if (N.size() > 1) {
			for (int i = 0; i < (N.size() - 1); i++) {
				if (Double.compare(N.getElement(i), N.getElement(i + 1)) < 0) {
					return false;
				}
			}
		}
		return true;
	}
}
