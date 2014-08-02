package hardcode.papierjosef.bibliothek.loader;

import hardcode.papierjosef.bibliothek.exception.BibliotheksZwischenfall;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Laedt eine Klasse des Typs T aus einer class-Datei ein.
 */
public class LadeKlasse<T> {
	
	public LadeKlasse() {
		
	}
	
	/**
	 * Laedt eine Klasse des Typs T aus einer class-Datei
	 * @param pfad File: Pfad zum Ordner, in dem sich die Klassendatei befindet
	 * @param klassenName String: Name der Klassendatei, ohne .class, also z.B. nur "Klassenname".
	 * @return T: Die geladene Klasse
	 * @throws BibliotheksZwischenfall
	 */
	public T ladeKlasse(File pfad, String klassenName) throws BibliotheksZwischenfall  {
		T object = null;
		try{	
			URL url = pfad.toURI().toURL();		
			//URLClassLoader loader = new URLClassLoader(new URL[]{url}, Regel.class.getClassLoader());
			URLClassLoader loader = new URLClassLoader(new URL[]{url});
			Class c = loader.loadClass(klassenName);
			object = (T) c.newInstance();
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
		return object;
	}
}