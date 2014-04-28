package hardcode.papierjosef.bibliothek.modell

class Dokument {
	def absaetze = [];

	public Dokument(String text) {
		for (a in text.split("\\n")) {
			absaetze.add(new Absatz(a))
		}
	}
}
