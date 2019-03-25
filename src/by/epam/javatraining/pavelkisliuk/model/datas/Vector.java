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

import java.util.Arrays;

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
	/**
	 * Main type of data of this class
	 * Array of double elements
	 */
	private double[] dataArrayD;

	/**
	 * default constructor
	 */
	public Vector() {
		dataArrayD = new double[0];
	}

	/**
	 * {@code Vector} constructor of special size
	 *
	 * @param size of {@param Vector}
	 */
	public Vector(int size) {
		dataArrayD = new double[size];
	}

	/**
	 * {@code Vector} copy constructor
	 *
	 * @param vector object we copy
	 */
	public Vector(Vector vector) {
		if (vector == null) {
			throw new NullPointerException();
		}
		//---------------------------------------------------------------------
		dataArrayD = new double[vector.size()];
		for (int i = 0; i < vector.size(); i++) {
			dataArrayD[i] = vector.getElement(i);
		}
	}

	/**
	 * @param index of array of Vector
	 * @return specify element
	 */
	public double getElement(int index) {
		return dataArrayD[index];
	}

	/**
	 * @param v     writes to
	 * @param index of element
	 */
	public void setElement(final double v, final int index) {
		dataArrayD[index] = v;
	}

	/**
	 * add specify elements to this Vector
	 *
	 * @param elementsArray array of specify elements
	 */
	public void add(final double... elementsArray) {
		double[] tempArray = Arrays.copyOf(dataArrayD, dataArrayD.length);
		dataArrayD = new double[tempArray.length + elementsArray.length];
		dataArrayD = Arrays.copyOf(tempArray, tempArray.length);
		System.arraycopy(elementsArray, 0,
				dataArrayD, dataArrayD.length, elementsArray.length);
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
