package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.bibliothek.modell.TextElement;

public abstract class Regel<T extends TextElement> {
	
	private T t;
	
	public Regel(T t) {
		this.t = t;
	}

	public TextElement getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public abstract void fuehreAus();

}
