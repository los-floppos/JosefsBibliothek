package hardcode.papierjosef.bibliothek.dokumentlader;

import java.io.File;
import java.io.IOException;

public interface IDokumentLader {

	public void ladeDokument(File file) throws IOException;
	public String getDokumentString();
	
}
