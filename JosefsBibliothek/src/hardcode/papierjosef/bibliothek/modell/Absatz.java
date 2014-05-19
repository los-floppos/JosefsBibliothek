package hardcode.papierjosef.bibliothek.modell;

import java.util.List;
import java.util.Map;

public class Absatz {
	List<Satz> saetze; 
	boolean ignorieren;

	Map anzahlWortarten; //KOMMENTAR
	
	Map eigenschaften;

	public Absatz(String text) {
		String tempText = ersetzeKlammern(text);
	
		for(String s: OpenNlpSekretaerin.getInstanz().sentenceDetector.sentDetect(tempText)){
			Satz satz=new Satz(s);
			saetze.add(satz);
			
			for(Wortart w: satz.anzahlWortarten.keySet()){
				Integer anzahl =  anzahlWortarten.getAt(w);
				if (anzahl == null) {
					anzahlWortarten.put(w, satz.anzahlWortarten.get(w))
				} else {
					anzahlWortarten.put(w, anzahl + satz.anzahlWortarten.get(w));
				}
			}
		}
	}
	
	public static String ersetzeKlammern(String text){
		StringBuilder temp=new StringBuilder(text);
	
		for(int i=0;i<text.length();i++){
			if(text.charAt(i)=='('){
				while(text.charAt(i)!=')'){
					temp.replace(i, i+1, "A");
					i++;
				}
				temp.replace(i, i+1, "A");
			}
		}
		
		return temp.toString();
	}
}