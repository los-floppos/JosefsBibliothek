package hardcode.papierjosef.bibliothek.operation.statistik;

import hardcode.papierjosef.bibliothek.operation.Operation;
import hardcode.papierjosef.model.document.Document;

/**
 * Eine Statistik ist eine besondere Operation, die auf dem gesamtem Dokument operiert.
 * in der fuehreAus-Methode <b>muss</b> der Statistik-Report mit der Methode setReport gesetzt werden.
  */
public abstract class Statistik extends Operation<Document>{
	
	private StatistikReport report;
	
	public StatistikReport getReport() {
		return report;
	}
	
	public void setReport(StatistikReport report) {
		this.report = report;
	}
}
