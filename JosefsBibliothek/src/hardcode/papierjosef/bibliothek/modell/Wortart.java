package hardcode.papierjosef.bibliothek.modell;

/** 
 * Quelle:
 *         http://www.coli.uni-saarland.de/projects/sfb378/negra-corpus/stts.asc
 *         IMS Stuttgart / www@ims.uni-stuttgart.de / Thu Nov 9 12:58:03 1995
 *         (oli)
 */
public enum Wortart {
	ADJA, // attributives Adjektiv [das] große [Haus]
	ADJD, // adverbiales oder [er fährt] schnell prädikatives Adjektiv [er ist]
			// schnell
	ADV, // Adverb schon, bald, doch
	APPR, // Präposition; Zirkumposition links in [der Stadt], ohne [mich]
	APPRART, // Präposition mit Artikel im [Haus], zur [Sache]
	APPO, // Postposition [ihm] zufolge, [der Sache] wegen
	APZR, // Zirkumposition rechts [von jetzt] an
	ART, // bestimmter oder der, die, das,
	// unbestimmter Artikel ein, eine, ...
	CARD, // Kardinalzahl zwei [Männer], [im Jahre] 1994
	FM, // Fremdsprachliches Material [Er hat das mit ``]
		// A big fish ['' übersetzt]
	ITJ, // Interjektion mhm, ach, tja
	ORD, // Ordinalzahl [der] neunte [August] //ALT!?
	KOUI, // unterordnende Konjunktion um [zu leben],
	// mit ``zu'' und Infinitiv anstatt [zu fragen]
	KOUS, // unterordnende Konjunktion weil, daß, damit,
	// mit Satz wenn, ob
	KON, // nebenordnende Konjunktion und, oder, aber
	KOKOM, // Vergleichskonjunktion als, wie
	NN, // normales Nomen Tisch, Herr, [das] Reisen
	NE, // Eigennamen Hans, Hamburg, HSV
	PDS, // substituierendes Demonstrativ- dieser, jener
	// pronomen
	PDAT, // attribuierendes Demonstrativ- jener [Mensch]
	// pronomen
	PIS, // substituierendes Indefinit- keiner, viele, man, niemand
	// pronomen
	PIAT, // attribuierendes Indefinit- kein [Mensch],
	// pronomen ohne Determiner irgendein [Glas]
	PIDAT, // attribuierendes Indefinit- [ein] wenig [Wasser], //ALT!?
	// pronomen mit Determiner [die] beiden [Brüder]
	PPER, // irreflexives Personalpronomen ich, er, ihm, mich, dir
	PPOSS, // substituierendes Possessiv- meins, deiner
	// pronomen
	PPOSAT, // attribuierendes Possessivpronomen mein [Buch], deine [Mutter]
	PRELS, // substituierendes Relativpronomen [der Hund ,] der
	PRELAT, // attribuierendes Relativpronomen [der Mann ,] dessen [Hund]
	PRF, // reflexives Personalpronomen sich, einander, dich, mir
	PWS, // substituierendes wer, was
	// Interrogativpronomen
	PWAT, // attribuierendes welche [Farbe],
	// Interrogativpronomen wessen [Hut]
	PWAV, // adverbiales Interrogativ- warum, wo, wann,
	// oder Relativpronomen worüber, wobei
	PROAV, //Pronomialadverb (deswegen, dazu, darüber) Quelle: linguistik.hu-berlin.de/...
	PAV, // Pronominaladverb dafür, dabei, deswegen, trotzdem //ALT!?
	PTKZU, // ``zu'' vor Infinitiv zu [gehen]
	PTKNEG, // Negationspartikel nicht
	PTKVZ, // abgetrennter Verbzusatz [er kommt] an, [er fährt] rad
	PTKANT, // Antwortpartikel ja, nein, danke, bitte
	PTKA, // Partikel bei Adjektiv am [schönsten],
	// oder Adverb zu [schnell]
	SGML, // SGML Markup //ALT!?
	SPELL, // Buchstabierfolge S-C-H-W-E-I-K-L //ALT!?
	TRUNC, // Kompositions-Erstglied An- [und Abreise]
	VVFIN, // finites Verb, voll [du] gehst, [wir] kommen [an]
	VVIMP, // Imperativ, voll komm [!]
	VVINF, // Infinitiv, voll gehen, ankommen
	VVIZU, // Infinitiv mit ``zu'', voll anzukommen, loszulassen
	VVPP, // Partizip Perfekt, voll gegangen, angekommen
	VAFIN, // finites Verb, aux [du] bist, [wir] werden
	VAIMP, // Imperativ, aux sei [ruhig !]
	VAINF, // Infinitiv, aux werden, sein
	VAPP, // Partizip Perfekt, aux gewesen
	VMFIN, // finites Verb, modal dürfen
	VMINF, // Infinitiv, modal wollen
	VMPP, // Partizip Perfekt, modal gekonnt, [er hat gehen] können
	XY, // Nichtwort, Sonderzeichen 3:7, H2O, enthaltend D2XW3
	XKOMMA ,		
	XSATZENDE,// Satzbeendende Interpunktion . ? ! ; :
	XSONST // sonstige Satzzeichen; satzintern - [,]()
}
