package hardcode.papierjosef.bibliothek.modell;

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import opennlp.tools.util.Span;

public class Absatz {
	private List<Satz> saetze;
	private boolean ignorieren;
	private Map<Wortart, Integer> anzahlWortarten; // KOMMENTAR
	private Map<String, String> eigenschaften;
	
	//Absolute Position (relativ zum Dokument ;)
	private long start;
	private long ende;
	
	public Absatz(String text, long start, long ende) {
		String tempText = ersetzeKlammern(text); // FIXME
		saetze = new ArrayList<Satz>();
		anzahlWortarten = new HashMap<Wortart, Integer>();
		eigenschaften = new HashMap<String, String>();
		
		long laenge = start;
		
		for (Span s : OpenNlpSekretaerin.getInstanz().getSentenceDetector().sentPosDetect(tempText)) {

			Satz satz = new Satz((String) s.getCoveredText(text), (String) s.getCoveredText(tempText), laenge, laenge + text.length() + 1); //TODO funktioniert das so?
			saetze.add(satz);
			
			laenge += text.length() + 1;			
			
			for (Wortart w : satz.getAnzahlWortarten().keySet()) {
				Integer anzahl = anzahlWortarten.get(w);
				if (anzahl == null) {
					anzahlWortarten.put(w, satz.getAnzahlWortarten().get(w));
				} else {
					anzahlWortarten.put(w, anzahl
							+ satz.getAnzahlWortarten().get(w));
				}
			}
		}
	}
	
	public long getStart() {
		return start;
	}

	public long getEnde() {
		return ende;
	}

	public List<Satz> getSaetze() {
		return saetze;
	}

	public void setSaetze(List<Satz> saetze) {
		this.saetze = saetze;
	}

	public boolean isIgnorieren() {
		return ignorieren;
	}

	public void setIgnorieren(boolean ignorieren) {
		this.ignorieren = ignorieren;
	}

	public Map<Wortart, Integer> getAnzahlWortarten() {
		return anzahlWortarten;
	}

	public void setAnzahlWortarten(Map<Wortart, Integer> anzahlWortarten) {
		this.anzahlWortarten = anzahlWortarten;
	}

	public Map<String, String> getEigenschaften() {
		return eigenschaften;
	}

	public void setEigenschaften(Map<String, String> eigenschaften) {
		this.eigenschaften = eigenschaften;
	}

	public static String ersetzeKlammern(String text) {
		StringBuilder temp = new StringBuilder(text);

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '(') {
				while (text.charAt(i) != ')') {
					temp.replace(i, i + 1, "A");
					i++;
				}
				temp.replace(i, i + 1, "A");
			}
		}

		return temp.toString();
	}
}