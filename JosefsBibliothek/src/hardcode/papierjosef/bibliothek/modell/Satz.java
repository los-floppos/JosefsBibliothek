package hardcode.papierjosef.bibliothek.modell;

import hardcode.papierjosef.bibliothek.assistenz.OpenNlpSekretaerin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import opennlp.tools.util.Span;

public class Satz extends TextElement {

	private List<Wort> woerter;
	private Map<Wortart, Integer> anzahlWortarten;
	
	/**
	 * 
	 * @param text
	 * @param tempText
	 */
	public Satz(String text, String tempText, long start, long ende) {
		super(text, start);
		
		anzahlWortarten = new HashMap<Wortart, Integer>();
		woerter = new ArrayList<Wort>();
		
		
		//Zerstueckeln in Wortspannen/intervalle
		Span[] pos = OpenNlpSekretaerin.getInstanz().getTokenizer()
				.tokenizePos(tempText);
		List<String> tokens = new ArrayList<String>();
		
		//Rueckuebersetzen in eigentliche Woerter
		for (Span s : pos) {
			tokens.add((String) s.getCoveredText(tempText));
		}
		
		String[] tags = OpenNlpSekretaerin.getInstanz().getTagger()
				.tag(tokens.toArray(new String[0]));

		for (int i = 0; i < tokens.size(); i++) {
			String tag = tags[i];
			if (tag.equals("$,")) {
				tag = "XKOMMA";
			} else if (tag.equals("$.")) {
				tag = "XSATZENDE";
			} else if (tag.equals("$(")) {
				tag = "XSONST";
			}

			if (tokens.get(i).startsWith("AA")) { //FIXME
				tokens.set(i, (String) pos[i].getCoveredText(text)); 
			}

			//System.out.println(i + ": " + tokens.get(i) + ": " + tag);
			Wortart wortart = Wortart.valueOf(tag);

			Integer anzahl = anzahlWortarten.get(wortart);
			if (anzahl == null) {
				anzahlWortarten.put(wortart, 1);
			} else {
				anzahlWortarten.put(wortart, anzahl + 1);
			}

			woerter.add(new Wort(tokens.get(i), wortart, pos[i].getStart(), pos[i].getEnd()));

		}
	}
	
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
}
