package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class VectorUtillsTest {
	enum Type {MAX, MIN, AVERAGE_A, AVERAGE_G}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				//-------------------------------------------------max
				{Type.MAX, new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0), 1.5},
				{Type.MAX, new Vector(-1.2345, -2.3456, 1.2, -3.45678, -2.1, -3.4567, 0.0), 1.2},
				{Type.MAX, new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 0.0), 3.45678},
				{Type.MAX, new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001), 0.1},
				{Type.MAX, new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001), -0.000001},
				//-------------------------------------------------min
				{Type.MIN, new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0), 0.0},
				{Type.MIN, new Vector(-1.2345, -2.3456, 1.2, -3.45678, -2.1, -3.4567, 0.0), -3.45678},
				{Type.MIN, new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0), 1.2},
				{Type.MIN, new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001), 0.000001},
				{Type.MIN, new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001), -0.1},
				//-------------------------------------------------averageArithmetic
				{Type.AVERAGE_A, new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0), 1.0714285714},
				{Type.AVERAGE_A, new Vector(-1.2345, -2.3456, 1.2, -3.45678, -2.1, -3.4567, 0.0), -1.6276542857},
				{Type.AVERAGE_A, new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0), 2.68479714285},
				{Type.AVERAGE_A, new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001), 0.0185185},
				{Type.AVERAGE_A, new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001), -0.0185185},
				//-------------------------------------------------averageGeometric
				{Type.AVERAGE_G, new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0), 1.2381960},
				{Type.AVERAGE_G, new Vector(-1.2345, -2.3456, 1.2123, -2.1, -3.4567, 5.2), 2.2579097},
				{Type.AVERAGE_G, new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0), 2.382671},
				{Type.AVERAGE_G, new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001), 0.0003162},
				{Type.AVERAGE_G, new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001), 0.0003162}
		});
	}

	private Type type;
	private Vector N;
	private double expected;

	public VectorUtillsTest(Type type, Vector N, double expected) {
		this.type = type;
		this.N = N;
		this.expected = expected;
	}

	@Test
	public void max() {
		Assume.assumeTrue(type == Type.MAX);
		assertEquals(expected, VectorUtills.max(N), 0.0000000000000001);
	}

	@Test
	public void min() {
		Assume.assumeTrue(type == Type.MIN);
		assertEquals(expected, VectorUtills.min(N), 0.0000000000000001);
	}

	@Test
	public void averageArithmetic() {
		Assume.assumeTrue(type == Type.AVERAGE_A);
		assertEquals(expected, VectorUtills.averageArithmetic(N), 0.000001);
	}

	@Test
	public void averageGeometric() {
		Assume.assumeTrue(type == Type.AVERAGE_G);
		assertEquals(expected, VectorUtills.averageGeometric(N), 0.000001);
	}

	@Test
	public void isSortedIncrease() {
		assertTrue(VectorUtills.isSortedIncrease(new Vector(1.0, 1.1, 1.2, 1.3, 1.4, 1.5)));
		assertTrue(VectorUtills.isSortedIncrease(new Vector(-3.4567, -2.3456, -2.1, -1.2345, 1.2123, 5.2)));
		//-------------
		assertFalse(VectorUtills.isSortedIncrease(new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0)));
		//-------------
		assertTrue(VectorUtills.isSortedIncrease(new Vector(0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1)));
		assertTrue(VectorUtills.isSortedIncrease(new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001)));
	}

	@Test
	public void isSortedDecrease() {
		assertTrue(VectorUtills.isSortedDecrease(new Vector(1.5, 1.4, 1.3, 1.2, 1.1, 1.0)));
		assertTrue(VectorUtills.isSortedDecrease(new Vector(5.2, 1.2123, -1.2345, -2.1, -2.3456, -3.4567)));
		//-------------
		assertFalse(VectorUtills.isSortedDecrease(new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0)));
		//-------------
		assertTrue(VectorUtills.isSortedDecrease(new Vector(-0.000001, -0.00001, -0.0001, -0.001, -0.01, -0.1)));
		assertTrue(VectorUtills.isSortedDecrease(new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001)));
	}

	@Test
	public void findLocalMax() {
		int expected = 2;
		assertEquals(expected, VectorUtills.findLocalMax(new Vector(1.0, 1.1, 1.3, 1.2, 1.1, 1.0)));
		expected = 0;
		assertEquals(expected, VectorUtills.findLocalMax(new Vector(0.2, -1.2123, -1.2345, -2.5, -2.3456, -3.4567)));
		expected = 6;
		assertEquals(expected, VectorUtills.findLocalMax(new Vector(1.2345, 2.3456, 3.2, 3.45678, 4.1, 4.4567, 5.0)));
		expected = 0;
		assertEquals(expected, VectorUtills.findLocalMax(new Vector(-0.000001, -0.00001, -0.0001, -0.001, -0.01, -0.1)));
		expected = 1;
		assertEquals(expected, VectorUtills.findLocalMax(new Vector(1.0, 4.0, 3.0, 4.0)));
	}

	@Test
	public void findLocalMin() {
		int expected = 0;
		assertEquals(expected, VectorUtills.findLocalMin(new Vector(1.0, 1.1, 1.3, 1.2, 1.1, 1.0)));
		expected = 3;
		assertEquals(expected, VectorUtills.findLocalMin(new Vector(0.2, -1.2123, -1.2345, -2.5, -2.3456, -3.4567)));
		expected = 0;
		assertEquals(expected, VectorUtills.findLocalMin(new Vector(1.2345, 2.3456, 3.2, 3.45678, 4.1, 4.4567, 5.0)));
		expected = 5;
		assertEquals(expected, VectorUtills.findLocalMin(new Vector(-0.000001, -0.00001, -0.0001, -0.001, -0.01, -0.1)));
		expected = 2;
		assertEquals(expected, VectorUtills.findLocalMin(new Vector(5.0, 4.0, 3.0, 4.0)));
	}

	@Test
	public void reverse() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-13.999628910544828, -38.253896246396565, 27.946499092274692,
				97.44325044774021, 53.584297771086966, 49.34155061768155, 87.17655295388712, -16.967061020748247,
				-51.842313057911426, 94.27724477951773);
		VectorUtills.reverse(N);
		assertEquals(expected, N);
	}

	@Test
	public void linerSearch() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		double element = -13.999628910544828;
		int expected = 9;
		assertEquals(expected, VectorUtills.linerSearch(N, element));
	}

	@Test
	public void binarySearchIncrease() {
		Vector N = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		double element = -13.999628910544828;
		int expected = 3;
		assertEquals(expected, VectorUtills.binarySearchIncrease(N, element));

	}

	@Test
	public void binarySearchDecrease() {
		Vector N = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		double element = -13.999628910544828;
		int expected = 6;
		assertEquals(expected, VectorUtills.binarySearchDecrease(N, element));
	}

	@Test
	public void bubbleSortIncrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		VectorUtills.bubbleSortIncrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void bubbleSortDecrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		VectorUtills.bubbleSortDecrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void enhancedBubbleSortIncrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		VectorUtills.enhancedBubbleSortIncrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void enhancedBubbleSortDecrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		VectorUtills.enhancedBubbleSortDecrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void selectionSortIncrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		VectorUtills.selectionSortIncrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void selectionSortDecrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		VectorUtills.selectionSortDecrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void insertionSortIncrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		VectorUtills.insertionSortIncrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void insertionSortDecrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		VectorUtills.insertionSortDecrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void mergeSortIncrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		VectorUtills.mergeSortIncrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void mergeSortDecrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		VectorUtills.mergeSortDecrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void quickSortIncrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-51.842313057911426, -38.253896246396565, -16.967061020748247,
				-13.999628910544828, 27.946499092274692, 49.34155061768155, 53.584297771086966, 87.17655295388712,
				94.27724477951773, 97.44325044774021);
		VectorUtills.quickSortIncrease(N);
		assertEquals(expected, N);
	}

	@Test
	public void quickSortDecrease() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(97.44325044774021, 94.27724477951773, 87.17655295388712, 53.584297771086966,
				49.34155061768155, 27.946499092274692, -13.999628910544828, -16.967061020748247, -38.253896246396565,
				-51.842313057911426);
		VectorUtills.quickSortDecrease(N);
		assertEquals(expected, N);
	}
}