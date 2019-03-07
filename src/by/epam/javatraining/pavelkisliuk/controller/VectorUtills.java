package by.epam.javatraining.pavelkisliuk.controller;

import by.epam.javatraining.pavelkisliuk.model.Vector;

public class VectorUtills {

	public static double max(Vector N) {
		double max = N.getElement(0);
		for (int i = 1; i < N.size(); i++) {
			if (Double.compare(max, N.getElement(i)) < 0) {
				max = N.getElement(i);
			}
		}
		return max;
	}

	public static double min(Vector N) {
		double min = N.getElement(0);
		for (int i = 1; i < N.size(); i++) {
			if (Double.compare(min, N.getElement(i)) > 0) {
				min = N.getElement(i);
			}
		}
		return min;
	}

	public static double average(Vector N) {
		double average = 0.0;
		for (int i = 0; i < N.size(); i++) {
			average += N.getElement(i);
		}
		return (average / N.size());
	}

	public static boolean isSortedIncrease(Vector N) {
		for (int i = 0; i < (N.size() - 1); i++) {
			if (Double.compare(N.getElement(i), N.getElement(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSortedDecrease(Vector N) {
		for (int i = 0; i < (N.size() - 1); i++) {
			if (Double.compare(N.getElement(i), N.getElement(i + 1)) < 0) {
				return false;
			}
		}
		return true;
	}

	public static void reverse(Vector N) {
		for (int starting = 0, ending = (N.size() - 1); starting != (N.size() / 2); starting++, ending--) {
			double temp = N.getElement(starting);
			N.setElement(N.getElement(ending), starting);
			N.setElement(temp, ending);
		}
	}

	public static void bubbleSortIncrease(Vector N) {
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

	public static void bubbleSortDecrease(Vector N) {
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

	public static void enhancedBubbleSortIncrease(Vector N) {
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

	public static void enhancedBubbleSortDecrease(Vector N) {
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

	public static void selectionSortIncrease(Vector N) {
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

	public static void selectionSortDecrease(Vector N) {
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

	public static void insertionSortIncrease(Vector N) {
		for (int i = 1; i < N.size(); i++) {
			for (int j = i; (j > 0) && (Double.compare(N.getElement((j - 1)), N.getElement(j)) > 0); j--) {
				double temp = N.getElement((j - 1));
				N.setElement(N.getElement(j), (j - 1));
				N.setElement(temp, j);
			}
		}
	}

	public static void insertionSortDecrease(Vector N) {
		for (int i = 1; i < N.size(); i++) {
			for (int j = i; (j > 0) && (Double.compare(N.getElement((j - 1)), N.getElement(j)) < 0); j--) {
				double temp = N.getElement((j - 1));
				N.setElement(N.getElement(j), (j - 1));
				N.setElement(temp, j);
			}
		}
	}

	public static void mergeSortIncrease(Vector N) {
		VectorUtills.mergeSortIncrease(N, (0), (N.size() - 1));
	}

	private static void mergeSortIncrease(Vector N, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			VectorUtills.mergeSortIncrease(N, startIndex, ((startIndex + endIndex) / 2));
			VectorUtills.mergeSortIncrease(N, (((startIndex + endIndex) / 2) + 1), endIndex);
			VectorUtills.mergeIncrease(N, startIndex, endIndex);
		}
	}

	private static void mergeIncrease(Vector N, int startIndex, int endIndex) {
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

	public static void mergeSortDecrease(Vector N) {
		VectorUtills.mergeSortDecrease(N, (0), (N.size() - 1));
	}

	private static void mergeSortDecrease(Vector N, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			VectorUtills.mergeSortDecrease(N, startIndex, ((startIndex + endIndex) / 2));
			VectorUtills.mergeSortDecrease(N, (((startIndex + endIndex) / 2) + 1), endIndex);
			VectorUtills.mergeDecrease(N, startIndex, endIndex);
		}
	}

	private static void mergeDecrease(Vector N, int startIndex, int endIndex) {
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

	public static void quickSortIncrease(Vector N)
	{

	}

	public static void quickSortIncrease(Vector N)
	{

	}
}