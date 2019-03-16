package by.epam.javatraining.pavelkisliuk.model.logik;

import by.epam.javatraining.pavelkisliuk.model.datas.Vector;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorSorterTest {

	@Test
	public void reverse() {
		Vector N = new Vector(94.27724477951773, -51.842313057911426, -16.967061020748247,
				87.17655295388712, 49.34155061768155, 53.584297771086966, 97.44325044774021, 27.946499092274692,
				-38.253896246396565, -13.999628910544828);
		Vector expected = new Vector(-13.999628910544828, -38.253896246396565, 27.946499092274692,
				97.44325044774021, 53.584297771086966, 49.34155061768155, 87.17655295388712, -16.967061020748247,
				-51.842313057911426, 94.27724477951773);
		VectorSorter.reverse(N);
		assertEquals(expected, N);
	}
}