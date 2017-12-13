package filRouge.v6;

import filRouge.v5.IdentifiableParIteration;
import filRouge.v5.RepresentableParIteration;

public interface FileImmutable<E> extends 
	File<FileImmutable<E>, E>,
	IdentifiableParIteration<FileImmutable<?>, E>,
	RepresentableParIteration<E>	
{

	/* 
	 * Accesseurs
	 */
	
	/*
	 * Fabriques
	 */
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

}
