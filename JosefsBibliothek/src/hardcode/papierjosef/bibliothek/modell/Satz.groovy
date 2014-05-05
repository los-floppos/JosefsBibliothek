package hardcode.papierjosef.bibliothek.modell

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin

class Satz {
	
	def woerter = [];
	
	def anzahlWortarten = [Wortart:Integer];

	public Satz (String text) {
		String[] tokens=OpenNlpSekretaerin.getInstanz().tokenizer.tokenize(text);
		String[] tags = OpenNlpSekretaerin.getInstanz().tagger.tag(tokens);

		for(i in 0..tokens.length-1){
			String tag = tags[i];
			if(tag.equals('$,')) {
				tag = "XKOMMA";
			} else if (tag.equals('$.')) {
				tag = "XSATZENDE";
			} else if (tag.equals('$(')) {
				tag = "XSONST";
			}
			
			println(i + ": " + tokens[i] + ": " + tag);
			Wortart wortart = Wortart.valueOf(tag);
			
			Integer anzahl =  anzahlWortarten.getAt(wortart);
			if (anzahl == null) {
				anzahlWortarten.put(wortart, 1)
			} else {
				anzahlWortarten.put(wortart, anzahl + 1);
			}
			
			woerter.add(new Wort(tokens[i], wortart));
			
		}
	}
}
