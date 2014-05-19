package hardcode.papierjosef.bibliothek.test;

import static org.junit.Assert.assertEquals;
import hardcode.papierjosef.bibliothek.modell.Absatz;

import org.junit.Test;

public class AbsatzTest {

	@Test
	public void ersetzungsTest() {
		assertEquals("Test AAAAAAAAAAAA, bla",
				Absatz.ersetzeKlammern("Test (Beck, 1945), bla"));

		assertEquals(Absatz.ersetzeKlammern("(Beck, 1945)").length(),
				"(Beck, 1945)".length());
	}
}
