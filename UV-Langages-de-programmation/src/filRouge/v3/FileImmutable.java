package filRouge.v3;

public interface FileImmutable<E> extends File<FileImmutable<E>, E> {

	/* 
	 * Accesseurs
	 */
	
	/*
	 * Fabriques
	 */
	FileImmutable<E> creer(E dernier);
	
	@Override
	default FileImmutable<E> sujet() {
		return this;
	}
	
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

}
