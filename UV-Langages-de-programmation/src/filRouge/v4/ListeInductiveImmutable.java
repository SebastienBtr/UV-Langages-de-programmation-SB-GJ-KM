package filRouge.v4;

import java.util.Iterator;

public interface ListeInductiveImmutable<E> extends 
	ListeImmutable<ListeInductiveImmutable<E>, E>,
	IdentifiableParIteration<ListeInductiveImmutable<?>, E>,
	RepresentableParIteration<E>
{

	/*
	 * Accesseurs.
	 */

	/*
	 * Fabriques
	 */
	
	@Override
	default ListeInductiveImmutable<E> creer() {
		return vide();
	}
	@Override
	default ListeInductiveImmutable<E> creer(E e) {
		return cons(e, this);
	}

	/*
	 * Services
	 */
	@Override 
	default Iterator<E> iterator() {
		return new IterateurSequence<ListeInductiveImmutable<E>, E>(this);
	}
	
	/*
	 * Fabriques statiques.
	 */
	public static <E> ListeInductiveImmutable<E> vide() {
		return new ListeInductiveImmutable<E>() {
			@Override
			public boolean casVide(){
				return true;
			}
			@Override
			public int taille() {
				return 0;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeInductiveImmutable<?>))
					return false;
				ListeInductiveImmutable<?> l = (ListeInductiveImmutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}			
		};
	}
	
	public static <E> ListeInductiveImmutable<E> cons(E t, ListeInductiveImmutable<E> r) {
		return new ListeInductiveImmutable<E>() {
			private ListeInductiveImmutable<E> reste = r;
			private int taille = r.taille() + 1;
			@Override
			public boolean casCons(){
				return true;
			}
			public E tete() {
				return t;
			}
			public ListeInductiveImmutable<E> reste() {
				return this.reste;
			}
			@Override
			public int taille() {
				return this.taille;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeInductiveImmutable<?>))
					return false;
				ListeInductiveImmutable<?> l = (ListeInductiveImmutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}
		};
	}


}
