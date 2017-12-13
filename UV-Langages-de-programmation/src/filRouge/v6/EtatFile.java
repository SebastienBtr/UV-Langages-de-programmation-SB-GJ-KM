package filRouge.v6;

import filRouge.v5.Mesurable;

public interface EtatFile<K extends EtatFile<K, E>, E> extends Iterable<E>, Mesurable {

	/*
	 * Accesseurs
	 */
	E premier();
	K suivants();
	
	default boolean estVide() {
		return this.taille() == 0;
	}
	
	/*
	 * Fabriques
	 */
	K creer();
	@SuppressWarnings("unchecked")
	default K sujet(){
		return (K)this;
	}
}