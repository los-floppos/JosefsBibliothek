import hardcode.papierjosef.bibliothek.assistenz.JosefsSekretaerin
import hardcode.papierjosef.bibliothek.sprachen.DeutscheSprache

String text="Das ist ein Test. Hier schreiben wir Zeugs rein.\n Unterhalb findest Du eine Liste aller bestellbaren Bücher.";
JosefsSekretaerin assistenz=new JosefsSekretaerin(text,new DeutscheSprache());
println assistenz.ausgebeDokument();
println assistenz.errechneStatistik();