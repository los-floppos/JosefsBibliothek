package hardcode.papierjosef.bibliothek.operation;

import java.util.LinkedList;
import java.util.List;

/**
 * Eine Operationenkette enthaelt die Namen mehrer Operationen, die aus aus Klassendateien
 * geladen und in der angegebenen Reihenfolge nacheinander ausgefuehrt werden. 
 *
 */
public class OperationenKette {
	
	private String operationenKetteName;
	private String operationenKetteBeschreibung;
	
	private List<String> namen;
	
	public OperationenKette() {
		namen = new LinkedList<String>();
		operationenKetteName = null;
		operationenKetteBeschreibung = null;
	}
	
	public void operationHinzufuegen(String name) {
		namen.add(name);
	}
	
	public void setOperationenKetteName(String name) {
		this.operationenKetteName = name;
	}
	
	public void setOperationenKetteBeschreibung(String beschreibung) {
		this.operationenKetteBeschreibung = beschreibung;
	}
	
	public List<String> getOperationenKette() {
		return java.util.Collections.unmodifiableList(namen);
	}
	
	public String getName() {
		return operationenKetteName;
	}
	
	public String getBeschreibung() {
		return operationenKetteBeschreibung;
	}
}
