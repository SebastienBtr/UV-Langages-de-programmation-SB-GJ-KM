package filRouge.v2;

public interface ListeMutable<E> extends Liste<E>{

	/*
	 * Accesseurs.
	 */
	default ListeMutable<E> reste() {
		throw new UnsupportedOperationException();
	}
	
	default void changerReste(ListeMutable<E> reste) {
		throw new UnsupportedOperationException();
	}
	
	default void changerTete(E tete) {
		throw new UnsupportedOperationException();
	}

	/*
	 * Services
	 */
	default ListeMutable<E> miroir(){
		ListeMutable<E> r = vide();
		for(E e : this){
			r = cons(e, r);
		}
		return r;
	}

	public static <E> ListeMutable<E> vide() {
		return new ListeMutable<E>() {
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
		};
	}


}
