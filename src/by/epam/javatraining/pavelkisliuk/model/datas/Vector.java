/*
 * By Pavel Kisliuk, 08.03.2019
 * This is class for education and nothing rights don't reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by.epam.javatraining.pavelkisliuk.model.datas;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The {@code Vector} class-wrapper for array of double elements
 * <p>
 * This class contain array of double elements and methods for
 * setting and getting values of it's elements.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class Vector {
	public static final double RANDOM_LOWER_BOUND;
	public static final double RANDOM_UPPER_BOUND;
	/**
	 * Main type of data of this class
	 * Array of double elements
	 */
	private double[] dataArrayD;

	static {
		RANDOM_LOWER_BOUND = -100.0;
		RANDOM_UPPER_BOUND = 100.0;
	}


	/**
	 * {@code Vector} constructor of random elements
	 *
	 * @param SIZE of {@param Vector}
	 */
	public Vector(final int SIZE) {
		dataArrayD = new double[SIZE];
		fillArray();
	}

	/**
	 * {@code Vector} constructor of random elements
	 *
	 * @param SIZE        of {@param Vector}
	 * @param LOWER_BOUND lower bound of random elements
	 * @param UPPER_BOUND upper bound of random elements
	 */
	public Vector(final int SIZE, final double LOWER_BOUND, final double UPPER_BOUND) {
		dataArrayD = new double[SIZE];
		if (Double.compare(LOWER_BOUND, UPPER_BOUND) < 0) {
			fillArray(LOWER_BOUND, UPPER_BOUND);
		} else {
			fillArray(UPPER_BOUND, LOWER_BOUND);
		}
	}

	/**
	 * {@code Vector} constructor of  specify element
	 *
	 * @param SIZE  of {@param Vector}
	 * @param VALUE specify element
	 */
	public Vector(final int SIZE, final double VALUE) {
		dataArrayD = new double[SIZE];
		if (Double.compare(VALUE, 0.0) != 0) {
			fillArray(VALUE);
		}
	}

	/**
	 * {@code Vector} constructor of specify values
	 *
	 * @param VALUE_ARRAY array of specified values
	 */
	public Vector(final double... VALUE_ARRAY) {
		dataArrayD = new double[VALUE_ARRAY.length];
		fillArray(VALUE_ARRAY);
	}

	/**
	 * {@code Vector} constructor from file
	 *
	 * @param PATH to file
	 * @param SIZE of array
	 */
	public Vector(final String PATH, final int SIZE) {
		dataArrayD = new double[SIZE];
		fillArray(PATH);
	}

	/**
	 * {@code Vector} copy constructor
	 *
	 * @param NEW_VECTOR object we copy
	 */
	public Vector(final Vector NEW_VECTOR) {
		dataArrayD = new double[NEW_VECTOR.size()];
		fillArray(NEW_VECTOR);
	}

	/**
	 * fill by random elements
	 */
	private void fillArray() {
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < dataArrayD.length; i++) {
			dataArrayD[i] = (secureRandom.nextDouble() *
					(RANDOM_UPPER_BOUND - RANDOM_LOWER_BOUND)) + RANDOM_LOWER_BOUND;
		}
	}

	/**
	 * fill by random elements for specify bounds
	 *
	 * @param LOWER_BOUND lower bound of random elements
	 * @param UPPER_BOUND upper bound of random elements
	 */
	private void fillArray(final double LOWER_BOUND, final double UPPER_BOUND) {
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < dataArrayD.length; i++) {
			dataArrayD[i] = (secureRandom.nextDouble() *
					(UPPER_BOUND - LOWER_BOUND)) + LOWER_BOUND;
		}
	}

	/**
	 * fill by specify element
	 *
	 * @param VALUE specify element
	 */
	private void fillArray(final double VALUE) {
		for (int i = 0; i < dataArrayD.length; i++) {
			dataArrayD[i] = VALUE;
		}
	}

	/**
	 * @param VALUE_ARRAY array we fill Vector
	 */
	private void fillArray(final double... VALUE_ARRAY) {
		dataArrayD = Arrays.copyOf(VALUE_ARRAY, VALUE_ARRAY.length);
	}

	/**
	 * fill from file
	 *
	 * @param PATH to file
	 */
	private void fillArray(final String PATH) {
		try (Scanner input = new Scanner(Paths.get(PATH))) {
			int i = 0;
			while (input.hasNext()) {
				dataArrayD[i++] = input.nextDouble();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * copy from
	 *
	 * @param NEW_VECTOR to this Vector
	 */
	private void fillArray(Vector NEW_VECTOR) {
		for (int i = 0; i < NEW_VECTOR.size(); i++) {
			dataArrayD[i] = NEW_VECTOR.getElement(i);
		}
	}

	/**
	 * @param INDEX of array of Vector
	 * @return specify element
	 */
	public double getElement(final int INDEX) {
		return dataArrayD[INDEX];
	}

	/**
	 * @param NEW_VALUE writes to
	 * @param INDEX     of element
	 */
	public void setElement(final double NEW_VALUE, final int INDEX) {
		dataArrayD[INDEX] = NEW_VALUE;
	}

	/**
	 * add specify elements to this Vector
	 *
	 * @param ELEMENT_ARRAY array of specify elements
	 */
	public void add(final double... ELEMENT_ARRAY) {
		double[] tempArray = Arrays.copyOf(dataArrayD, dataArrayD.length);
		dataArrayD = new double[tempArray.length + ELEMENT_ARRAY.length];
		dataArrayD = Arrays.copyOf(tempArray, tempArray.length);
		System.arraycopy(ELEMENT_ARRAY, 0,
				dataArrayD, dataArrayD.length, ELEMENT_ARRAY.length);
	}

	/**
	 * @return size of Vector
	 */
	public int size() {
		return dataArrayD.length;
	}

	/**
	 * @return Vector as String
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (double d : dataArrayD) {
			str.append(d).append("\n");
		}
		return str.toString();
	}

	/**
	 * Compare two Vectors
	 *
	 * @param o another Vector
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Vector vector = (Vector) o;

		return Arrays.equals(dataArrayD, vector.dataArrayD);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(dataArrayD);
	}
}
