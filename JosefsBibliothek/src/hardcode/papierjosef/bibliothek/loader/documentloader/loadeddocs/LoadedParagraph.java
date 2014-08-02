package hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs;

import java.util.ArrayList;
import java.util.List;

public class LoadedParagraph {

	private List<String> sentences;

	public LoadedParagraph() {
		sentences = new ArrayList<String>();
	}

	public void addSentence(String sentence) {
		sentences.add(sentence);
	}

	public List<String> getLoadedSentences() {
		return java.util.Collections.unmodifiableList(sentences);
	}
}
