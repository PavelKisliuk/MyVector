package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorWorkerTest {

	@Test
	public void averageArithmetic() {
		Vector N = new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0);
		double expected = 1.0714285714;
		assertEquals(expected, VectorWorker.averageArithmetic(N), 0.000001);
		//-------------
		N = new Vector(-1.2345, -2.3456, 1.2, -3.45678, -2.1, -3.4567, 0.0);
		expected = -1.6276542857;
		assertEquals(expected, VectorWorker.averageArithmetic(N), 0.000001);
		//-------------
		N = new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0);
		expected = 2.68479714285;
		assertEquals(expected, VectorWorker.averageArithmetic(N), 0.000001);
		//-------------
		N = new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001);
		expected = 0.0185185;
		assertEquals(expected, VectorWorker.averageArithmetic(N), 0.000001);
		//-------------
		N = new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001);
		expected = -0.0185185;
		assertEquals(expected, VectorWorker.averageArithmetic(N), 0.000001);
	}

	@Test
	public void averageGeometric() {
		Vector N = new Vector(1.1, 1.2, 1.3, 1.4, 1.5, 1.0);
		double expected = 1.2381960;
		assertEquals(expected, VectorWorker.averageGeometric(N), 0.000001);
		//-------------
		N = new Vector(-1.2345, -2.3456, 1.2123, -2.1, -3.4567, 5.2);
		expected = 2.2579097;
		assertEquals(expected, VectorWorker.averageGeometric(N), 0.000001);
		//-------------
		N = new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0);
		expected = 2.382671;
		assertEquals(expected, VectorWorker.averageGeometric(N), 0.000001);
		//-------------
		N = new Vector(00.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001);
		expected = 0.0003162;
		assertEquals(expected, VectorWorker.averageGeometric(N), 0.000001);
		//-------------
		N = new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001);
		expected = 0.0003162;
		assertEquals(expected, VectorWorker.averageGeometric(N), 0.000001);
	}
}