package hardcode.papierjosef.bibliothek.modell;

import java.util.List;
import java.util.Map;

public class Dokument {
	List<Absatz> absaetze;
	Map<String, String> anzahlWortarten;

	public Dokument(String text) {
		for (String a : text.split("\\n")) {
			Absatz absatz = new Absatz(a);
			
			absaetze.add(absatz);
			
			for(Wortart w: absatz.anzahlWortarten.keySet()){
				Integer anzahl =  anzahlWortarten.getAt(w);
				if (anzahl == null) {
					anzahlWortarten.put(w, absatz.anzahlWortarten.get(w))
				} else {
					anzahlWortarten.put(w, anzahl + absatz.anzahlWortarten.get(w));
				}
			}
		}
	}
}
