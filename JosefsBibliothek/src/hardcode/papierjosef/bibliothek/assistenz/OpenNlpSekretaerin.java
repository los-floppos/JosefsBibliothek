package hardcode.papierjosef.bibliothek.assistenz;

import hardcode.papierjosef.bibliothek.modell.Sprache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class OpenNlpSekretaerin {

	public SentenceDetectorME getSentenceDetector() {
		return sentenceDetector;
	}

	public void setSentenceDetector(SentenceDetectorME sentenceDetector) {
		this.sentenceDetector = sentenceDetector;
	}

	public Tokenizer getTokenizer() {
		return tokenizer;
	}

	public void setTokenizer(Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public POSTaggerME getTagger() {
		return tagger;
	}

	public void setTagger(POSTaggerME tagger) {
		this.tagger = tagger;
	}

	SentenceDetectorME sentenceDetector;
	Tokenizer tokenizer;
	POSTaggerME tagger;

	static OpenNlpSekretaerin instanz;

	public static OpenNlpSekretaerin getInstanz(){
		if(instanz==null)
			throw new UnsupportedOperationException();
		return instanz;
	}

	OpenNlpSekretaerin(Sprache sprache) throws InvalidFormatException, IOException{
		String pfad="opennlpmodels/"+sprache.getSprache();
		FileInputStream sentModelIn = new FileInputStream(pfad + "-sent.bin");
		InputStream tokenModelIn = new FileInputStream(pfad + "-token.bin");
		InputStream posModelIn = new FileInputStream(pfad + "-pos-maxent.bin");

		SentenceModel sentenceModel = new SentenceModel(sentModelIn);
		TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
		POSModel posModel = new POSModel(posModelIn);

		if (sentModelIn != null)
			sentModelIn.close();
		if (tokenModelIn != null)
			tokenModelIn.close();
		if (posModelIn != null)
			posModelIn.close();

		sentenceDetector = new SentenceDetectorME(sentenceModel);
		tokenizer = new TokenizerME(tokenModel);
		tagger = new POSTaggerME(posModel);
	}
}
