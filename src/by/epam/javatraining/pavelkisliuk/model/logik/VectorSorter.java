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
 * The {@code VectorSorter} interface for sorting manipulation with Vector
 *
 * <p>This interface provides several abstract methods for Vector sorting
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public interface VectorSorter {
	/**
	 * Sorting N by Bubble Sort
	 *
	 * @param N is Vector of double elements
	 */
	void bubbleSort(Vector N);

	/**
	 * Sorting N by Bubble Sort with specify boost
	 *
	 * @param N is Vector of double elements
	 */
	void enhancedBubbleSort(Vector N);

	/**
	 * Sorting N by Selection Sort
	 *
	 * @param N is Vector of double elements
	 */
	void selectionSort(Vector N);

	/**
	 * Sorting N by Insertion Sort
	 *
	 * @param N is Vector of double elements
	 */
	void insertionSort(Vector N);

	/**
	 * Sorting N by Merge Sort
	 *
	 * @param N is Vector of double elements
	 */
	void mergeSort(Vector N);

	/**
	 * Sorting N by Quick Sort
	 *
	 * @param N is Vector of double elements
	 */
	void quickSort(Vector N);

	/**
	 * Reverse {@param N} elements
	 *
	 * @param N is Vector of double elements
	 */
	static void reverse(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		if (N.size() > 1) {
			for (int starting = 0, ending = (N.size() - 1); starting != (N.size() / 2); starting++, ending--) {
				double temp = N.getElement(starting);
				N.setElement(N.getElement(ending), starting);
				N.setElement(temp, ending);
			}
		}
	}
}