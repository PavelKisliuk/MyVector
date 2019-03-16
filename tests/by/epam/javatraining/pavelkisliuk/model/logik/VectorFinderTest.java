package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorFinderTest {

	@Test
	public void max() {
		Vector N = new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0);
		double expected = 1.5;
		assertEquals(expected, VectorFinder.max(N), 0.0000000000000001);
		//-------------
		N = new Vector(-1.2345, -2.3456, 1.2, -3.45678, -2.1, -3.4567, 0.0);
		expected = 1.2;
		assertEquals(expected, VectorFinder.max(N), 0.0000000000000001);
		//-------------
		N = new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 0.0);
		expected = 3.45678;
		assertEquals(expected, VectorFinder.max(N), 0.0000000000000001);
		//-------------
		N = new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001);
		expected = 0.1;
		assertEquals(expected, VectorFinder.max(N), 0.0000000000000001);
		//-------------
		N = new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001);
		expected = -0.000001;
		assertEquals(expected, VectorFinder.max(N), 0.0000000000000001);
	}

	@Test
	public void min() {
		Vector N = new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0);
		double expected = 0.0;
		assertEquals(expected, VectorFinder.min(N), 0.0000000000000001);
		//-------------
		N = new Vector(-1.2345, -2.3456, 1.2, -3.45678, -2.1, -3.4567, 0.0);
		expected = -3.45678;
		assertEquals(expected, VectorFinder.min(N), 0.0000000000000001);
		//-------------
		N = new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0);
		expected = 1.2;
		assertEquals(expected, VectorFinder.min(N), 0.0000000000000001);
		//-------------
		N = new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001);
		expected = 0.000001;
		assertEquals(expected, VectorFinder.min(N), 0.0000000000000001);
		//-------------
		N = new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001);
		expected = -0.1;
	}

	@Test
	public void localMax() {
		int expected = 2;
		assertEquals(expected, VectorFinder.localMax(new Vector(1.0, 1.1, 1.3, 1.2, 1.1, 1.0)));
		//-------------
		expected = 0;
		assertEquals(expected, VectorFinder.localMax(new Vector(0.2, -1.2123, -1.2345, -2.5, -2.3456, -3.4567)));
		//-------------
		expected = 6;
		assertEquals(expected, VectorFinder.localMax(new Vector(1.2345, 2.3456, 3.2, 3.45678, 4.1, 4.4567, 5.0)));
		//-------------
		expected = 0;
		assertEquals(expected, VectorFinder.localMax(new Vector(-0.000001, -0.00001, -0.0001, -0.001, -0.01, -0.1)));
		//-------------
		expected = 1;
		assertEquals(expected, VectorFinder.localMax(new Vector(1.0, 4.0, 3.0, 4.0)));
	}

	@Test
	public void localMin() {
		int expected = 0;
		assertEquals(expected, VectorFinder.localMin(new Vector(1.0, 1.1, 1.3, 1.2, 1.1, 1.0)));
		//-------------
		expected = 3;
		assertEquals(expected, VectorFinder.localMin(new Vector(0.2, -1.2123, -1.2345, -2.5, -2.3456, -3.4567)));
		//-------------
		expected = 0;
		assertEquals(expected, VectorFinder.localMin(new Vector(1.2345, 2.3456, 3.2, 3.45678, 4.1, 4.4567, 5.0)));
		//-------------
		expected = 5;
		assertEquals(expected, VectorFinder.localMin(new Vector(-0.000001, -0.00001, -0.0001, -0.001, -0.01, -0.1)));
		//-------------
		expected = 2;
		assertEquals(expected, VectorFinder.localMin(new Vector(5.0, 4.0, 3.0, 4.0)));
	}

	@Test
	public void linerSearch() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		double element = -13.999628910544828;
		int expected = 9;
		assertEquals(expected, VectorFinder.linerSearch(N, element));
	}

	@Test
	public void binarySearchIncrease() {
		Vector N = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		double element = -13.999628910544828;
		int expected = 3;
		assertEquals(expected, VectorFinder.binarySearchIncrease(N, element));
	}

	@Test
	public void binarySearchDecrease() {
		Vector N = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		double element = -13.999628910544828;
		int expected = 6;
		assertEquals(expected, VectorFinder.binarySearchDecrease(N, element));
	}
}