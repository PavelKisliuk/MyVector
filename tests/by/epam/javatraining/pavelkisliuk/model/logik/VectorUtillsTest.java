package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorUtillsTest {

	@Test
	public void max() {
		Vector N = new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0);
		double expected = 1.5;
		assertEquals(expected, VectorUtills.max(N), 0.0000000000000001);
	}

	@Test
	public void min() {
	}

	@Test
	public void averageAriphmetic() {
	}

	@Test
	public void averageGeometric() {
	}

	@Test
	public void isSortedIncrease() {
	}

	@Test
	public void isSortedDecrease() {
	}

	@Test
	public void findLocalMax() {
	}

	@Test
	public void findLocalMin() {
	}

	@Test
	public void reverse() {
	}

	@Test
	public void linerSearch() {
	}

	@Test
	public void binarySearchIncrease() {
	}

	@Test
	public void binarySearchDecrease() {
	}

	@Test
	public void bubbleSortIncrease() {
	}

	@Test
	public void bubbleSortDecrease() {
	}

	@Test
	public void enhancedBubbleSortIncrease() {
	}

	@Test
	public void enhancedBubbleSortDecrease() {
	}

	@Test
	public void selectionSortIncrease() {
	}

	@Test
	public void selectionSortDecrease() {
	}

	@Test
	public void insertionSortIncrease() {
	}

	@Test
	public void insertionSortDecrease() {
	}

	@Test
	public void mergeSortIncrease() {
	}

	@Test
	public void mergeSortDecrease() {
	}

	@Test
	public void quickSortIncrease() {
	}

	@Test
	public void quickSortDecrease() {
	}
}