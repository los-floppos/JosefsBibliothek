package hardcode.papierjosef.bibliothek.statistik;

import hardcode.papierjosef.bibliothek.modell.Absatz;
import hardcode.papierjosef.bibliothek.modell.Dokument;
import hardcode.papierjosef.bibliothek.modell.Satz;

public class GrundlegendeStatistik implements Statistik{
	private int zahlDerAbsaetze;
	private int zahlDerSaetze;
	private int zahlDerWoerter;

	public void errechne(Dokument dokument){
		zahlDerAbsaetze = dokument.getAbsaetze().size();
		
		zahlDerSaetze = 0;
		zahlDerWoerter = 0;		
		
		for (Absatz absatz : dokument.getAbsaetze()) {
			zahlDerSaetze += absatz.getSaetze().size();
			
			for(Satz satz : absatz.getSaetze()) {
				zahlDerWoerter += satz.getWoerter().size();
			}

		}
		
		//dokument.absaetze.each { it.saetze.each{ zahlDerWoerter+=it.woerter.findAll{!it.wortart.equals(Wortart.XKOMMA) && !it.wortart.equals(Wortart.XSATZENDE) && !it.wortart.equals(Wortart.XSONST)}.size()}};
	}
	
	@Override
	public String toString() {
		return "GrundlegendeStatistik [zahlDerAbsaetze=" + zahlDerAbsaetze + ", zahlDerSaetze=" + zahlDerSaetze + ", zahlDerWoerter=" + zahlDerWoerter + "]";
	}
}
