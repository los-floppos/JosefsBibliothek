package hardcode.papierjosef.bibliothek.assistenz;

import java.io.IOException;

import opennlp.tools.util.InvalidFormatException;
import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.modell.Dokument;
import hardcode.papierjosef.bibliothek.modell.Satz;
import hardcode.papierjosef.bibliothek.modell.Sprache;
import hardcode.papierjosef.bibliothek.modell.Wort;
import hardcode.papierjosef.bibliothek.statistik.EigenschaftsStatistik;
import hardcode.papierjosef.bibliothek.statistik.GrundlegendeStatistik;

public class JosefsSekretaerin {
	private Dokument dokument;

	public Dokument getDokument() {
		return dokument;
	}

	public JosefsSekretaerin(String text, Sprache sprache)
			throws InvalidFormatException, IOException {
		OpenNlpSekretaerin.setInstanz(new OpenNlpSekretaerin(sprache));
		dokument = new Dokument(text);
	}

	public GrundlegendeStatistik errechneGrundlegendeStatistik() { //TODO
		GrundlegendeStatistik stat = new GrundlegendeStatistik();
		stat.errechne(dokument);
		return stat;
	}
	
	public EigenschaftsStatistik errechneEigenschaftsStatistik() { //TODO
		EigenschaftsStatistik stat = new EigenschaftsStatistik();
		stat.errechne(dokument);
		return stat;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public String ausgebeDokument() {
		String str = ""; // TODO

		for (Absatz absatz : dokument.getAbsaetze()) {
			for (Satz satz : absatz.getSaetze()) {
				str += "{";
				for (Wort wort : satz.getWoerter()) {
					str += wort.getWort() + "/" + wort.getWortart() + " ";
				}
				str += "}, ";
			}
			str += "\n";
		}
		return str;
	}
}
