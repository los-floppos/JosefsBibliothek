package hardcode.papierjosef.bibliothek.loader.documentloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class TextDocumentLoader implements DocumentLoader {
	
	private String text;
	
	public void loadFile(File file) throws IOException {
		//TODO: no such file exception
		String text;
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        text = sb.toString();
	    } finally {
	        br.close();
	    }
	    
	    this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
