package filRouge.v3;

import java.util.Iterator;

public class IterateurFile<E> implements Iterator<E> {

	private FileImmutable<E> courant; 

	public IterateurFile(FileImmutable<E> file) {
		this.courant = file;
	}

	@Override
	public boolean hasNext() {
		return !this.courant.estVide();
	}

	@Override
	public E next() {
		E r = this.courant.premier();
		this.courant = this.courant.retrait();
		return r;
	}

}
