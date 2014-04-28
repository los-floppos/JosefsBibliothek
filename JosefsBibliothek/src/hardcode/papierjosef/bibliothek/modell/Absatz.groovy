package hardcode.papierjosef.bibliothek.modell

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin

class Absatz {
	def saetze = [];
	boolean ignorieren;

	public Absatz(String text) {
		for(satz in OpenNlpSekretaerin.getInstanz().sentenceDetector.sentDetect(text)){
			saetze.add(new Satz(satz));
		}
	}
}
