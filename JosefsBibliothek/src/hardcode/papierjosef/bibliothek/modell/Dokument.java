package hardcode.papierjosef.bibliothek.modell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dokument extends TextElement {
	private List<Absatz> absaetze;
	private Map<Wortart, Integer> anzahlWortarten;

	public Dokument(String text) {
		super(text, 0);
		
		absaetze = new ArrayList<Absatz>();
		anzahlWortarten = new HashMap<Wortart, Integer>();

		long laenge = 0;

		for (String a : text.split("\\n")) {
			Absatz absatz = new Absatz(a, laenge);

			absaetze.add(absatz);

			for (Wortart w : absatz.getAnzahlWortarten().keySet()) {
				Integer anzahl = anzahlWortarten.get(w);
				if (anzahl == null) {
					anzahlWortarten.put(w, absatz.getAnzahlWortarten().get(w));
				} else {
					anzahlWortarten.put(w, anzahl
							+ absatz.getAnzahlWortarten().get(w));
				}
			}

			laenge += a.length() + 1;
		}
	}

	public List<Absatz> getAbsaetze() {
		return absaetze;
	}

	public void setAbsaetze(List<Absatz> absaetze) {
		this.absaetze = absaetze;
	}

	public Map<Wortart, Integer> getAnzahlWortarten() {
		return anzahlWortarten;
	}

	public void setAnzahlWortarten(Map<Wortart, Integer> anzahlWortarten) {
		this.anzahlWortarten = anzahlWortarten;
	}
}
