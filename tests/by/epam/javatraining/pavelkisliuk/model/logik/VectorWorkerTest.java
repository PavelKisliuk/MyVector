package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import by.epam.javatraining.pavelkisliuk.util.VectorInitializer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorWorkerTest {

	@Test
	public void averageArithmetic() {
		double[] ar = {1.1, 1.2, 1.3, 1.4, 1.5, 1.0, 0.0};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double expected = 1.0714285714;
		assertEquals(expected, VectorWorker.averageArithmetic(N), 0.000001);
	}

	@Test(expected = NullPointerException.class)
	public void averageArithmeticException() {
		VectorWorker.averageArithmetic(null);
	}

	@Test
	public void averageGeometric() {
		double[] ar = {1.1, 1.2, 1.3, 1.4, 1.5, 1.0};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		double expected = 1.2381960;
		assertEquals(expected, VectorWorker.averageGeometric(N), 0.000001);
	}

	@Test(expected = NullPointerException.class)
	public void averageGeometricException() {
		VectorWorker.averageGeometric(null);
	}
}