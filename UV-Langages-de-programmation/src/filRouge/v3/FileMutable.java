package filRouge.v3;

public interface FileMutable<E> extends File<FileMutable<E>, E> {

	/*
	 * Accesseurs
	 */
	@Override
	default FileMutable<E> suivants() {
		FileMutable<E> r = creerCopie();
		r.retirer();
		return r;
	}

	void ajouter(E element);

	void retirer();

	/*
	 * Fabriques
	 */
	FileMutable<E> creerCopie();

	@Override
	default FileMutable<E> sujet() {
		return this;
	}
	
	/*
	 * Services
	 */
	@Override
	default FileMutable<E> ajout(E dernierDansFile) {
		this.ajouter(dernierDansFile);
		return this;
	}

	@Override
	default FileMutable<E> retrait() {
		this.retirer();
		return this;
	}

	// Complexité en O(1).
	void ajouter(FileMutable<E> secondeFile);

}
