package filRouge.v3;

import java.util.Iterator;

public class IterateurListe<K extends Liste<K, E>, E> implements Iterator<E> {

	private K courant;

	public IterateurListe(K liste) {
		this.courant = liste;
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
