package filRouge.v6;

import java.util.Iterator;

public class IterateurEtatFileImmutable<E, K extends EtatFile<K, E>> implements Iterator<E> {

	private K courant; 

	public IterateurEtatFileImmutable(K file) {
		this.courant = file;
	}

	@Override
	public boolean hasNext() {
		return !this.courant.estVide();
	}

	@Override
	public E next() {
		E r = this.courant.premier();
		this.courant = this.courant.suivants();
		return r;
	}

}
