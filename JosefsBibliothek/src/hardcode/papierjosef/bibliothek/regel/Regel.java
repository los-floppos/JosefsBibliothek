package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.model.document.TextElement;


public abstract class Regel<T extends TextElement> {
	
	private T t;
	
	public Regel(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public abstract void fuehreAus();

}
