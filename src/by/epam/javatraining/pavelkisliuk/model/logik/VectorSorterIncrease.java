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
 * The {@code VectorSorter} class for sorting Vector in ascending manner
 *
 * <p>This class provides several methods for Vector sorting
 * in ascending manner
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorSorterIncrease implements VectorSorter {

	/**
	 * Sorting N by Bubble Sort in ascending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void bubbleSort(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		for (int pass = 0; pass < N.size(); pass++) {
			for (int i = 0; i < (N.size() - 1); i++) {
				if (Double.compare(N.getElement(i), N.getElement(i + 1)) > 0) {
					double temp = N.getElement(i);
					N.setElement(N.getElement(i + 1), i);
					N.setElement(temp, i + 1);
				}
			}
		}
	}

	/**
	 * Sorting N by Bubble Sort with specify boost in ascending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void enhancedBubbleSort(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		int passCounter = N.size();
		for (int pass = 0; pass < N.size(); pass++) {
			passCounter--;
			boolean exchangeFlag = false;
			for (int i = 0; i < passCounter; i++) {
				if (Double.compare(N.getElement(i), N.getElement(i + 1)) > 0) {
					double temp = N.getElement(i);
					N.setElement(N.getElement(i + 1), i);
					N.setElement(temp, i + 1);
					exchangeFlag = true;
				}
			}
			if (!exchangeFlag) {
				break;
			}
		}
	}

	/**
	 * Sorting N by Selection Sort in ascending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void selectionSort(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		for (int i = 0; i < N.size(); i++) {
			int minElementIndex = i;
			double min = N.getElement(i);
			for (int j = i; j < N.size(); j++) {
				if (Double.compare(min, N.getElement(j)) > 0) {
					min = N.getElement(j);
					minElementIndex = j;
				}
			}
			N.setElement(N.getElement(i), minElementIndex);
			N.setElement(min, i);
		}
	}


	/**
	 * Sorting N by Insertion Sort in ascending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void insertionSort(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		for (int i = 1; i < N.size(); i++) {
			for (int j = i; (j > 0) && (Double.compare(N.getElement((j - 1)), N.getElement(j)) > 0); j--) {
				double temp = N.getElement((j - 1));
				N.setElement(N.getElement(j), (j - 1));
				N.setElement(temp, j);
			}
		}
	}

	/**
	 * Sorting N by Merge Sort in ascending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void mergeSort(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		mergeSort(N, (0), (N.size() - 1));
	}

	private void mergeSort(Vector N, int startIndex, int endIndex) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		if (startIndex < endIndex) {
			mergeSort(N, startIndex, ((startIndex + endIndex) / 2));
			mergeSort(N, (((startIndex + endIndex) / 2) + 1), endIndex);

			Vector tempVector = new Vector(N);
			int middle = (startIndex + endIndex) / 2;
			int start = startIndex;
			int end = middle + 1;
			for (int i = startIndex; i <= endIndex; i++) {
				if ((start <= middle) && ((end > endIndex) ||
						(Double.compare(N.getElement(start), N.getElement(end)) < 0))) {
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
	 * Sorting N by Quick Sort in ascending manner
	 *
	 * @param N is Vector of double elements
	 */
	@Override
	public void quickSort(Vector N) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		quickSort(N, (0), (N.size() - 1));
	}

	private void quickSort(Vector N, int startIndex, int endIndex) {
		if (N == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		double element = N.getElement(((startIndex + endIndex) / 2));

		int start = startIndex;
		int end = endIndex;

		while (start < end) {
			while (Double.compare(N.getElement(start), element) < 0) {
				start++;
			}
			while (Double.compare(N.getElement(end), element) > 0) {
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
