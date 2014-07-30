package hardcode.papierjosef.bibliothek.documentloader.loadeddocs;

import java.util.List;

public class LoadedDocument {
	
	private List<LoadedParagraph> paragraphs;
	
	public void addParagraph(LoadedParagraph p) {
		paragraphs.add(p);
	}
	
	public List<LoadedParagraph> getLoadedParagraphs() {
		return java.util.Collections.unmodifiableList(paragraphs);
	}
	

}
