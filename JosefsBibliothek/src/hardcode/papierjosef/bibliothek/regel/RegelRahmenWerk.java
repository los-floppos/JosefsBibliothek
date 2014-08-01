package hardcode.papierjosef.bibliothek.regel;

import java.util.LinkedList;
import java.util.List;

import hardcode.papierjosef.bibliothek.exception.BibliotheksZwischenfall;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.Word;

public class RegelRahmenWerk {
	
	private List<Regel<Document>> dokumentRegeln;
	private List<Regel<Paragraph>> absatzRegeln;
	private List<Regel<Sentence>> satzRegeln;
	private List<Regel<Word>> wortRegeln;
	
	public RegelRahmenWerk() {
		dokumentRegeln = new LinkedList<Regel<Document>>();
		absatzRegeln = new LinkedList<Regel<Paragraph>>();
		satzRegeln = new LinkedList<Regel<Sentence>>();
		wortRegeln = new LinkedList<Regel<Word>>();
	}
	
	public void regelHinzufuegen(Regel regel) throws BibliotheksZwischenfall {
		//Bestimme auf welchem Element des DocumentModel die Regel operiert
		if (regel.getType().equals(Document.class)) {
			dokumentRegeln.add(regel);
		} else if (regel.getType().equals(Paragraph.class)) {
			absatzRegeln.add(regel);
		} else if (regel.getType().equals(Sentence.class)) {
			satzRegeln.add(regel);
		} else if (regel.getType().equals(Word.class)) {
			wortRegeln.add(regel);
		} else {
			throw new BibliotheksZwischenfall("invalid_rule_class_type");
		}
	}
	
	public void fuehreDokumentRegelnAus(Document doc) {
		//TODO
	}
	
	public void fuehreAbsatzRegelnAus(Document doc) {
		//TODO
	}
	
	public void fuehreSatzRegelnAus(Document doc) {
		List<Paragraph> paragraphs = doc.getChildElements();
		for(Paragraph paragraph : paragraphs) {
			List<Sentence> sentences = paragraph.getChildElements();
			for(Sentence sentence : sentences) {
				
				for(Regel<Sentence> regel : satzRegeln) {
					regel.fuehreAus(sentence);
				}
				
			}
		}
	}
	
	public void fuehreWortRegelnAus(Document doc) {
		//TODO
	}

}
