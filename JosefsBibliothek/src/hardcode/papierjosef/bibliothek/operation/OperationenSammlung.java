package hardcode.papierjosef.bibliothek.operation;

import java.util.LinkedList;
import java.util.List;

/**
 * Eine Operationensammlung kann mehrere Operationenketten und Operationen zusammenfassen.
 * Die Ausfuehrung einer Operationensammlung fuehrt alle enthaltenen Operationenketten und Operationen aus.<p>
 * Operationenketten werden in der uebergebenen Reihenfolge ausgefuehrt. Operationen werden in der gegebenen
 * Reihenfolge ausgefuehrt. <b>Dennoch muessen alle Operationenketten und Operationen unabhaengig voneinander sein!</b>
 * Es kann nicht garantiert werden, ob zuerst Operationen oder Operationenketten ausgefuehrt werden. <p>
 * Muessen Abhaengigkeiten modelliert werden, muss eine Operationenkette verwendet werden.
 */
public class OperationenSammlung {
	private List<OperationenKette> ketten;
	private List<String> operationenNamen;
	private String name;
	private String beschreibung;
	
	public OperationenSammlung(){
		ketten = new LinkedList<OperationenKette>();
		operationenNamen = new LinkedList<String>();
		name = null;
		beschreibung = null;
	}
	
	public void setOperationenSammlungName(String name) {
		this.name = name;
	}
	
	public void setOperationenSammlungBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public void operationenKetteHinzufuegen(OperationenKette kette) {
		ketten.add(kette);
	}
	
	public void operationHinzufuegen(String operationenName) {
		operationenNamen.add(operationenName);
	}
	
	public String getName() {
		return name;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	public List<String> getOperationen() {
		return java.util.Collections.unmodifiableList(operationenNamen);
	}
	
	public List<OperationenKette> getOperationenKetten() {
		return java.util.Collections.unmodifiableList(ketten);
	}

}
