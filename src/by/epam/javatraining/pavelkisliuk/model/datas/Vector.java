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
 *
 * This class contain array of double elements and methods for
 * setting and getting values of it's elements.
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class Vector {
	/**
	 * Main type of data of this class
	 */
	private double[] dataArrayD;

	/**
	 * {@code Vector} constructor of random elements
	 * @param SIZE of {@param Vector}
	 */
	public Vector(final int SIZE)
	{
		this.dataArrayD = new double[SIZE];
		this.fillArray();
	}

	/**
	 * {@code Vector} constructor of specify values
	 * @param VALUE_ARRAY array of specified values
	 */
	public Vector(final double...VALUE_ARRAY)
	{
		this.dataArrayD = new double[VALUE_ARRAY.length];
		this.fillArray(VALUE_ARRAY);
	}

	/**
	 * {@code Vector} constructor from file
	 * @param PATH to file
	 * @param SIZE of array
	 */
	public Vector(final String PATH, final int SIZE)
	{
		this.dataArrayD = new double[SIZE];
		this.fillArray(PATH);
	}

	/**
	 * {@code Vector} copy constructor
	 * @param newVector object we copy
	 */
	public Vector(final Vector newVector)
	{
		this.dataArrayD = new double[newVector.size()];
		this.fillArray(newVector);
	}

	/**
	 * fill by random elements
	 */
	private void fillArray()
	{
		SecureRandom secureRandom = new SecureRandom();
		for(int i = 0; i < this.dataArrayD.length; i++) {
			this.dataArrayD[i] = secureRandom.nextDouble() * 200 - 100;
		}
	}

	/**
	 * @param VALUE_ARRAY array we fill Vector
	 */
	private void fillArray(final double...VALUE_ARRAY)
	{
		this.dataArrayD = Arrays.copyOf(VALUE_ARRAY, VALUE_ARRAY.length);
	}

	/**
	 * fill from file
	 * @param PATH to file
	 */
	private void fillArray(final String PATH)
	{
		try(Scanner input = new Scanner(Paths.get(PATH))) {
			int i = 0;
			while(input.hasNext()) {
				this.dataArrayD[i++] = input.nextDouble();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * copy from
	 * @param newVector to this Vector
	 */
	private void fillArray(Vector newVector)
	{
		for(int i = 0; i < newVector.size(); i++) {
			this.dataArrayD[i] = newVector.getElement(i);
		}
	}

	/**
	 *
	 * @param index of array of Vector
	 * @return specify element
	 */
	public double getElement(int index)
	{
		return this.dataArrayD[index];
	}

	/**
	 *
	 * @param newValue writes to
	 * @param index of element
	 */
	public void setElement(double newValue, int index)
	{
		this.dataArrayD[index] = newValue;
	}

	/**
	 * add specify elements to this Vector
	 * @param ELEMENT_ARRAY array of specify elements
	 */
	public void addElements(final double...ELEMENT_ARRAY)
	{
		double[] tempArray = Arrays.copyOf(this.dataArrayD, this.dataArrayD.length);
		this.dataArrayD = new double[tempArray.length + ELEMENT_ARRAY.length];
		this.dataArrayD = Arrays.copyOf(tempArray, tempArray.length);
		System.arraycopy(ELEMENT_ARRAY, 0,
				this.dataArrayD, this.dataArrayD.length, ELEMENT_ARRAY.length);
	}

	/**
	 *
	 * @return size of Vector
	 */
	public int size()
	{
		return this.dataArrayD.length;
	}

	/**
	 *
	 * @return Vector as String
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(double d : dataArrayD) {
			str.append(String.valueOf(d + "\n"));
		}
		return str.toString();
	}

	/**
	 * Compare two Vectors
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
