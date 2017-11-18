package filRouge.v2;

import java.util.Iterator;

public class IterateurFile<E> implements Iterator<E> {

	private File<E> courant; 

	public IterateurFile(File<E> file) {
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
