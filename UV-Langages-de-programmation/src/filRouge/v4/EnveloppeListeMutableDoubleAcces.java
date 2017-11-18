package filRouge.v4;

import java.util.Iterator;

/*
 * Implem mutable
 */

public class EnveloppeListeMutableDoubleAcces<E> implements FileMutable<E> {

	private ListeInductiveMutable<E> liste; // liste complète
	private ListeInductiveMutable<E> fin;// sous-liste suffixe d'un élément ou *
	// Invariant :
	// - si liste complète vide, alors fin non spécifié
	// - sinon : suffixe contenant le dernier élément

	private int taille;

	public EnveloppeListeMutableDoubleAcces() {
		this.liste = ListeInductiveMutable.vide();
		this.fin = null;
		this.taille = 0;
	}

	/*
	 * Accesseurs.
	 */
	@Override
	public E tete() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.liste.tete();
	}

	@Override
	public int taille() {
		return this.taille;
	}


	@Override
	public void ajouter(E element) {
		if (this.estVide()) {
			ListeInductiveMutable<E> nouvelElement = ListeInductiveMutable.cons(element, this.liste);
			this.liste = nouvelElement;
			this.fin = nouvelElement;
			this.taille++;
			return;
		}
		ListeInductiveMutable<E> nouvelElement = ListeInductiveMutable.cons(element, this.fin.reste());
		this.fin.changerReste(nouvelElement);
		this.fin = nouvelElement;
		this.taille++;
	}

	@Override
	public void retirer() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		this.liste = this.liste.reste();
		this.taille--;
	}

	@Override
	public FileMutable<E> creer() {
		return new EnveloppeListeMutableDoubleAcces<>();
	}
	
	@Override
	public FileMutable<E> creerCopie() {
		FileMutable<E> file = creer();
		for(E e : this){
			file.ajouter(e);
		}
		return file;
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurSequence<>(this.liste);
	}
	
	@Override
	public String toString() {
		return this.representation();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof FileMutable<?>)){
			return false;
		}
			FileMutable<?> file = (FileMutable<?>)obj;
			return this.estEgal(file);
	}

}
