package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VectorCheckerTest {

	@Test
	public void isSortedIncrease() {
		assertTrue(VectorChecker.isSortedIncrease(new Vector(1.0, 1.1, 1.2, 1.3, 1.4, 1.5)));
		assertTrue(VectorChecker.isSortedIncrease(new Vector(-3.4567, -2.3456, -2.1, -1.2345, 1.2123, 5.2)));
		//-------------
		assertFalse(VectorChecker.isSortedIncrease(new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0)));
		//-------------
		assertTrue(VectorChecker.isSortedIncrease(new Vector(0.000001, 0.00001, 0.0001, 0.001, 0.01, 0.1)));
		assertTrue(VectorChecker.isSortedIncrease(new Vector(-0.1, -0.01, -0.001, -0.0001, -0.00001, -0.000001)));
	}

	@Test
	public void isSortedDecrease() {
		assertTrue(VectorChecker.isSortedDecrease(new Vector(1.5, 1.4, 1.3, 1.2, 1.1, 1.0)));
		assertTrue(VectorChecker.isSortedDecrease(new Vector(5.2, 1.2123, -1.2345, -2.1, -2.3456, -3.4567)));
		//-------------
		assertFalse(VectorChecker.isSortedDecrease(new Vector(1.2345, 2.3456, 1.2, 3.45678, 2.1, 3.4567, 5.0)));
		//-------------
		assertTrue(VectorChecker.isSortedDecrease(new Vector(-0.000001, -0.00001, -0.0001, -0.001, -0.01, -0.1)));
		assertTrue(VectorChecker.isSortedDecrease(new Vector(0.1, 0.01, 0.001, 0.0001, 0.00001, 0.000001)));
	}
}