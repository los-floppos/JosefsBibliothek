package hardcode.papierjosef.bibliothek.modell

class Dokument {
	def absaetze = [];
	def anzahlWortarten = [:];

	public Dokument(String text) {
		for (a in text.split("\\n")) {
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
