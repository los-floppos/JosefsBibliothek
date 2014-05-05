package hardcode.papierjosef.bibliothek.statistik

import hardcode.papierjosef.bibliothek.modell.Dokument

class GrundlegendeStatistik {
	int zahlDerAbsaetze;
	int zahlDerSaetze;
	int zahlDerWoerter;

	@Override
	public String toString() {
		return "GrundlegendeStatistik [zahlDerAbsaetze=" + zahlDerAbsaetze + ", zahlDerSaetze=" + zahlDerSaetze + ", zahlDerWoerter=" + zahlDerWoerter + "]";
	}

	public void errechne(Dokument dokument){
		zahlDerAbsaetze=dokument.absaetze.size();
		dokument.absaetze.each {zahlDerSaetze+=it.saetze.size()};
		dokument.absaetze.each { it.saetze.each{ zahlDerWoerter+=it.woerter.findAll{!it.wortart.equals(Wortart.XKOMMA) && !it.wortart.equals(Wortart.XSATZENDE) && !it.wortart.equals(Wortart.XSONST)}.size()}};
	}
}
