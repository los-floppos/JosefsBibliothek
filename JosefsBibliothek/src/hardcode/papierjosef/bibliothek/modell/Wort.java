package hardcode.papierjosef.bibliothek.modell;

import java.util.HashMap;
import java.util.Map;

import hardcode.papierjosef.bibliothek.assistenz.Eigenschaft;

public class Wort {
	String wort;
	
	private Map<String, String> eigenschaften;
	
	public Wort(String token, Wortart wortart){
		eigenschaften = new HashMap<String, String>();
		
		this.wort = token;
		eigenschaften.put(Eigenschaft.WORTART, wortart.toString()); //FIXME: Wortart ist eine Enum ~!
	}
	
	public String getWortart() {
		return eigenschaften.get(Eigenschaft.WORTART);
	}
}
