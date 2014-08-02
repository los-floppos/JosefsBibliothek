package hardcode.papierjosef.bibliothek;

import static org.junit.Assert.*;
import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.exception.BibliotheksZwischenfall;
import hardcode.papierjosef.bibliothek.loader.LadeKlasse;
import hardcode.papierjosef.bibliothek.loader.XmlSerializer;
import hardcode.papierjosef.bibliothek.loader.documentloader.PlainTextDocumentLoader;
import hardcode.papierjosef.bibliothek.operation.LangeSaetzeRegel;
import hardcode.papierjosef.bibliothek.operation.Operation;
import hardcode.papierjosef.bibliothek.operation.OperationenKette;
import hardcode.papierjosef.bibliothek.operation.OperationenRahmenWerk;
import hardcode.papierjosef.bibliothek.operation.OperationenSammlung;
import hardcode.papierjosef.bibliothek.operation.ZuVieleADVProSatz;
import hardcode.papierjosef.bibliothek.sprachen.Deutsch;
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

	JosefsSekretaerin sekPlain;
	File fPlain;
	
	JosefsSekretaerin sekGelaber;
	File fGelaber;

	@Before
	public void init() throws IOException, Exception {
		fPlain = new File(System.getProperty("user.dir")
				+ "/test-document-plain.txt");
		sekPlain = new JosefsSekretaerin(fPlain, new Deutsch());
		
		fGelaber = new File("test-document-gelaber.txt");
		sekGelaber = new JosefsSekretaerin(fGelaber, new Deutsch());
	}

	@Test
	public void testeAnalyseFaehigkeiten() {
		Document document = sekPlain.getDokument();
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
			ptdl.loadFile(fPlain);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sekPlain.getDokument().getText().equals(ptdl.getText());
	}
	
	@Test
	public void regelRahmenwerkTest() {
		Document document = sekPlain.getDokument();
		
		OperationenRahmenWerk rrw = new OperationenRahmenWerk(document, sekPlain.getSprache());
		Operation langerSatz = new LangeSaetzeRegel();
		try {
			rrw.fuehreOperationAus(langerSatz);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
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
		Document document = sekPlain.getDokument();
		
		OperationenRahmenWerk rrw = new OperationenRahmenWerk(document, sekPlain.getSprache());
		
		LadeKlasse<Operation> lader = new LadeKlasse<Operation>();
		Operation regel = null;

		File testRegelFile = new File(System.getProperty("user.dir"));
		
		System.out.println(testRegelFile);
		
		try {
			regel = lader.ladeKlasse(testRegelFile, "TestRegel");
		} catch (BibliotheksZwischenfall e1) {
			e1.printStackTrace();
		}
		
		try {
			rrw.fuehreOperationAus(regel);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
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
	
	@Test
	public void wenigerAls5AdvProSatz() {
		Document d = sekGelaber.getDokument();
		
		OperationenRahmenWerk rrw = new OperationenRahmenWerk(d, sekGelaber.getSprache());
		Operation adv = new ZuVieleADVProSatz();
		try {
			rrw.fuehreOperationAus(adv);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
		TextElementProperty tep = d.getChildElements().get(0).getChildElements().get(0).getProperty("ZU_VIELE_ADV_PRO_SATZ");
		assertNotNull(tep);
	}
	
	@Test
	public void fuehreRegelSammlungAus() {
		OperationenKette kette = new OperationenKette();
		kette.operationHinzufuegen("TestRegel");
		OperationenSammlung sammlung = new OperationenSammlung();
		sammlung.operationenKetteHinzufuegen(kette);
		
		Document document = sekPlain.getDokument();
		OperationenRahmenWerk rrw = new OperationenRahmenWerk(document, sekPlain.getSprache());
		try {
			rrw.fuehreOperationenSammlungAus(sammlung);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
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
	
	@Test
	public void fuehreSerialisierteDeserialisierteRegelSammlungAus() {
		OperationenKette kette = new OperationenKette();
		kette.operationHinzufuegen("TestRegel");
		OperationenSammlung sammlung = new OperationenSammlung();
		sammlung.operationenKetteHinzufuegen(kette);
		
		File file = new File(System.getProperty("java.io.tmpdir") + File.separator + "fuehreSerialisierteDeserialisierteRegelSammlungAus.test.xml");
		XmlSerializer<OperationenSammlung> serializer = new XmlSerializer<>();
		try {
			serializer.serializeToFile(sammlung, file);
		} catch (BibliotheksZwischenfall e1) {
			e1.printStackTrace();
		}
		
		XmlSerializer<OperationenSammlung> deserializer = new XmlSerializer<>();
		OperationenSammlung deserializedSammlung = null;
		try {
			deserializedSammlung = deserializer.deserialize(file);
		} catch (BibliotheksZwischenfall e1) {
			e1.printStackTrace();
		}
		
		Document document = sekPlain.getDokument();
		OperationenRahmenWerk rrw = new OperationenRahmenWerk(document, sekPlain.getSprache());
		try {
			rrw.fuehreOperationenSammlungAus(deserializedSammlung);
		} catch (BibliotheksZwischenfall e) {
			e.printStackTrace();
			System.out.println(e.getCode());
		}
		
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
