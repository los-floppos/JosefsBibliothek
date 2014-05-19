package hardcode.papierjosef.bibliothek.modell;

import hardcode.papierjosef.bibliothek.assistenz.Eigenschaft;

public class Wort extends TextElement {
	private String wort;
	
	public Wort(String token, Wortart wortart, long start, long ende){
		super(token, start);
		
		this.wort = token;
		put(Eigenschaft.WORTART, wortart.toString());
	}
	
	public String getWort() {
		return wort;
	}

	public String getWortart() {
		return get(Eigenschaft.WORTART);
	}
}
