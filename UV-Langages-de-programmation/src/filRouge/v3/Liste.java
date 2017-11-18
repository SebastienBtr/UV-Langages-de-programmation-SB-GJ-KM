package filRouge.v3;

import java.util.Iterator;

public interface Liste<K extends Liste<K, E>, E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}
	default E tete() {
		throw new UnsupportedOperationException();
	}
	default K reste() {
		throw new UnsupportedOperationException();
	}
	default boolean casCons() {
		return false;
	}
	default public int taille(){
		return 0;
	}
	default public boolean estVide(){
		return this.taille() == 0;
	}
	/*
	 * Fabriques
	 */
	@SuppressWarnings("unchecked")
	default K sujet(){
		return (K)this;
	}
	K creer();
	K creer(E e);
	
	/*
	 * Services
	 */
	default Iterator<E> iterator() {
		return new IterateurListe<K, E>(this.sujet());
	}
	default K miroir(){
		K r = creer();
		for(E e : this){
			r = r.creer(e);
		}
		return r;
	}
	
}
