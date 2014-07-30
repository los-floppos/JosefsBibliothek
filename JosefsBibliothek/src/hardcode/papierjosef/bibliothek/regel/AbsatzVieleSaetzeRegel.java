package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.model.document.Paragraph;

public class AbsatzVieleSaetzeRegel extends Regel<Paragraph> {

	public AbsatzVieleSaetzeRegel(Paragraph t) {
		super(t);
	}

	@Override
	public void fuehreAus() {
		//TODO
//		if(getT().getSaetze().size() > 15) {
//			getT().put("LangerAbsatz", "true");
//		}
	}
}
