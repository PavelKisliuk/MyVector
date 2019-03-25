package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import by.epam.javatraining.pavelkisliuk.util.VectorInitializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorSorterDecreaseTest {

	@Test
	public void bubbleSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.bubbleSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void bubbleSortException() {
		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.bubbleSort(null);
	}

	@Test
	public void enhancedBubbleSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.enhancedBubbleSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void enhancedBubbleSortException() {
		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.enhancedBubbleSort(null);
	}

	@Test
	public void selectionSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.selectionSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void selectionSortException() {
		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.selectionSort(null);
	}

	@Test
	public void insertionSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.insertionSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void insertionSortException() {
		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.insertionSort(null);
	}

	@Test
	public void mergeSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.mergeSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void mergeSortException() {
		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.mergeSort(null);
	}

	@Test
	public void quickSort() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		double[] arEx = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		Vector expected = new Vector(arEx.length);
		VectorInitializer.init(expected, arEx);

		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.quickSort(N);
		assertEquals(expected, N);
	}

	@Test(expected = NullPointerException.class)
	public void quickSortException() {
		VectorSorterDecrease sorterDecrease = new VectorSorterDecrease();
		sorterDecrease.quickSort(null);
	}
}