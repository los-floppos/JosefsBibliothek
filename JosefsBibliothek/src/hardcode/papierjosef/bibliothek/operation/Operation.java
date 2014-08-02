package hardcode.papierjosef.bibliothek.operation;

import java.lang.reflect.ParameterizedType;

import hardcode.papierjosef.model.document.TextElement;


@SuppressWarnings("rawtypes")
public abstract class Operation<T extends TextElement> {
	
	private Class<T> type;
	
	//TODO: RegelName und RegelBeschreibung einfuegen
	
	@SuppressWarnings("unchecked")
	public Operation() {
		//Determine type of T
		type = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	public Class<T> getType() {
		return type;
	}
	
	public abstract void fuehreAus(T t);
}
