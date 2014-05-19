import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin;
import hardcode.papierjosef.bibliothek.modell.Dokument;
import hardcode.papierjosef.bibliothek.modell.Wortart;
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache;
import hardcode.papierjosef.bibliothek.statistik.GrundlegendeStatistik;

public class HauptKlasse {
	
	public static void main(String[] args) {
		//String text="Session Beans bilden insbesondere Vorgänge ab, die der Nutzer mit dem System durchführt. Sie bedienen sich häufig mehrerer Entity Beans, um die Auswirkungen des Prozesses darzustellen.\nMan unterscheidet zustandslose (stateless) und zustandsbehaftete (stateful) Session Beans.\nEine zustandsbehaftete Session Bean hat ein eigenes Gedächtnis. Sie kann Informationen aus einem Methodenaufruf speichern, damit sie bei einem späteren Aufruf einer anderen (oder der gleichen) Methode wieder zur Verfügung stehen. Die Zustandsbehaftung wird durch die Vergabe einer eindeutigen ID umgesetzt, über diese ID können die zustandsbehafteten (stateful) Session Beans unterschieden werden.\nIm Gegensatz dazu müssen einer zustandslosen Session Bean bei jedem Aufruf alle Informationen als Parameter übergeben werden, die für die Abarbeitung dieses Aufrufs benötigt werden. Da eine zustandslose Session Bean keine Informationen speichern kann, ist sie nicht von anderen Session Beans der gleichen Klasse unterscheidbar, sie hat also keine eigene Identität.";
		String text = "Franz jagt im komplett verwahrlosten Taxi quer durch Bayern.";
		
		JosefsSekretaerin assistenz = null;
		try {
			assistenz = new JosefsSekretaerin(text, new DeutscheSprache());
		} catch (InvalidFormatException e) {
			e.printStackTrace(); //TODO
		} catch (IOException e) {
			e.printStackTrace(); //TODO
		}
		Dokument d = assistenz.getDokument();
		
		for(Wortart w : d.getAnzahlWortarten().keySet()) {
			int anzahl = d.getAnzahlWortarten().get(w);
			System.out.print(w.toString() + ": " + anzahl + "; ");
		}
		System.out.println();
		
		GrundlegendeStatistik grundStat = assistenz.errechneStatistik();
		System.out.println(grundStat);
	}

}
