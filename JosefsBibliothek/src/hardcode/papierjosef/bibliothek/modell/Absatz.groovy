package hardcode.papierjosef.bibliothek.modell

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin

class Absatz {
	def saetze = [];
	boolean ignorieren;
	
	def anzahlWortarten = [Wortart:Integer];

	public Absatz(String text) {
		for(s in OpenNlpSekretaerin.getInstanz().sentenceDetector.sentDetect(text)){
			Satz satz=new Satz(s);
			saetze.add(satz);
			this.anzahlWortarten.add satz.anzahlWortarten
		}
	}
}
