package filRouge.v4;

import java.util.Iterator;

public interface ListeInductiveMutable<E> extends 
	ListeMutable<ListeInductiveMutable<E>, E>,
	IdentifiableParIteration<ListeInductiveMutable<?>, E>,
	RepresentableParIteration<E>
{

	/*
	 * Accesseurs.
	 */
	@Override
	default void changerReste(ListeInductiveMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Fabriques.
	 */
	@Override
	default ListeInductiveMutable<E> creer() {
		return vide();
	}
	@Override
	default ListeInductiveMutable<E> creer(E e) {
		return cons(e, this);
	}

	
	/*
	 * Services
	 */

	@Override 
	default Iterator<E> iterator() {
		return new IterateurSequence<ListeInductiveMutable<E>, E>(this);
	}
	
	/*
	 * Fabriques statiques.
	 */
	public static <E> ListeInductiveMutable<E> vide() {
		return new ListeInductiveMutable<E>() {
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
				if(!(obj instanceof ListeInductiveMutable<?>))
					return false;
				ListeInductiveMutable<?> l = (ListeInductiveMutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}			
		};
	}
	
	public static <E> ListeInductiveMutable<E> cons(E t, ListeInductiveMutable<E> r) {
		return new ListeInductiveMutable<E>() {
			private E tete = t;
			private ListeInductiveMutable<E> reste = r;
			private int taille = r.taille() + 1;
			@Override
			public boolean casCons(){
				return true;
			}
			public E tete() {
				return this.tete;
			}
			public ListeInductiveMutable<E> reste() {
				return this.reste;
			}
			@Override
			public int taille() {
				return this.taille;
			}
			
			@Override
			public void changerTete(E tete) {
				this.tete = tete;
			}
			@Override
			public void changerReste(ListeInductiveMutable<E> reste) {
				this.reste = reste;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeInductiveMutable<?>))
					return false;
				ListeInductiveMutable<?> l = (ListeInductiveMutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}			
		};
	}


}
