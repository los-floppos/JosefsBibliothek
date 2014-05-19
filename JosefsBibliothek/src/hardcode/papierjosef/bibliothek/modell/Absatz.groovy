package hardcode.papierjosef.bibliothek.modell

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin

class Absatz {
	def saetze = []; 
	boolean ignorieren;

	def anzahlWortarten = [:];

	public Absatz(String text) {
		for(s in OpenNlpSekretaerin.getInstanz().sentenceDetector.sentDetect(text)){
			Satz satz=new Satz(s);
			saetze.add(satz);
			
			for(Wortart w: satz.anzahlWortarten.keySet()){
				Integer anzahl =  anzahlWortarten.getAt(w);
				if (anzahl == null) {
					anzahlWortarten.put(w, satz.anzahlWortarten.get(w))
				} else {
					anzahlWortarten.put(w, anzahl + satz.anzahlWortarten.get(w));
				}
			}
		}
	}
}
