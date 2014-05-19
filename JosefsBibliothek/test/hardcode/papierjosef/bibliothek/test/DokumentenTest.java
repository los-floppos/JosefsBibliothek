package hardcode.papierjosef.bibliothek.test;

import static org.junit.Assert.fail;
import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;

import java.util.List;

import org.junit.Test;

public class DokumentenTest {

	@Test
	public void absaetzeTrennenTest() {
		String testtext = "Das ist ein Test.\nUnd das der dazugehörige Text.";
		try {
			JosefsSekretaerin sekr = new JosefsSekretaerin(testtext,
					new DeutscheSprache());
			List<Absatz> absaetze=sekr.getDokument().getAbsaetze();
			//absaetze.get(0)
			//"Das ist ein Test.\n".length;
		} catch (Exception e) {
			fail("Exception found");
		}
	}

}
