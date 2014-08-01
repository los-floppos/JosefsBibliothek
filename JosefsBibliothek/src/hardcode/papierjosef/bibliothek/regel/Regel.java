package hardcode.papierjosef.bibliothek.regel;

import java.lang.reflect.ParameterizedType;

import hardcode.papierjosef.model.document.TextElement;


@SuppressWarnings("rawtypes")
public abstract class Regel<T extends TextElement> {
	
	private Class<T> type;
	
	@SuppressWarnings("unchecked")
	public Regel() {
		//Determine type of T
		type = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	public Class<T> getType() {
		return type;
	}
	
	public abstract void fuehreAus(T t);
}
