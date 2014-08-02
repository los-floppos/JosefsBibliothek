package hardcode.papierjosef.bibliothek.loader.documentloader;

import hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs.LoadedDocument;
import hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs.LoadedParagraph;

public class PlainTextDocumentLoader extends TextDocumentLoader {
	@Override
	public LoadedDocument getLoadedDocument() {
		LoadedDocument document = new LoadedDocument();
		
		String[] paragraphs = getText().split("\\n");
		
		for (int i = 0; i < paragraphs.length; i++) {
			String[] sentences = paragraphs[i].split("\\.");
			
			LoadedParagraph p = new LoadedParagraph(); 
			for(int j = 0; j < sentences.length; j++) {
				String sentence = sentences[j];
				p.addSentence(sentence);
			}
			
			document.addParagraph(p);
		}
		return document;
	}
}
