package hardcode.papierjosef.bibliothek;

import static org.junit.Assert.*;
import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.documentloader.PlainTextDocumentLoader;
import hardcode.papierjosef.bibliothek.exception.BibliotheksZwischenfall;
import hardcode.papierjosef.bibliothek.regel.LangeSaetzeRegel;
import hardcode.papierjosef.bibliothek.regel.Regel;
import hardcode.papierjosef.bibliothek.regel.RegelKlassenDateiLader;
import hardcode.papierjosef.bibliothek.regel.RegelRahmenWerk;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.annotation.TextElementProperty;

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
		Document document = sek.getDokument();
		assert document.getStart() == 0;
		assert document.getEnd() == 664;

		List<Paragraph> paragraphs = document.getChildElements();
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
			e.printStackTrace();
		}
		sek.getDokument().getText().equals(ptdl.getText());
	}
	
	@Test
	public void regelRahmenwerkTest() {
		Document document = sek.getDokument();
		
		RegelRahmenWerk rrw = new RegelRahmenWerk();
		Regel langerSatz = new LangeSaetzeRegel();
		try {
			rrw.regelHinzufuegen(langerSatz);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
		rrw.fuehreSatzRegelnAus(document);	
		
		int nrOfLongSentences = 0;
		
		List<Paragraph> paragraphs = document.getChildElements();
		for(Paragraph paragraph : paragraphs) {
			List<Sentence> sentences = paragraph.getChildElements();
			for(Sentence sentence : sentences) {
				TextElementProperty tep = sentence.getProperty("LONG_SENTENCE");
				if(tep != null)
					nrOfLongSentences++;
			}
		}
		assertTrue(nrOfLongSentences == 1);
	}
	
	@Test
	public void ladeRegelKlasseTest() {
		Document document = sek.getDokument();
		
		RegelRahmenWerk rrw = new RegelRahmenWerk();
		RegelKlassenDateiLader lader = new RegelKlassenDateiLader();
		Regel regel = null;

		File testRegelFile = new File(System.getProperty("user.dir"));
		
		try {
			regel = lader.ladeKlasse(testRegelFile, "TestRegel");
		} catch (BibliotheksZwischenfall e1) {
			e1.printStackTrace();
		}
		
		try {
			rrw.regelHinzufuegen(regel);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
		rrw.fuehreSatzRegelnAus(document);	
		
		int nrOfLongSentences = 0;
		
		List<Paragraph> paragraphs = document.getChildElements();
		for(Paragraph paragraph : paragraphs) {
			List<Sentence> sentences = paragraph.getChildElements();
			for(Sentence sentence : sentences) {
				TextElementProperty tep = sentence.getProperty("LONG_SENTENCE");
				if(tep != null)
					nrOfLongSentences++;
			}
		}
		assertTrue(nrOfLongSentences > 1);
	}
}
