package filRouge.v5;

public interface ListeMutable<E> extends 
	Liste<ListeMutable<E>, E>,
	IdentifiableParIteration<ListeMutable<?>, E>,
	RepresentableParIteration<E>
{

	/*
	 * Accesseurs.
	 */

	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Fabriques.
	 */
	@Override
	default ListeMutable<E> creer() {
		return vide();
	}
	@Override
	default ListeMutable<E> creer(E e) {
		return cons(e, this);
	}

	
	/*
	 * Services
	 */

	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
			@Override
			public boolean casVide(){
				return true;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeMutable<?>))
					return false;
				ListeMutable<?> l = (ListeMutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}	
			
		};
	}
	
	public static <E> ListeMutable<E> cons(E t, ListeMutable<E> r) {
		return new ListeMutable<E>() {
			private E tete = t;
			private ListeMutable<E> reste = r;
			private int taille = r.taille() + 1;
			@Override
			public boolean casCons(){
				return true;
			}
			public E tete() {
				return this.tete;
			}
			public ListeMutable<E> reste() {
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
			public void changerReste(ListeMutable<E> reste) {
				this.reste = reste;
			}
			@Override
			public boolean equals(Object obj){
				if(!(obj instanceof ListeMutable<?>))
					return false;
				ListeMutable<?> l = (ListeMutable<?>)obj;
				return this.estEgal(l);
			}
			@Override
			public String toString() {
				return this.representation();
			}				
		};
	}


}
