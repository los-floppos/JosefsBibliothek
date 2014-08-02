package hardcode.papierjosef.bibliothek.operation;

import hardcode.papierjosef.bibliothek.operation.regel.Regel;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.Word;
import hardcode.papierjosef.model.document.annotation.TextElementProperty;

public class ZuVieleADVProSatz extends Regel<Sentence> {

	@Override
	public void fuehreAus(Sentence t) {
		String ADV = "ADV";
		int nrOfAdv = 0;
		for(Word w : t.getChildElements()) {
			if(w.getPartOfSpeech().getPartOfSpeechName().equals(ADV))
				nrOfAdv++;
		}
		if(nrOfAdv >= 5) {
			TextElementProperty property = new TextElementProperty("ZU_VIELE_ADV_PRO_SATZ", 
					"Ein guter Satz enthält weniger als 5 ADV.");
			t.addProperty(property);
		}
			
	}
}
