package hardcode.papierjosef.bibliothek.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.modell.Wort;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import opennlp.tools.util.InvalidFormatException;

import org.junit.Test;

public class AbsatzTest {

	File programmPfad = new File(System.getProperty("user.dir"));
	
	@Test
	public void ersetzungsTest() {
		assertEquals("Test AAAAAAAAAAAA, bla",
				Absatz.ersetzeKlammern("Test (Beck, 1945), bla"));

		assertEquals(Absatz.ersetzeKlammern("(Beck, 1945)").length(),
				"(Beck, 1945)".length());
	}

	@Test
	public void tokensTest() {
		String text = "Das ist ein (schiweriger Test).";
		JosefsSekretaerin sekr;
		try {
			sekr = new JosefsSekretaerin(programmPfad, text, new DeutscheSprache());
			for (Wort w : sekr.getDokument().getAbsaetze().get(0).getSaetze()
					.get(0).getWoerter()) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
