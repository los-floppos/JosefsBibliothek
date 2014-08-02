package hardcode.papierjosef.bibliothek.assistenz;

import hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs.LoadedDocument;
import hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs.LoadedParagraph;
import hardcode.papierjosef.bibliothek.loader.documentloader.DocumentLoader;
import hardcode.papierjosef.bibliothek.loader.documentloader.PlainTextDocumentLoader;
import hardcode.papierjosef.bibliothek.sprachen.Language;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.HumbugException;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.PartOfSpeech;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.Word;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JosefsSekretaerin {
	private Document dokument;
	private Language sprache;

	/**
	 * @return Document
	 */
	public Document getDokument() {
		//TODO: KOPIE zurueckgeben
		return dokument;
	}
	
//	public void setDokument(Document dokument) {
//		this.dokument = dokument;
//	}
	
	/**
	 * Gibt die Sprache der Sekretaerin zurueck
	 * @return Language
	 */
	public Language getSprache() {
		return sprache;
	}

	/**
	 * Erstellt eine neue Sekretaerin. Laedt eine Datei. Laedt das NLP-Model fuer die gegebene Sprache
	 *  
	 * @param datei File: Zu ueberpruefende Datei
	 * @param sprache Sprache: Eine Instanz der Sprache der zu ueperpruefenden Datei
	 * @throws Exception
	 * @throws IOException
	 */
	public JosefsSekretaerin(File datei, Language sprache) throws Exception, IOException {
		this.sprache = sprache;
		
		OpenNlpSekretaerin.setInstanz(new OpenNlpSekretaerin(sprache));
		DocumentLoader loader = new PlainTextDocumentLoader();
		loader.loadFile(datei);
		dokument = bestimmeWortarten(loader.getLoadedDocument());
	}

	/**
	 * 
	 * @param loadedDocument
	 * @return
	 * @throws HumbugException
	 */
	private Document bestimmeWortarten(LoadedDocument loadedDocument) throws HumbugException {
		OpenNlpSekretaerin sekretaerin = OpenNlpSekretaerin.getInstanz();
		int i = 0;
		List<Paragraph> paragraphs = new ArrayList<Paragraph>();
		for (LoadedParagraph p : loadedDocument.getLoadedParagraphs()) {
			List<Sentence> sents = new ArrayList<Sentence>();
			for (String sentence : p.getLoadedSentences()) {
				String tokens[] = sekretaerin.getTokenizer().tokenize(sentence);
				String tags[] = sekretaerin.getTagger().tag(tokens);
				List<Word> words = new ArrayList<Word>();
				for (int j = 0; j < tokens.length; j++) {
					words.add(new Word(Arrays
							.asList(new String[] { tokens[j] }), i, i
							+ tokens[j].length(), new PartOfSpeech(tags[j])));
					i += tokens[j].length();
				}
				sents.add(new Sentence(words, words.get(0).getStart(), words
						.get(0).getStart() + sentence.length()));

			}
			paragraphs.add(new Paragraph(sents, sents.get(0).getStart(), sents
					.get(sents.size() - 1).getEnd()));
		}
		return new Document(paragraphs, 0, paragraphs
				.get(paragraphs.size() - 1).getEnd());
	}

	// TODO
	// public GrundlegendeStatistik errechneGrundlegendeStatistik() { //TODO
	// GrundlegendeStatistik stat = new GrundlegendeStatistik();
	// stat.errechne(dokument);
	// return stat;
	// }
	//
	// public EigenschaftsStatistik errechneEigenschaftsStatistik() { //TODO
	// EigenschaftsStatistik stat = new EigenschaftsStatistik();
	// stat.errechne(dokument);
	// return stat;
	// }

	

	// public String ausgebeDokument() {
	// String str = ""; // TODO
	//
	// for (Paragraph p : dokument.getChildElements()) {
	// for (Sentence sentence : p.getChildElements()) {
	// str += "{";
	// for (Word word : sentence.getWoerter()) {
	// str += wort.getWort() + "/" + wort.getWortart() + " ";
	// }
	// str += "}, ";
	// }
	// str += "\n";
	// }
	// return str;
	// }
}
