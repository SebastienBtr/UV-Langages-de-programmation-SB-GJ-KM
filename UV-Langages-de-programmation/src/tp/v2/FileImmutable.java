package tp.v2;

public interface FileImmutable<E> extends File<E> {

	/* 
	 * Accesseurs
	 */
	FileImmutable<E> suivants();
	
	/*
	 * Fabriques
	 */
	FileImmutable<E> creer();
	FileImmutable<E> creer(E dernier);
	FileImmutable<E> creer(FileImmutable<E> file, E dernier);
	
	/*
	 * Services
	 */
	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {

		if (estVide()) {
			return creer(dernierDansFile);
		}

		FileImmutable<E> ret = creer(this.premier());
		FileImmutable<E> tmp = this.suivants();
		while (!tmp.estVide()) {
			ret = creer(ret, tmp.premier());
			tmp = tmp.suivants();
		}
		ret = creer(ret, dernierDansFile);
		return ret;
	}
	@Override
	default FileImmutable<E> retrait() {

		FileImmutable<E> r = this.suivants();
		return r;
	}
	// Complexité O(|secondeFile|)
	@Override
	default FileImmutable<E> ajout(File<E> secondeFile){
		FileImmutable<E> r = this;
		for(E e : secondeFile){
			r = r.ajout(e);
		}
		return r;
	}

}
