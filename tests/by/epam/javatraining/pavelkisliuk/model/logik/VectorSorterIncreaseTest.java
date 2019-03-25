package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import by.epam.javatraining.pavelkisliuk.util.VectorInitializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorSorterIncreaseTest {

	@Test
	public void bubbleSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.bubbleSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void bubbleSortException() {
		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.bubbleSort(null);
	}

	@Test
	public void enhancedBubbleSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.enhancedBubbleSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void enhancedBubbleSortException() {
		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.enhancedBubbleSort(null);
	}

	@Test
	public void selectionSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.selectionSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void selectionSortException() {
		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.selectionSort(null);
	}

	@Test
	public void insertionSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.insertionSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void insertionSortException() {
		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.insertionSort(null);
	}

	@Test
	public void mergeSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.mergeSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void mergeSortException() {
		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.mergeSort(null);
	}

	@Test
	public void quickSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.quickSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void quickSortException() {
		VectorSorterIncrease sorterIncrease = new VectorSorterIncrease();
		sorterIncrease.quickSort(null);
	}
}