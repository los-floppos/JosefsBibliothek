package hardcode.papierjosef.bibliothek.modell

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin

class Satz {
	def woerter = [];

	public Satz (String text) {
		String[] tokens=OpenNlpSekretaerin.getInstanz().tokenizer.tokenize(text);
		String[] tags = OpenNlpSekretaerin.getInstanz().tagger.tag(tokens);

		for(i in 0..tokens.length-1){
			woerter.add(new Wort(tokens[i],tags[i]));
		}
	}
}
