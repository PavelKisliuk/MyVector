package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import by.epam.javatraining.pavelkisliuk.util.VectorInitializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorFinderTest {

	@Test
	public void max() {
		double[] ar = {1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double expected = 1.5;
		assertEquals(expected, VectorFinder.max(N), 0.0000000000000001);
	}

	@Test(expected = NullPointerException.class)
	public void maxException() {
		VectorFinder.max(null);
	}

	@Test
	public void min() {
		double[] ar = {1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double expected = 0.0;
		assertEquals(expected, VectorFinder.min(N), 0.0000000000000001);
	}

	@Test(expected = NullPointerException.class)
	public void minException() {
		VectorFinder.min(null);
	}

	@Test
	public void localMax() {
		double[] ar = {1.0, 1.1, 1.3, 1.2, 1.1, 1.0};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		int expected = 2;
		assertEquals(expected, VectorFinder.localMax(N));
	}

	@Test(expected = NullPointerException.class)
	public void localMaxException() {
		VectorFinder.localMax(null);
	}

	@Test
	public void localMin() {
		double[] ar = {0.2, -1.2123, -1.2345, -2.5, -2.3456, -3.4567};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		int expected = 3;
		assertEquals(expected, VectorFinder.localMin(N));
	}

	@Test(expected = NullPointerException.class)
	public void localMinException() {
		VectorFinder.localMin(null);
	}

	@Test
	public void linerSearch() {
		double[] ar = {94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double element = 97.44325044774021;
		int expected = 6;
		assertEquals(expected, VectorFinder.linerSearch(N, element));
	}

	@Test(expected = NullPointerException.class)
	public void linerSearchException() {
		VectorFinder.linerSearch(null, 0);
	}

	@Test
	public void binarySearchIncrease() {
		double[] ar = {-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double element = -13.999628910544828;
		int expected = 3;
		assertEquals(expected, VectorFinder.binarySearchIncrease(N, element));
	}

	@Test(expected = NullPointerException.class)
	public void binarySearchIncreaseException() {
		VectorFinder.binarySearchIncrease(null, 0);
	}

	@Test
	public void binarySearchDecrease() {
		double[] ar = {97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double element = -13.999628910544828;
		int expected = 6;
		assertEquals(expected, VectorFinder.binarySearchDecrease(N, element));
	}

	@Test(expected = NullPointerException.class)
	public void binarySearchDecreaseException() {
		VectorFinder.binarySearchDecrease(null, 0);
	}
}