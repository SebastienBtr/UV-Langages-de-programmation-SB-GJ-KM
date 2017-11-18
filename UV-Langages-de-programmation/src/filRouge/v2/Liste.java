package filRouge.v2;

import java.util.Iterator;

public interface Liste<E> extends Iterable<E> {
	/*
	 * Accesseurs
	 */
	default boolean casVide() {
		return false;
	}
	default E tete() {
		throw new UnsupportedOperationException();
	}
	default Liste<E> reste() {
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
	 * Services
	 */
	default Iterator<E> iterator() {
		return new IterateurListe<E>(this);
	}
	default Liste<E> miroir(){
		Liste<E> r = vide();
		for(E e : this){
			r = cons(e, r);
		}
		return r;
	}
	/*
	 * Fabriques (statiques)
	 */
	
	
	public static <E> Liste<E> vide() {
		return new Liste<E>() {
			@Override
			public boolean casVide(){
				return true;
			}
			@Override
			public int taille() {
				return 0;
			}
			
		};
	}
	
	public static <E> Liste<E> cons(E t, Liste<E> r) {
		return new Liste<E>() {
			private int taille = r.taille() + 1;
			@Override
			public boolean casCons(){
				return true;
			}
			public E tete() {
				return t;
			}
			public Liste<E> reste() {
				return r;
			}
			@Override
			public int taille() {
				return this.taille;
			}
			
		};
	}

	
}
