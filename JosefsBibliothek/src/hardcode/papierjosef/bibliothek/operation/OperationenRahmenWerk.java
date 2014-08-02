package hardcode.papierjosef.bibliothek.operation;

import java.io.File;
import java.util.List;

import hardcode.papierjosef.bibliothek.exception.BibliotheksZwischenfall;
import hardcode.papierjosef.bibliothek.loader.LadeKlasse;
import hardcode.papierjosef.bibliothek.sprachen.Language;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.Word;

/**
 * Fuehrt Operationen, OperationenKetten und OperationenSammlungen auf einem Dokument aus.
 * Das Dokument wird mit den Eigenschaften der Operationen angereichert.<p>
 * Es sollte eine Kopie des Original-Dokument uebergeben werden.
 */
public class OperationenRahmenWerk {
	
	private Document document;
	private Language sprache;
	
	/**
	 * Legt ein neues Rahmenwerk fuer ein Dokument an.
	 * @param document Document: Das auf dem zu operierende Dokument
	 */
	public OperationenRahmenWerk(Document document, Language sprache) {
		this.document = document;
		this.sprache = sprache;
	}
	
	/**
	 * Gibt das nach Ausfuehrung der Operationen um Eigenschaften angereicherte Dokument zurueck.
	 * @return Document
	 */
	public Document getDocument() {
		return document;
	}
	
	/**
	 * Fuehr eine Operation aus, die dynamisch aus einer Klassendatei geladen wird.
	 * @param operationenName String: Name der dynamisch zu ladenden Operation
	 * @throws BibliotheksZwischenfall 
	 */
	public void fuehreOperationAus(String operationenName) throws BibliotheksZwischenfall {
		File pfad = new File("sprachen" + File.separator + sprache.getLanguage() + File.separator + "regeln"); //FIXME???
		
		LadeKlasse<Operation> operationenKlassenLader = new LadeKlasse<>();
		Operation operation = operationenKlassenLader.ladeKlasse(pfad, operationenName);
		fuehreOperationAus(operation);
	}
	
	/**
	 * Fuehrt eine Operation aus
	 * @param operation Operation
	 * @throws BibliotheksZwischenfall
	 */
	public void fuehreOperationAus(Operation operation) throws BibliotheksZwischenfall {
		//Bestimme auf welchem Element des DocumentModel die Regel operiert
		if (operation.getType().equals(Document.class)) {
			fuehreDokumentOperationAus(operation);
		} else if (operation.getType().equals(Paragraph.class)) {
			fuehreAbsatzOperationAus(operation);
		} else if (operation.getType().equals(Sentence.class)) {
			fuehreSatzOperationAus(operation);
		} else if (operation.getType().equals(Word.class)) {
			fuehreWortOperationAus(operation);
		} else {
			throw new BibliotheksZwischenfall("invalid_rule_class_type");
		}
	}
	
	/**
	 * Fuehrt alle Operationen der OperationenKette in der vorgegebenen Reihenfolge aus.
	 * @param kette OperationenKette
	 * @throws BibliotheksZwischenfall 
	 */
	public void fuehreOperationenKetteAus(OperationenKette kette) throws BibliotheksZwischenfall {
		for(String operationenName : kette.getOperationenKette()) {
			fuehreOperationAus(operationenName);
		}
	}
	
	/**
	 * Fuehrt alle Operationen und OperationenKetten der Sammlung aus.
	 * @param sammlung OperationenSammlung
	 * @throws BibliotheksZwischenfall 
	 */
	public void fuehreOperationenSammlungAus(OperationenSammlung sammlung) throws BibliotheksZwischenfall {
		for(String operationenName : sammlung.getOperationen()) {
			fuehreOperationAus(operationenName);
		}
		
		for(OperationenKette kette : sammlung.getOperationenKetten()) {
			fuehreOperationenKetteAus(kette);
		}
	}
	

	/**
	 * Fuehrt eine Operation auf dem gesamtem Dokument aus.
	 * @param operation
	 */
	private void fuehreDokumentOperationAus(Operation operation) {
		operation.fuehreAus(document);
	}
	
	/**
	 * Fuehrt dieselbe Operation der Reihe nach auf allen Absaetzen aus.
	 * @param operation
	 */
	private void fuehreAbsatzOperationAus(Operation operation) {
		for(Paragraph paragraph : document.getChildElements()) {
			operation.fuehreAus(paragraph);
		}
	}
	
	/**
	 * Fuehrt dieselbe Operation der Reihe nach auf allen Saetzen aus.
	 * @param operation
	 */
	private void fuehreSatzOperationAus(Operation operation) {
		for(Paragraph paragraph : document.getChildElements()) {
			List<Sentence> sentences = paragraph.getChildElements();
			for(Sentence sentence : sentences) {
				operation.fuehreAus(sentence);
			}
		}
	}
	
	/**
	 * fuehrt dieselbe Operation der Reihe nach auf allen Woertern aus.
	 * @param operation
	 */
	private void fuehreWortOperationAus(Operation operation) {
		for(Paragraph paragraph : document.getChildElements()) {
			List<Sentence> sentences = paragraph.getChildElements();
			for(Sentence sentence : sentences) {
				for(Word word : sentence.getChildElements()) {
					operation.fuehreAus(word);
				}
			}
		}
	}
}
