package hardcode.papierjosef.bibliothek.modell;

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Satz {
	
	List<Wort> woerter;
	
	Map<Wortart,Integer> anzahlWortarten;
	
	Map<String,String> eigenschaften;

	public Satz (String text) {
		anzahlWortarten=new HashMap<Wortart, Integer>();
		eigenschaften=new HashMap<String,String>();
		String[] tokens=OpenNlpSekretaerin.getInstanz().getTokenizer().tokenize(text);
		String[] tags = OpenNlpSekretaerin.getInstanz().getTagger().tag(tokens);

		for(int i=0;i<tokens.length-1;i++){
			String tag = tags[i];
			if(tag.equals("$,")) {
				tag = "XKOMMA";
			} else if (tag.equals("$.")) {
				tag = "XSATZENDE";
			} else if (tag.equals("$(")) {
				tag = "XSONST";
			}
			
			System.out.println(i + ": " + tokens[i] + ": " + tag);
			Wortart wortart = Wortart.valueOf(tag);
			
			Integer anzahl =  anzahlWortarten.get(wortart);
			if (anzahl == null) {
				anzahlWortarten.put(wortart, 1);
			} else {
				anzahlWortarten.put(wortart, anzahl + 1);
			}
			
			woerter.add(new Wort(tokens[i], wortart));
			
		}
	}
}
