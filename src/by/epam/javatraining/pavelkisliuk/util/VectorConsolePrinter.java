/*
 * By Pavel Kisliuk, 17.03.2019
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

package by.epam.javatraining.pavelkisliuk.util;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;

/**
 * The {@code VectorConsolePrinter} just input Vector to console
 *
 * @author Kisliuk Pavel Sergeevich
 * @since 1.0
 */

public class VectorConsolePrinter {
	// Suppresses default constructor, ensuring non-instantiability.
	private VectorConsolePrinter() {
	}

	/**
	 * print {@param N} to console
	 */
	public static void print(final Vector N) {
		System.out.println(N);
		System.out.println("//------------------------------");
	}
}
