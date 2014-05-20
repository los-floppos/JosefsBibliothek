package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.bibliothek.modell.Satz;

public class LangeSaetzeRegel extends Regel<Satz> {
	public LangeSaetzeRegel(Satz t) {
		super(t);
	}

	@Override
	public void fuehreAus() {
		if (getT().getWoerter().size() > 20)
			getT().put("LANGER_SATZ", "true");
	}

}
