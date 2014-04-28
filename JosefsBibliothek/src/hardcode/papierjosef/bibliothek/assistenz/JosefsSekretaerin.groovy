package hardcode.papierjosef.bibliothek.assistenz

import hardcode.papierjosef.bibliothek.modell.Dokument
import hardcode.papierjosef.bibliothek.modell.Sprache
import hardcode.papierjosef.bibliothek.statistik.GrundlegendeStatistik

class JosefsSekretaerin {
	Dokument dokument;

	public JosefsSekretaerin(String text, Sprache sprache){
		OpenNlpSekretaerin.instanz=new OpenNlpSekretaerin(sprache);
		dokument = new Dokument(text);
	}

	public GrundlegendeStatistik errechneStatistik(){
		GrundlegendeStatistik stat=new GrundlegendeStatistik();
		stat.errechne(dokument);
		return stat;
	}

	public String ausgebeDokument(){
		String str="";
		dokument.absaetze.each{
			it.saetze.each{
				str+="{"; it.woerter.each{
					str+=it.wort + "/" + it.satzteil + " "
				};
				str+="}, ";
			};
			str+="\n"
		};
		return str;
	}
}
