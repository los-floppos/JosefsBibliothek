package hardcode.papierjosef.bibliothek.modell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin;

public class Satz {
	
	private List<Wort> woerter;
	private Map<Wortart,Integer> anzahlWortarten;
	private Map<String,String> eigenschaften;

	public List<Wort> getWoerter() {
		return woerter;
	}

	public void setWoerter(List<Wort> woerter) {
		this.woerter = woerter;
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

	public Satz (String text) {
		anzahlWortarten=new HashMap<Wortart, Integer>();
		eigenschaften=new HashMap<String,String>();
		String[] tokens = OpenNlpSekretaerin.getInstanz().getTokenizer().tokenize(text);
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
