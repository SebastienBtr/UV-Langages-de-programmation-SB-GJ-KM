package filRouge.v4;

/*
 * Implem immutable.
 */

/*
 * Complexité : temps constant si usage linéaire
 * (sans persistance) (amortissement relatif à l'ajout)
 */

class EnveloppeDeuxListesImmutables<E> implements FileImmutable<E> {

	private ListeInductiveImmutable<E> listeDebut; // liste de tete dans l'ordre
											// d'arrivée
	private ListeInductiveImmutable<E> listeFin;// liste de queue dans l'ordre inverse
										// d'arrivée
	// Invariant : si listeTete vide, alors listeFin vide.

	private int taille;

	public EnveloppeDeuxListesImmutables() {
		ListeInductiveImmutable<E> vide = ListeInductiveImmutable.vide();
		this.listeFin = vide;
		this.listeDebut = vide;
		this.taille = 0;
	}

	public EnveloppeDeuxListesImmutables(int taille, ListeInductiveImmutable<E> listeTete, ListeInductiveImmutable<E> listeFin) {
		this.taille = taille;
		if (listeTete.estVide()) {
			ListeInductiveImmutable<E> vide = listeTete;
			listeTete = listeFin.miroir();
			listeFin = vide;
		}
		this.listeDebut = listeTete;
		this.listeFin = listeFin;
	}

	@Override
	public E tete() {
		if (this.estVide()) {
			throw new UnsupportedOperationException();
		}
		return this.listeDebut.tete();
	}

	@Override
	public FileImmutable<E> reste() {
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
				ListeInductiveImmutable.cons(dernier, this.listeFin));
	}

	@Override
	public String toString() {
		return this.representation();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof FileImmutable<?>)) {
			return false;
		}
		FileImmutable<?> file = (FileImmutable<?>) obj;
		return this.estEgal(file);
	}
}
