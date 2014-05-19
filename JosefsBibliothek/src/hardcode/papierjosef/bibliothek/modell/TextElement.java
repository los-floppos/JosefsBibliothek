package hardcode.papierjosef.bibliothek.modell;

import java.util.HashMap;
import java.util.Map;

public class TextElement {
	
	private long start;
	private long ende;
	private String text;
	private Map<String, String> eigenschaften;
	
	public TextElement(String text, long start) {
		this.text = text;
		this.start = start;
		this.ende = start + text.length();
		eigenschaften = new HashMap<String, String>();		
	}
	
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public String get(Object key) {
		return eigenschaften.get(key);
	}
	public String put(String key, String value) {
		return eigenschaften.put(key, value);
	}
	public void clear() {
		eigenschaften.clear();
	}
	public long getEnde() {
		return ende;
	}
	public void setEnde(long ende) {
		this.ende = ende;
	}
	public String getText() {
		return text;
	}
	
	
}
