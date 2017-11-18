package filRouge.v2;

public interface FileImmutable<E> extends File<E> {

	/* 
	 * Accesseurs
	 */
	FileImmutable<E> suivants();
	
	/*
	 * Fabriques
	 */
	@Override
	FileImmutable<E> creer();

	FileImmutable<E> creer(E dernier);
	
	/*
	 * Services
	 */
	@Override
	default FileImmutable<E> ajout(E dernierDansFile) {
		return this.creer(dernierDansFile);
	}
	@Override
	default FileImmutable<E> retrait() {
		return this.suivants();
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
