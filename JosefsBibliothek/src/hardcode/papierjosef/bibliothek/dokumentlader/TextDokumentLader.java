package hardcode.papierjosef.bibliothek.dokumentlader;

import java.io.File;
import java.io.IOException;

public class TextDokumentLader extends DokumentLader {
	
	String text;
	
	@Override
	public void ladeDokument(File file) throws IOException {
		text = leseDatei(file);
	}

	@Override
	public String getDokumentString() {
		return text;
	}

}
