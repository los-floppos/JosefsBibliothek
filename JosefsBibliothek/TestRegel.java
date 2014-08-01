import hardcode.papierjosef.bibliothek.regel.Regel;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.annotation.TextElementProperty;

public class TestRegel extends Regel<Sentence> {
	//@Override
	public void fuehreAus(Sentence t) {
		int maxLength = 5;
		if(t.size() > maxLength) {
			TextElementProperty tep = new TextElementProperty("LONG_SENTENCE", "Langer Satz");
			t.addProperty(tep);
		}
	}
}
