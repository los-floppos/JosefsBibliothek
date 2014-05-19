package hardcode.papierjosef.bibliothek.modell;

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import opennlp.tools.util.Span;

public class Satz {

	private List<Wort> woerter;
	private Map<Wortart, Integer> anzahlWortarten;
	private Map<String, String> eigenschaften;

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

	public Satz(String text, String tempText) {
		anzahlWortarten = new HashMap<Wortart, Integer>();
		eigenschaften = new HashMap<String, String>();
		woerter=new ArrayList<Wort>();
		Span[] pos = OpenNlpSekretaerin.getInstanz().getTokenizer()
				.tokenizePos(tempText);
		List<String> tokens = new ArrayList<String>();
		for (Span s : pos) {
			tokens.add((String) s.getCoveredText(tempText));
		}
		String[] tags = OpenNlpSekretaerin.getInstanz().getTagger()
				.tag(tokens.toArray(new String[0]));

		for (int i = 0; i < tokens.size() - 1; i++) {
			String tag = tags[i];
			if (tag.equals("$,")) {
				tag = "XKOMMA";
			} else if (tag.equals("$.")) {
				tag = "XSATZENDE";
			} else if (tag.equals("$(")) {
				tag = "XSONST";
			}

			if (tokens.get(i).startsWith("AA") && tokens.get(i).endsWith("AA")) { 	//FIXME
				tokens.set(i, (String) pos[i].getCoveredText(text));				//FIXME
			}																		//FIXME

			System.out.println(i + ": " + tokens.get(i) + ": " + tag);
			Wortart wortart = Wortart.valueOf(tag);

			Integer anzahl = anzahlWortarten.get(wortart);
			if (anzahl == null) {
				anzahlWortarten.put(wortart, 1);
			} else {
				anzahlWortarten.put(wortart, anzahl + 1);
			}

			woerter.add(new Wort(tokens.get(i), wortart));

		}
	}
}
