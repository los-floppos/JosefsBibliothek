package hardcode.papierjosef.bibliothek;
import java.io.File;
import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.modell.Dokument;
import hardcode.papierjosef.bibliothek.modell.Satz;
import hardcode.papierjosef.bibliothek.modell.Wort;
import hardcode.papierjosef.bibliothek.modell.Wortart;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import hardcode.papierjosef.bibliothek.statistik.EigenschaftsStatistik;
import hardcode.papierjosef.bibliothek.statistik.GrundlegendeStatistik;

public class HauptKlasse {
	
	public static void main(String[] args) {
		//String text="Session Beans bilden insbesondere Vorgänge ab, die der Nutzer mit dem System durchführt. Sie bedienen sich häufig mehrerer Entity Beans, um die Auswirkungen des Prozesses darzustellen.\nMan unterscheidet zustandslose (stateless) und zustandsbehaftete (stateful) Session Beans.\nEine zustandsbehaftete Session Bean hat ein eigenes Gedächtnis. Sie kann Informationen aus einem Methodenaufruf speichern, damit sie bei einem späteren Aufruf einer anderen (oder der gleichen) Methode wieder zur Verfügung stehen. Die Zustandsbehaftung wird durch die Vergabe einer eindeutigen ID umgesetzt, über diese ID können die zustandsbehafteten (stateful) Session Beans unterschieden werden.\nIm Gegensatz dazu müssen einer zustandslosen Session Bean bei jedem Aufruf alle Informationen als Parameter übergeben werden, die für die Abarbeitung dieses Aufrufs benötigt werden. Da eine zustandslose Session Bean keine Informationen speichern kann, ist sie nicht von anderen Session Beans der gleichen Klasse unterscheidbar, sie hat also keine eigene Identität.";
		String text = "Franz jagt im komplett verwahrlosten Taxi quer durch Bayern.";
		
		File programmpfad = new File(System.getProperty("user.dir"));
		
		JosefsSekretaerin assistenz = null;
		try {
			assistenz = new JosefsSekretaerin(programmpfad, text, new DeutscheSprache());
		} catch (IOException e) {
			e.printStackTrace(); //TODO
		} catch (Exception e) {
			e.printStackTrace(); //TODO
		}
		Dokument d = assistenz.getDokument();
		
		for(Wortart w : d.getAnzahlWortarten().keySet()) {
			int anzahl = d.getAnzahlWortarten().get(w);
			System.out.print(w.toString() + ": " + anzahl + "; ");
		}

		System.out.println("##################");
		
		GrundlegendeStatistik grundStat = assistenz.errechneGrundlegendeStatistik();
		System.out.println(grundStat);
		
		d.put("Tolle Eigenschaft", "true");
		d.getAbsaetze().get(0).put("Toller Satz", "true");
		d.getAbsaetze().get(0).getSaetze().get(0).put("Schöner Satz", "true");
		//TODO: fuer woerter!
		
		EigenschaftsStatistik eigenStat = assistenz.errechneEigenschaftsStatistik();
		System.out.println(eigenStat);
		
		System.out.println("##################");
		
		for(Absatz a : d.getAbsaetze()) {
			System.out.println("> ABSATZ");
			for(Satz s : a.getSaetze()) {
				System.out.println("---> SATZ");
				for(Wort w : s.getWoerter()) {
					System.out.println("------> " + w.getWort() + ": " + w.getWortart() + "(" + w.getStart() + ", " + w.getEnde() + ")");
				}
			}
		}
	}

}
