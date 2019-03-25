package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import by.epam.javatraining.pavelkisliuk.util.VectorInitializer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VectorCheckerTest {

	@Test
	public void isSortedIncrease() {
		double[] ar = {-3.4567, -2.3456, -2.1, -1.2345, 1.2123, 5.2};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		assertTrue(VectorChecker.isSortedIncrease(N));
	}

	@Test(expected = NullPointerException.class)
	public void isSortedIncreaseException() {
		VectorChecker.isSortedIncrease(null);
	}

	@Test
	public void isSortedDecrease() {
		double[] ar = {1.5, 1.4, 1.3, 1.2, 1.1, 1.0};
		Vector N = new Vector(ar.length);
		VectorInitializer.init(N, ar);
		assertTrue(VectorChecker.isSortedDecrease(N));
	}

	@Test(expected = NullPointerException.class)
	public void isSortedDecreaseException() {
		VectorChecker.isSortedDecrease(null);
	}
}