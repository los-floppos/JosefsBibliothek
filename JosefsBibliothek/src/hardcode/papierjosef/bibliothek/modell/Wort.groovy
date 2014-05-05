package hardcode.papierjosef.bibliothek.modell

class Wort {
	String wort;
	Wortart wortart;
	
	public Wort(String token, Wortart wortart){
		this.wort = token;
		this.wortart = wortart;
	}
}
