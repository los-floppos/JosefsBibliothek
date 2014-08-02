package hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs;

import java.util.ArrayList;
import java.util.List;

public class LoadedDocument {

	private List<LoadedParagraph> paragraphs;

	public LoadedDocument() {
		paragraphs = new ArrayList<LoadedParagraph>();
	}

	public void addParagraph(LoadedParagraph p) {
		paragraphs.add(p);
	}

	public List<LoadedParagraph> getLoadedParagraphs() {
		return java.util.Collections.unmodifiableList(paragraphs);
	}

}
