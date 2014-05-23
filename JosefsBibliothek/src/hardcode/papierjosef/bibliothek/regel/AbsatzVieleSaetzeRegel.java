package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.bibliothek.modell.Absatz;

public class AbsatzVieleSaetzeRegel extends Regel<Absatz> {

	public AbsatzVieleSaetzeRegel(Absatz t) {
		super(t);
	}

	@Override
	public void fuehreAus() {
		if(getT().getSaetze().size() > 15) {
			getT().put("LangerAbsatz", "true");
		}
	}
}
