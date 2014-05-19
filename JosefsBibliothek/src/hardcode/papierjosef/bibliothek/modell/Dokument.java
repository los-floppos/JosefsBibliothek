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

		String[] abs = text.split("\\n");
		for (int i = 0; i < abs.length; i++) {
			Absatz absatz = new Absatz(abs[i], laenge, laenge
					+ ((i == abs.length - 1) ? abs[i].length()
							: (abs[i].length() + 1)));

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

			laenge += abs[i].length() + 1;
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
