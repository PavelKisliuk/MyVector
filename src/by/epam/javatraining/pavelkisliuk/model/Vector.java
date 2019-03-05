package by.epam.javatraining.pavelkisliuk.model;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Vector {
	private double[] dataArrayD;

	public Vector(final int SIZE)
	{
		this.dataArrayD = new double[SIZE];
		this.fillArray();
	}

	public Vector(final double...VALUE_ARRAY)
	{
		this.dataArrayD = new double[VALUE_ARRAY.length];
		this.fillArray(VALUE_ARRAY);
	}

	public Vector(final String PATH, final int SIZE)
	{
		this.dataArrayD = new double[SIZE];
		this.fillArray(PATH);
	}

	public Vector(final Vector newVector)
	{
		this.dataArrayD = new double[newVector.size()];
		this.fillArray(newVector);
	}

	private void fillArray()
	{
		SecureRandom secureRandom = new SecureRandom();
		for(int i = 0; i < this.dataArrayD.length; i++) {
			this.dataArrayD[i] = secureRandom.nextDouble() * 200 - 100;
		}
	}

	private void fillArray(final double...VALUE_ARRAY)
	{
		this.dataArrayD = Arrays.copyOf(VALUE_ARRAY, VALUE_ARRAY.length);
	}

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

	private void fillArray(Vector newVector)
	{
		for(int i = 0; i < newVector.size(); i++) {
			this.dataArrayD[i] = newVector.getElement(i);
		}
	}

	public double getElement(int index)
	{
		return this.dataArrayD[index];
	}

	public void setElement(double newValue, int index)
	{
		this.dataArrayD[index] = newValue;
	}

	public void addElements(final double...ELEMENT_ARRAY)
	{
		double[] tempArray = Arrays.copyOf(this.dataArrayD, this.dataArrayD.length);
		this.dataArrayD = new double[tempArray.length + ELEMENT_ARRAY.length];
		this.dataArrayD = Arrays.copyOf(tempArray, tempArray.length);
		System.arraycopy(ELEMENT_ARRAY, 0,
				this.dataArrayD, this.dataArrayD.length, ELEMENT_ARRAY.length);
	}

	public int size()
	{
		return this.dataArrayD.length;
	}
}
