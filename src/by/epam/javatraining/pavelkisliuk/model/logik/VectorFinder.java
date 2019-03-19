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
 * The {@code VectorFinder} class work with Vector as array
 *
 * <p>This class provides several methods for finding specify
 * elements in Vector.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorFinder {
	// Suppresses default constructor, ensuring non-instantiability.
	private VectorFinder() {
	}

	/**
	 * @param N is Vector of double elements
	 * @return a maximal double element of vector
	 */
	public static double max(final Vector N) {
		double max = N.getElement(0);
		for (int i = 1; i < N.size(); i++) {
			if (Double.compare(max, N.getElement(i)) < 0) {
				max = N.getElement(i);
			}
		}
		return max;
	}

	/**
	 * @param N is Vector of double elements
	 * @return a minimal double element of vector
	 */
	public static double min(final Vector N) {
		double min = N.getElement(0);
		for (int i = 1; i < N.size(); i++) {
			if (Double.compare(min, N.getElement(i)) > 0) {
				min = N.getElement(i);
			}
		}
		return min;
	}

	/**
	 * @param N is Vector of double elements
	 * @return first element neighbors have less value
	 */
	public static int localMax(final Vector N) {
		if (N.size() > 1) {
			for (int i = 0, neighborLeft = (i - 1), neighborRight = (i + 1); i < N.size(); // ->
				 i++, neighborLeft++, neighborRight++) {
				//---------------------------------------------------------------------
				if ((i > 0) && (i < (N.size() - 1))) {
					if (Double.compare(N.getElement(i), N.getElement(neighborLeft)) > 0 &&
							Double.compare(N.getElement(i), N.getElement(neighborRight)) > 0) {
						return i;
					}
				} else if (i == 0) {
					if (Double.compare(N.getElement(i), N.getElement(neighborRight)) > 0) {
						return i;
					}
				} else {
					if (Double.compare(N.getElement(i), N.getElement(neighborLeft)) > 0) {
						return i;
					}
				}
				//---------------------------------------------------------------------
			}
		} else {
			return 0;
		}
		return -1;
	}

	/**
	 * @param N is Vector of double elements
	 * @return first element neighbors have more value
	 */
	public static int localMin(final Vector N) {
		if (N.size() > 1) {
			for (int i = 0, neighborLeft = (i - 1), neighborRight = (i + 1); i < N.size(); // ->
				 i++, neighborLeft++, neighborRight++) {
				//---------------------------------------------------------------------
				if ((i > 0) && (i < (N.size() - 1))) {
					if (Double.compare(N.getElement(i), N.getElement(neighborLeft)) < 0 &&
							Double.compare(N.getElement(i), N.getElement(neighborRight)) < 0) {
						return i;
					}
				} else if (i == 0) {
					if (Double.compare(N.getElement(i), N.getElement(neighborRight)) < 0) {
						return i;
					}
				} else {
					if (Double.compare(N.getElement(i), N.getElement(neighborLeft)) < 0) {
						return i;
					}
				}
				//---------------------------------------------------------------------
			}
		} else {
			return 0;
		}
		return -1;
	}

	/**
	 * @param N              is Vector of double elements
	 * @param SOUGHT_ELEMENT value we searching
	 * @return idex of soughtedElement
	 */
	public static int linerSearch(final Vector N, final double SOUGHT_ELEMENT) {
		for (int i = 0; i < N.size(); i++) {
			if (Double.compare(N.getElement(i), SOUGHT_ELEMENT) == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param N              is Vector of double elements
	 * @param SOUGHT_ELEMENT value we searching
	 * @return idex of soughtedElement
	 */
	public static int binarySearchIncrease(Vector N, final double SOUGHT_ELEMENT) {
		if (VectorChecker.isSortedIncrease(N)) {
			//---------------------------------------------------------------------
			int start = 0;
			int end = N.size() - 1;

			while (start <= end) {
				int middle = ((start + end) / 2);

				if (Double.compare(N.getElement(middle), SOUGHT_ELEMENT) == 0) {
					return middle;
				} else if (Double.compare(N.getElement(middle), SOUGHT_ELEMENT) > 0) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
			}
			//---------------------------------------------------------------------
		}
		return -1;
	}

	/**
	 * @param N              is Vector of double elements
	 * @param SOUGHT_ELEMENT value we searching
	 * @return idex of soughtedElement
	 */
	public static int binarySearchDecrease(Vector N, final double SOUGHT_ELEMENT) {
		if (VectorChecker.isSortedDecrease(N)) {
			//---------------------------------------------------------------------
			int start = 0;
			int end = N.size() - 1;

			while (start <= end) {
				int middle = ((start + end) / 2);

				if (Double.compare(N.getElement(middle), SOUGHT_ELEMENT) == 0) {
					return middle;
				} else if (Double.compare(N.getElement(middle), SOUGHT_ELEMENT) < 0) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
			}
			//---------------------------------------------------------------------
		}
		return -1;
	}
}
