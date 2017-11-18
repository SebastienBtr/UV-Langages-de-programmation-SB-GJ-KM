package filRouge.v4;

import java.util.Iterator;

public class IterateurSequence<K extends PossiblementVide & DecomposableSequentiellement<K, E>, E> implements Iterator<E> {

	private K courant; 

	public IterateurSequence(K sequence) {
		this.courant = sequence;
	}

	@Override
	public boolean hasNext() {
		return !this.courant.estVide();
	}

	@Override
	public E next() {
		E r = this.courant.tete();
		this.courant = this.courant.reste();
		return r;
	}

}
