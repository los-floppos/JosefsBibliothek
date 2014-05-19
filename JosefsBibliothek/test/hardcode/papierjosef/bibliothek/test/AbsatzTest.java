package hardcode.papierjosef.bibliothek.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.modell.Wort;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import opennlp.tools.util.InvalidFormatException;

import org.junit.Test;

public class AbsatzTest {

	@Test
	public void ersetzungsTest() {
		assertEquals("Test AAAAAAAAAAAA, bla",
				Absatz.ersetzeKlammern("Test (Beck, 1945), bla"));

		assertEquals(Absatz.ersetzeKlammern("(Beck, 1945)").length(),
				"(Beck, 1945)".length());
	}

	@Test
	public void tokensTest() {
		String text = "Das ist ein (Test).";
		JosefsSekretaerin sekr;
		try {
			sekr = new JosefsSekretaerin(text, new DeutscheSprache());
			for (Wort w : sekr.getDokument().getAbsaetze().get(0).getSaetze()
					.get(0).getWoerter()) {
				System.out.println(w.getWort() + ":" + w.getWortart());
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
