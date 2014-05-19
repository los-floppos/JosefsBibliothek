package hardcode.papierjosef.bibliothek.modell;

import java.util.HashMap;
import java.util.Map;

import hardcode.papierjosef.bibliothek.assistenz.Eigenschaft;

public class Wort {
	private String wort;
	private Map<String, String> eigenschaften;
	private long start;
	private long ende;
	
	public Wort(String token, Wortart wortart, long start, long ende){
		eigenschaften = new HashMap<String, String>();
		this.start = start;
		this.ende = ende;
		
		this.wort = token;
		eigenschaften.put(Eigenschaft.WORTART, wortart.toString()); //FIXME: Wortart ist eine Enum ~!
	}
	
	public String getWort() {
		return wort;
	}

	public Map<String, String> getEigenschaften() {
		return eigenschaften;
	}

	public void addEigenschaft(String schluessel, String wert) {
		eigenschaften.put(schluessel, wert);
	}
	
	public String getWortart() {
		return eigenschaften.get(Eigenschaft.WORTART);
	}

	public long getStart() {
		return start;
	}

	public long getEnde() {
		return ende;
	}
	
	
}
