package hardcode.papierjosef.bibliothek.modell;

import java.util.HashMap;
import java.util.Map;

import hardcode.papierjosef.bibliothek.assistenz.Eigenschaft;

public class Wort {
	private String wort;
	private Map<String, String> eigenschaften;
	
	
	
	public String getWort() {
		return wort;
	}

	public void setWort(String wort) {
		this.wort = wort;
	}

	public Map<String, String> getEigenschaften() {
		return eigenschaften;
	}

	public void setEigenschaften(Map<String, String> eigenschaften) {
		this.eigenschaften = eigenschaften;
	}

	public Wort(String token, Wortart wortart){
		eigenschaften = new HashMap<String, String>();
		
		this.wort = token;
		eigenschaften.put(Eigenschaft.WORTART, wortart.toString()); //FIXME: Wortart ist eine Enum ~!
	}
	
	public String getWortart() {
		return eigenschaften.get(Eigenschaft.WORTART);
	}
}
