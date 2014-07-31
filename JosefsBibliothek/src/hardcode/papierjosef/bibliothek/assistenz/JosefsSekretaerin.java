package hardcode.papierjosef.bibliothek.assistenz;

import hardcode.papierjosef.bibliothek.documentloader.DocumentLoader;
import hardcode.papierjosef.bibliothek.documentloader.PlainTextDocumentLoader;
import hardcode.papierjosef.bibliothek.documentloader.loadeddocs.LoadedDocument;
import hardcode.papierjosef.bibliothek.documentloader.loadeddocs.LoadedParagraph;
import hardcode.papierjosef.bibliothek.sprachen.Sprache;
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

	public Document getDokument() {
		return dokument;
	}

	public JosefsSekretaerin(File programmpfad, File datei, Sprache sprache)
			throws Exception, IOException {
		OpenNlpSekretaerin.setInstanz(new OpenNlpSekretaerin(programmpfad, sprache));
		DocumentLoader loader = new PlainTextDocumentLoader();
		loader.loadFile(datei);
		dokument = foo(loader.getLoadedDocument());
	}

	private Document foo(LoadedDocument bar) throws HumbugException {
		OpenNlpSekretaerin sekretaerin = OpenNlpSekretaerin.getInstanz();
		int i = 0;
		List<Paragraph> paragraphs = new ArrayList<Paragraph>();
		for (LoadedParagraph p : bar.getLoadedParagraphs()) {
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

	public void setDokument(Document dokument) {
		this.dokument = dokument;
	}

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
