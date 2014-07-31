package hardcode.papierjosef.bibliothek;

import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.Sentence;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class SekretaerinnenAssessmentCenter {

	@Test
	public void testeAnalyseFaehigkeiten() throws IOException, Exception {
		JosefsSekretaerin sek = new JosefsSekretaerin(
				System.getProperty("user.dir") + "/",
				System.getProperty("user.dir") + "/test-document-plain.txt",
				new DeutscheSprache());
		Document d = sek.getDokument();
		assert d.getStart() == 0;
		assert d.getEnd() == 664;

		List<Paragraph> paragraphs = d.getChildElements();
		assert paragraphs.size() == 1;

		List<Sentence> sents = paragraphs.get(0).getChildElements();
		assert sents.size() == 1;
	}
}
