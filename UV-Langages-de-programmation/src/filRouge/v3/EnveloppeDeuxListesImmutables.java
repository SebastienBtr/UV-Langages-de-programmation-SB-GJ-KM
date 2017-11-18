package filRouge.v3;

import java.util.Iterator;

/*
 * Implem immutable.
 */

/*
 * Amélioration avec deux listes immutables. Complexité : temps constant si usage linéaire
 * (sans persistance) (amortissement relatif à l'ajout)
 */

class EnveloppeDeuxListesImmutables<E> implements FileImmutable<E> {

	private ListeImmutable<E> listeDebut; // liste de tete dans l'ordre d'arrivée 
	private ListeImmutable<E> listeFin;// liste de queue dans l'ordre inverse d'arrivée
	// Invariant : si listeTete vide, alors listeFin vide.

	private int taille;

	public EnveloppeDeuxListesImmutables() {
		ListeImmutable<E> vide = ListeImmutable.vide();
		this.listeFin = vide;
		this.listeDebut = vide;
		this.taille = 0;
	}

	public EnveloppeDeuxListesImmutables(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
		this.taille = taille;
		if (listeTete.estVide()) {
			ListeImmutable<E> vide = listeTete;
			listeTete = listeFin.miroir();
			listeFin = vide;
		}
		this.listeDebut = listeTete;
		this.listeFin = listeFin;
	}

	@Override
	public E premier() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.listeDebut.tete();
	}

	@Override
	public FileImmutable<E> suivants() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return new EnveloppeDeuxListesImmutables<E>(this.taille - 1, this.listeDebut.reste(), this.listeFin);
	}
	
	@Override
	public int taille() {
		return this.taille;
	}

	@Override
	public FileImmutable<E> creer() {
		return new EnveloppeDeuxListesImmutables<>();
	}

	@Override
	public FileImmutable<E> creer(E dernier) {
		return new EnveloppeDeuxListesImmutables<>(this.taille + 1, this.listeDebut,
				ListeImmutable.cons(dernier, this.listeFin));
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurFile<>(this);
	}

	@Override
	public String toString() {
		return this.representation();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof FileImmutable<?>)){
			return false;
		}
		try{
			@SuppressWarnings("unchecked")
			FileImmutable<E> file = (FileImmutable<E>)obj;
			return this.estEgal(file);
		}catch(ClassCastException e){
			return false;
		}
	}
}
