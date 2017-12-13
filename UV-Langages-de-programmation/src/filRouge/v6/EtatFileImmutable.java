package filRouge.v6;

import filRouge.v5.IdentifiableParIteration;
import filRouge.v5.RepresentableParIteration;

public interface EtatFileImmutable<E> extends 
	EtatFile<EtatFileImmutable<E>, E>,
	IdentifiableParIteration<EtatFileImmutable<?>, E>,
	RepresentableParIteration<E>	
{

	/* 
	 * Accesseurs
	 */
	
	/*
	 * Fabriques
	 */
	EtatFileImmutable<E> creer(E dernier);
	
}
