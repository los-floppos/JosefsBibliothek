package hardcode.papierjosef.bibliothek.regel;

import hardcode.papierjosef.bibliothek.exception.BibliotheksZwischenfall;
import hardcode.papierjosef.model.document.TextElement;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Laedt eine Regel aus einer class-Datei ein.
 */
public class RegelKlassenDateiLader{
	/**
	 * Laedt eine Regel aus einer class-Datei
	 * @param pfad File: Pfad zum Ordner, in dem sich die Regel-Klassendatei befindet
	 * @param regelKlassenName String: Name der Regel-Klassendatei, ohne .class.
	 * Also z.B. nur "TestRegel".
	 * @return Regel: Die geladene Regel
	 * @throws BibliotheksZwischenfall
	 */
	public static Regel ladeKlasse(File pfad, String regelKlassenName) throws BibliotheksZwischenfall  {
		Regel regel = null;
		try{	
			URL url = pfad.toURI().toURL();		
			URLClassLoader loader = new URLClassLoader(new URL[]{url}, Regel.class.getClassLoader());
			Class c = loader.loadClass(regelKlassenName);
			regel = (Regel) c.newInstance();
			loader.close();
		} catch (MalformedURLException e) {
			throw new BibliotheksZwischenfall("MalformedURLException");
		} catch (ClassNotFoundException e) {
			throw new BibliotheksZwischenfall("ClassNotFoundException");
		} catch (IOException e) {
			throw new BibliotheksZwischenfall("IOException");
		} catch (InstantiationException e) {
			throw new BibliotheksZwischenfall("InstantiationException");
		} catch (IllegalAccessException e) {
			throw new BibliotheksZwischenfall("IllegalAccessException");
		}
		return regel;
	}
}