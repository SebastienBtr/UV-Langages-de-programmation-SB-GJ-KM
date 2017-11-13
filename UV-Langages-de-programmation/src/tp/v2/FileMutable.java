package tp.v2;

public interface FileMutable<E> extends File<E> {

	/*
	 * Accesseurs
	 */
	@Override
	default FileMutable<E> suivants(){

		FileMutable<E> copy = this.creerCopie();

		copy.retrait();

		if (copy.estVide()) {
			return null;
		}

		return copy;
	}

	void ajouter(E element);
	void retirer();
	
	/*
	 * Fabriques
	 */
	FileMutable<E> creer();
	FileMutable<E> creerCopie();
	
	/*
	 * Services
	 */
	@Override
	default FileMutable<E> ajout(E dernierDansFile) {
		this.premier() =
		return this;
	}
	@Override
	default FileMutable<E> retrait() {
		// TODO
		return this;
	}
	// Complexité O(|secondeFile|)
	@Override
	default FileMutable<E> ajout(File<E> secondeFile) {
		// TODO (même code que FileImmutable.ajout)
		return null;
	}
	
	// Complexité en O(1).
	void ajouter(File<E> secondeFile);

}
