package hardcode.papierjosef.bibliothek.operation.regel;

import hardcode.papierjosef.bibliothek.operation.Operation;
import hardcode.papierjosef.model.document.TextElement;

/**
 * Eine Regel ist eine besondere Operation die auf TextElementen des DocumentModel operiert. 
 * @param <T> Document, Paragraph, Sentence oder Word des DocumentModel
 */
public abstract class Regel<T extends TextElement> extends Operation<T>{

}
