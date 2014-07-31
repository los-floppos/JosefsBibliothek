package hardcode.papierjosef.bibliothek;

import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.documentloader.PlainTextDocumentLoader;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.Sentence;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SekretaerinnenAssessmentCenter {

	JosefsSekretaerin sek;
	File f;

	@Before
	public void init() throws IOException, Exception {
		f = new File(System.getProperty("user.dir")
				+ "/test-document-plain.txt");
		sek = new JosefsSekretaerin(new File(System.getProperty("user.dir")
				+ "/"), f, new DeutscheSprache());
	}

	@Test
	public void testeAnalyseFaehigkeiten() {
		Document d = sek.getDokument();
		assert d.getStart() == 0;
		assert d.getEnd() == 664;

		List<Paragraph> paragraphs = d.getChildElements();
		assert paragraphs.size() == 1;

		List<Sentence> sents = paragraphs.get(0).getChildElements();
		assert sents.size() == 1;
	}

	@Test
	public void testeZurueckuebertragen(){
		PlainTextDocumentLoader ptdl = new PlainTextDocumentLoader();
		try {
			ptdl.loadFile(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sek.getDokument().getText().equals(ptdl.getText());
	}
}
