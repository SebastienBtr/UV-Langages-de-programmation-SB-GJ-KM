package filRouge.v5;

import filRouge.v3.FileImmutable;

import java.util.Iterator;

public class IterateurFile<E> implements Iterator<E> {

	private EtatImmutable<E> courant;

	public IterateurFile(EtatImmutable<E> file) {
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
