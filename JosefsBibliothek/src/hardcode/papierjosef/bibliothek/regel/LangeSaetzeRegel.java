package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.model.document.Sentence;

public class LangeSaetzeRegel extends Regel<Sentence> {
	public LangeSaetzeRegel(Sentence t) {
		super(t);
	}

	@Override
	public void fuehreAus() {
		//TODO
//		if (getT().getWoerter().size() > 20)
//			getT().put("LANGER_SATZ", "true");
	}

}
