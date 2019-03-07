package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;

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

	public static double averageAriphmetic(Vector N) {
		double average = 0.0;
		for (int i = 0; i < N.size(); i++) {
			average += N.getElement(i);
		}
		return (average / N.size());
	}

	public static double averageGeometric(Vector N) {
		double average = 1.0;
		for (int i = 0; i < N.size(); i++) {
			average *= N.getElement(i);
		}
		return Math.pow(average, 1.0 / N.size());
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

	public static int findLocalMax(Vector N) {
		for (int i = 0, neighborLeft = (i - 1), neighborRight = (i + 1); i < N.size(); // ->
			 i++, neighborLeft++, neighborRight++) {
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
		}
		return -1;
	}

	public static int findLocalMin(Vector N) {
		for (int i = 0, neighborLeft = (i - 1), neighborRight = (i + 1); i < N.size(); // ->
			 i++, neighborLeft++, neighborRight++) {
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
		}
		return -1;
	}

	public static void reverse(Vector N) {
		for (int starting = 0, ending = (N.size() - 1); starting != (N.size() / 2); starting++, ending--) {
			double temp = N.getElement(starting);
			N.setElement(N.getElement(ending), starting);
			N.setElement(temp, ending);
		}
	}

	public static int linerSearch(Vector N, double soughtedElement) {
		for (int i = 0; i < N.size(); i++) {
			if (Double.compare(N.getElement(i), soughtedElement) == 0) {
				return i;
			}
		}
		return -1;
	}


	public static int binarySearchIncrease(Vector N, double soughtedElement) {
		int start = 0;
		int end = N.size() - 1;

		while (start <= end) {
			int middle = ((start + end) / 2);

			if (Double.compare(N.getElement(middle), soughtedElement) == 0) {
				return middle;
			} else if (Double.compare(N.getElement(middle), soughtedElement) > 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}

	public static int binarySearchDecrease(Vector N, double soughtedElement) {
		int start = 0;
		int end = N.size() - 1;

		while (start <= end) {
			int middle = ((start + end) / 2);

			if (Double.compare(N.getElement(middle), soughtedElement) == 0) {
				return middle;
			} else if (Double.compare(N.getElement(middle), soughtedElement) < 0) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return -1;
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

	public static void mergeSortDecrease(Vector N) {
		VectorUtills.mergeSortDecrease(N, (0), (N.size() - 1));
	}

	private static void mergeSortDecrease(Vector N, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			VectorUtills.mergeSortDecrease(N, startIndex, ((startIndex + endIndex) / 2));
			VectorUtills.mergeSortDecrease(N, (((startIndex + endIndex) / 2) + 1), endIndex);

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

	public static void quickSortIncrease(Vector N) {
		VectorUtills.quickSortIncrease(N, (0), (N.size() - 1));
	}

	private static void quickSortIncrease(Vector N, int startIndex, int endIndex) {
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
			VectorUtills.quickSortIncrease(N, startIndex, end);
		}
		if (start < endIndex) {
			VectorUtills.quickSortIncrease(N, start, endIndex);
		}
	}

	public static void quickSortDecrease(Vector N) {
		VectorUtills.quickSortDecrease(N, (0), (N.size() - 1));
	}

	private static void quickSortDecrease(Vector N, int startIndex, int endIndex) {
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
			VectorUtills.quickSortDecrease(N, startIndex, end);
		}
		if (start < endIndex) {
			VectorUtills.quickSortDecrease(N, start, endIndex);
		}
	}
}