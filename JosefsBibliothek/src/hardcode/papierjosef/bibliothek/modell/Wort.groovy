package hardcode.papierjosef.bibliothek.modell

class Wort {
	String wort;
	
	def eigenschaften = [:];
	
	Wortart wortart;
	
	public Wort(String token, Wortart wortart){
		this.wort = token;
		this.wortart = wortart;
	}
}
