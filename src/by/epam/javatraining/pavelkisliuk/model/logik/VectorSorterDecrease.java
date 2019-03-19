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
 * The {@code VectorSorter} class for sorting Vector in descending manner
 *
 * <p>This class provides several methods for Vector sorting
 * in descending manner
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorSorterDecrease implements VectorSorter {

	/**
	 * Sorting N by Bubble Sort in descending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void bubbleSort(final Vector N) {
		for (int pass = 0; pass < N.size(); pass++) {
			for (int i = 0; i < (N.size() - 1); i++) {
				if (Double.compare(N.getElement(i), N.getElement(i + 1)) < 0) {
					double temp = N.getElement(i);
					N.setElement(N.getElement(i + 1), i);
					N.setElement(temp, i + 1);
				}
			}
		}
	}

	/**
	 * Sorting N by Bubble Sort with specify boost in descending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void enhancedBubbleSort(final Vector N) {
		int passCounter = N.size();
		for (int pass = 0; pass < N.size(); pass++) {
			passCounter--;
			boolean exchangeFlag = false;
			for (int i = 0; i < passCounter; i++) {
				if (Double.compare(N.getElement(i), N.getElement((i + 1))) < 0) {
					double temp = N.getElement(i);
					N.setElement(N.getElement((i + 1)), i);
					N.setElement(temp, (i + 1));
					exchangeFlag = true;
				}
			}
			if (!exchangeFlag) {
				break;
			}
		}
	}

	/**
	 * Sorting N by Selection Sort in descending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void selectionSort(final Vector N) {
		for (int i = 0; i < N.size(); i++) {
			int maxElementIndex = i;
			double max = N.getElement(i);
			for (int j = i; j < N.size(); j++) {
				if (Double.compare(max, N.getElement(j)) < 0) {
					max = N.getElement(j);
					maxElementIndex = j;
				}
			}
			N.setElement(N.getElement(i), maxElementIndex);
			N.setElement(max, i);
		}
	}


	/**
	 * Sorting N by Insertion Sort in descending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void insertionSort(final Vector N) {
		for (int i = 1; i < N.size(); i++) {
			for (int j = i; (j > 0) && (Double.compare(N.getElement((j - 1)), N.getElement(j)) < 0); j--) {
				double temp = N.getElement((j - 1));
				N.setElement(N.getElement(j), (j - 1));
				N.setElement(temp, j);
			}
		}
	}

	/**
	 * Sorting N by Merge Sort in descending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void mergeSort(final Vector N) {
		mergeSort(N, (0), (N.size() - 1));
	}

	private void mergeSort(final Vector N, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			mergeSort(N, startIndex, ((startIndex + endIndex) / 2));
			mergeSort(N, (((startIndex + endIndex) / 2) + 1), endIndex);

			Vector tempVector = new Vector(N);
			int middle = (startIndex + endIndex) / 2;
			int start = startIndex;
			int end = middle + 1;
			for (int i = startIndex; i <= endIndex; i++) {
				if ((start <= middle) && ((end > endIndex) ||
						(Double.compare(N.getElement(start), N.getElement(end)) > 0))) {
					tempVector.setElement(N.getElement(start), i);
					start++;
				} else {
					tempVector.setElement(N.getElement(end), i);
					end++;
				}
			}

			for (int i = startIndex; i <= endIndex; i++) {
				N.setElement(tempVector.getElement(i), i);
			}
		}
	}

	/**
	 * Sorting N by Quick Sort in descending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void quickSort(final Vector N) {
		quickSort(N, (0), (N.size() - 1));
	}

	private void quickSort(final Vector N, int startIndex, int endIndex) {
		double element = N.getElement(((startIndex + endIndex) / 2));

		int start = startIndex;
		int end = endIndex;

		while (start < end) {
			while (Double.compare(N.getElement(start), element) > 0) {
				start++;
			}
			while (Double.compare(N.getElement(end), element) < 0) {
				end--;
			}

			if (start <= end) {
				double temp = N.getElement(start);
				N.setElement(N.getElement(end), start);
				N.setElement(temp, end);
				start++;
				end--;
			}
		}

		if (startIndex < end) {
			quickSort(N, startIndex, end);
		}
		if (start < endIndex) {
			quickSort(N, start, endIndex);
		}
	}
}
