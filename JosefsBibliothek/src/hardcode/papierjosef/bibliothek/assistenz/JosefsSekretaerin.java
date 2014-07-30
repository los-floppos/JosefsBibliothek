package hardcode.papierjosef.bibliothek.assistenz;

import java.io.File;
import java.io.IOException;

import hardcode.papierjosef.bibliothek.sprachen.Sprache;
import hardcode.papierjosef.bibliothek.statistik.EigenschaftsStatistik;
import hardcode.papierjosef.bibliothek.statistik.GrundlegendeStatistik;
import hardcode.papierjosef.model.document.Document;
import hardcode.papierjosef.model.document.Paragraph;
import hardcode.papierjosef.model.document.Sentence;
import hardcode.papierjosef.model.document.Word;

public class JosefsSekretaerin {
	private Document dokument;

	public Document getDokument() {
		return dokument;
	}

	public JosefsSekretaerin(File programmpfad, String text, Sprache sprache) throws Exception, IOException {
		OpenNlpSekretaerin.setInstanz(new OpenNlpSekretaerin(programmpfad, sprache));
		dokument = new Document(text);
	}

	//TODO
//	public GrundlegendeStatistik errechneGrundlegendeStatistik() { //TODO
//		GrundlegendeStatistik stat = new GrundlegendeStatistik();
//		stat.errechne(dokument);
//		return stat;
//	}
//	
//	public EigenschaftsStatistik errechneEigenschaftsStatistik() { //TODO
//		EigenschaftsStatistik stat = new EigenschaftsStatistik();
//		stat.errechne(dokument);
//		return stat;
//	}

	public void setDokument(Document dokument) {
		this.dokument = dokument;
	}

//	public String ausgebeDokument() {
//		String str = ""; // TODO
//
//		for (Paragraph p : dokument.getChildElements()) {
//			for (Sentence sentence : p.getChildElements()) {
//				str += "{";
//				for (Word word : sentence.getWoerter()) {
//					str += wort.getWort() + "/" + wort.getWortart() + " ";
//				}
//				str += "}, ";
//			}
//			str += "\n";
//		}
//		return str;
//	}
}
