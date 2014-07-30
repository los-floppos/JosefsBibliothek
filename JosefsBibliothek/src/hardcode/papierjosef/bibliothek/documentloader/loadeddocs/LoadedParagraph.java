package hardcode.papierjosef.bibliothek.documentloader.loadeddocs;

import java.util.List;

public class LoadedParagraph {

private List<String> sentences;
	
	public void addSentence(String sentence) {
		sentences.add(sentence);
	}
	
	public List<String> getLoadedSentences() {
		return java.util.Collections.unmodifiableList(sentences);
	}
}
