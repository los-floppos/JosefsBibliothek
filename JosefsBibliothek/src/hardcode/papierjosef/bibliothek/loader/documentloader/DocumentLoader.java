package hardcode.papierjosef.bibliothek.loader.documentloader;



import hardcode.papierjosef.bibliothek.loader.documentloader.loadeddocs.LoadedDocument;

import java.io.File;
import java.io.IOException;

public interface DocumentLoader {
	public void loadFile(File file) throws IOException;
	public String getText();
	public LoadedDocument getLoadedDocument();
}
