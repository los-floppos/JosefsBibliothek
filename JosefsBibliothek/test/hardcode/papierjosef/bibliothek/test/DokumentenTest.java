package hardcode.papierjosef.bibliothek.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;

import java.util.List;

import org.junit.Test;

public class DokumentenTest {

	@Test
	public void absaetzeTrennenTest() {
		String testtext = "Das ist ein Test.\nUnd das der dazugeh�rige Text.";
		try {
			JosefsSekretaerin sekr = new JosefsSekretaerin(testtext,
					new DeutscheSprache());
			List<Absatz> absaetze = sekr.getDokument().getAbsaetze();
			assertEquals(absaetze.get(0).getStart(), 0);
			assertEquals(
					absaetze.get(0).getEnde(),
					"Das ist ein Test.\n".length());
			assertEquals(absaetze.get(1).getStart(),
					"Das ist ein Test.\n".length());
			assertEquals(
					absaetze.get(1).getEnde() - absaetze.get(1).getStart(),
					"Und das der dazugeh�rige Text.".length());
		} catch (Exception e) {
			fail("Exception found");
		}
	}

}
