package filRouge.v6;

import java.util.Iterator;

import filRouge.v5.ListeImmutable;

/*
 * Implem immutable.
 */

/*
 * Amélioration avec deux listes immutables. Complexité : temps constant si usage linéaire
 * (sans persistance) (amortissement relatif à l'ajout)
 */

class EtatEnveloppeDeuxListesImmutables<E> implements EtatFileImmutable<E> {

	private ListeImmutable<E> listeDebut; // liste de tete dans l'ordre d'arrivée 
	private ListeImmutable<E> listeFin;// liste de queue dans l'ordre inverse d'arrivée
	// Invariant : si listeTete vide, alors listeFin vide.

	private int taille;

	public EtatEnveloppeDeuxListesImmutables() {
		ListeImmutable<E> vide = ListeImmutable.vide();
		this.listeFin = vide;
		this.listeDebut = vide;
		this.taille = 0;
	}

	public EtatEnveloppeDeuxListesImmutables(int taille, ListeImmutable<E> listeTete, ListeImmutable<E> listeFin) {
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
	public EtatFileImmutable<E> suivants() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return new EtatEnveloppeDeuxListesImmutables<E>(this.taille - 1, this.listeDebut.reste(), this.listeFin);
	}
	
	@Override
	public int taille() {
		return this.taille;
	}

	@Override
	public EtatFileImmutable<E> creer() {
		return new EtatEnveloppeDeuxListesImmutables<>();
	}

	@Override
	public EtatFileImmutable<E> creer(E dernier) {
		return new EtatEnveloppeDeuxListesImmutables<>(this.taille + 1, this.listeDebut,
				ListeImmutable.cons(dernier, this.listeFin));
	}

	@Override
	public Iterator<E> iterator() {
		return new IterateurEtatFileImmutable<>(this);
	}

	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof EtatFileImmutable<?>))
			return false;
		EtatFileImmutable<?> l = (EtatFileImmutable<?>)obj;
		return this.estEgal(l);
	}
	@Override
	public String toString() {
		return this.representation();
	}		
}
