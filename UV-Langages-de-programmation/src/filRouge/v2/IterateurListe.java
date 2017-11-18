package filRouge.v2;

import java.util.Iterator;

public class IterateurListe<E> implements Iterator<E> {

	private Liste<E> courant;

	public IterateurListe(Liste<E> liste) {
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
